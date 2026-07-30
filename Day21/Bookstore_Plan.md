# Bookstore Lab: Design Recipe (Steps 0-4)

This file is the planning deliverable. Steps 0 to 4 are filled in for you. Your job in lab is **Step 5 (Implement and Test)** and, if there is time, **Step 6 (Iterate and Refine)** -- you write the bodies of the methods whose templates are shown in Step 4.

## Step 0: Understand and restate the problem

> *Build a tiny bookstore that holds a list of items for sale. The bookstore stocks two kinds of items, books and magazines, and supports a few common operations: add an item, sum the prices of every item in stock, list every item, and look up an item by exact name. The lookup throws a custom checked exception when no item matches.*

### Inputs and outputs

* **Inputs:** items constructed in the driver (no `Scanner`, no command-line arguments).
* **Outputs:** text on `System.out` -- a one-line summary per item, the total price of the inventory, and the result of two lookups.

### Edge cases and special cases

* **Empty bookstore.** `totalPrice()` returns `0.0`; `listAll()` prints nothing.
* **Lookup miss.** `findByName(name)` throws `ItemNotFoundException` with a clear message that names the missing item.
* **Bad input at construction.** A null name or a negative price is a programmer error and is rejected at the public boundary with `IllegalArgumentException` (unchecked, so callers do not need to catch it).

## Step 1: Data definitions

* `Item` (abstract class):

  | Field | Type   | Visibility   | Notes |
  |-------|--------|--------------|-------|
  | name  | String | `protected`  | Non-null, non-empty. |
  | price | double | `protected`  | Non-negative. |

* `Book extends Item` adds:

  | Field  | Type   | Visibility | Notes |
  |--------|--------|------------|-------|
  | author | String | `private`  | Non-null, non-empty. |
  | pages  | int    | `private`  | Positive (`> 0`). |

* `Magazine extends Item` adds:

  | Field       | Type | Visibility | Notes |
  |-------------|------|------------|-------|
  | issueNumber | int  | `private`  | Positive (`> 0`). |

* `Bookstore` (concrete class):

  | Field | Type             | Visibility | Notes |
  |-------|------------------|------------|-------|
  | items | `ArrayList<Item>` | `private`  | Initialised to an empty list in the constructor. |

* `ItemNotFoundException`: extends `Exception` (checked). Justification: a lookup miss is a recoverable condition that the caller should be forced to handle, so we want the compiler to enforce a `catch` or a `throws`.

## Step 2: Method signatures and purposes

* `Item`:

    ```java
    public Item(String name, double price)
    // Purpose: validate and store the name and price.
    // @throws IllegalArgumentException on null/empty name or negative price.

    public String getName()
    public double getPrice()

    public abstract String summary();
    // Purpose: return a one-line, human-readable description of this item.
    //          Concrete subclasses MUST override.
    ```

* `Book`:

    ```java
    public Book(String name, double price, String author, int pages)
    // Purpose: super(name, price); validate author and pages; store them.

    public String getAuthor()
    public int    getPages()

    @Override public String summary()
    // Purpose: return "Book: <name> by <author> (<pages> pp, $<price>)".
    ```

* `Magazine`:

    ```java
    public Magazine(String name, double price, int issueNumber)
    // Purpose: super(name, price); validate issueNumber; store it.

    public int getIssueNumber()

    @Override public String summary()
    // Purpose: return "Magazine: <name> (issue #<issueNumber>, $<price>)".
    ```

* `Bookstore`:

    ```java
    public Bookstore()
    // Purpose: create an empty bookstore.

    public void addItem(Item item)
    // Purpose: append item to the inventory.

    public double totalPrice()
    // Purpose: return the sum of every item's price (0.0 for an empty bookstore).

    public void listAll()
    // Purpose: print summary() of every item, in insertion order.

    public Item findByName(String name) throws ItemNotFoundException
    // Purpose: return the first item whose name equals the given name (use .equals).
    // @throws ItemNotFoundException if no matching item exists.

    public int size()
    // Purpose: return the number of items in stock.
    ```

* `ItemNotFoundException`:

    ```java
    public ItemNotFoundException(String message)
    // Purpose: super(message).
    ```

* `BookstoreDriver`:

    ```java
    public static void main(String[] args)
    // Purpose: build a bookstore, add three items (a Book, a Magazine, another Book),
    //          listAll(), print the totalPrice, then run two findByName calls --
    //          one that succeeds and one that misses (caught with try/catch).
    ```

## Step 3: Examples and tests

* `Bookstore.size()` and `Bookstore.totalPrice()`:

  | State | size() | totalPrice() |
  |---|---:|---:|
  | empty | 0 | 0.0 |
  | one Book("Inferno", 12.50, "Dante", 320) | 1 | 12.5 |
  | the Book above + Magazine("Wired", 6.99, 251) | 2 | 19.49 |
  | the two above + Book("Dune", 15.00, "Herbert", 412) | 3 | 34.49 |

* `Bookstore.findByName(name)`:

  | Bookstore state | Action | Expected behaviour |
  |---|---|---|
  | three items as above | `findByName("Wired")` | returns the `Magazine`. |
  | three items as above | `findByName("Atlas")` | throws `ItemNotFoundException`. |

* `Item.summary()` (per subclass):

  | Concrete item | Expected return value |
  |---|---|
  | `Book("Inferno", 12.50, "Dante", 320)` | `Book: Inferno by Dante (320 pp, $12.5)` |
  | `Magazine("Wired", 6.99, 251)` | `Magazine: Wired (issue #251, $6.99)` |
  | `Book("Dune", 15.00, "Herbert", 412)` | `Book: Dune by Herbert (412 pp, $15.0)` |

* End-to-end `BookstoreDriver.main` predicted output (the smallest interesting trace):

    ```text
    Book: Inferno by Dante (320 pp, $12.5)
    Magazine: Wired (issue #251, $6.99)
    Book: Dune by Herbert (412 pp, $15.0)
    total: $34.49
    found: Magazine: Wired (issue #251, $6.99)
    not found: no item named 'Atlas' in bookstore
    ```

## Step 4: Method templates (skeletons)

The skeleton files in this folder are already filled in **down to numbered comments**. Step 5 is to replace every numbered comment with real Java.

### `Item.java`

```java
public abstract class Item {
    protected String name;
    protected double price;

    public Item(String name, double price) {
        // 1. Validate name (not null, not empty); throw IllegalArgumentException.
        // 2. Validate price (>= 0); throw IllegalArgumentException.
        // 3. Assign this.name and this.price.
    }

    public String getName()  { /* return name */ }
    public double getPrice() { /* return price */ }

    public abstract String summary();
}
```

### `Book.java`

```java
public class Book extends Item {
    private String author;
    private int    pages;

    public Book(String name, double price, String author, int pages) {
        // 1. super(name, price).
        // 2. Validate author and pages; throw IllegalArgumentException on bad input.
        // 3. Assign this.author and this.pages.
    }

    public String getAuthor() { /* return author */ }
    public int    getPages()  { /* return pages */ }

    @Override
    public String summary() {
        // 1. Return "Book: " + name + " by " + author + " (" + pages
        //    + " pp, $" + price + ")".
    }
}
```

### `Magazine.java`

```java
public class Magazine extends Item {
    private int issueNumber;

    public Magazine(String name, double price, int issueNumber) {
        // 1. super(name, price).
        // 2. Validate issueNumber (> 0); throw IllegalArgumentException.
        // 3. Assign this.issueNumber.
    }

    public int getIssueNumber() { /* return issueNumber */ }

    @Override
    public String summary() {
        // 1. Return "Magazine: " + name + " (issue #" + issueNumber
        //    + ", $" + price + ")".
    }
}
```

### `ItemNotFoundException.java`

```java
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        // 1. super(message).
    }
}
```

### `Bookstore.java`

```java
public class Bookstore {
    private ArrayList<Item> items;

    public Bookstore() {
        // 1. Initialise items to a new ArrayList<>().
    }

    public void addItem(Item item) {
        // 1. items.add(item).
    }

    public double totalPrice() {
        // 1. Initialise total = 0.0.
        // 2. For each Item it in items, total += it.getPrice().
        // 3. Return total.
    }

    public void listAll() {
        // 1. For each Item it in items, System.out.println(it.summary()).
    }

    public Item findByName(String name) throws ItemNotFoundException {
        // 1. For each Item it in items:
        //      if it.getName().equals(name), return it.
        // 2. If we get here, throw new ItemNotFoundException(
        //      "no item named '" + name + "' in bookstore").
    }

    public int size() {
        // 1. return items.size().
    }
}
```

### `BookstoreDriver.java`

```java
public class BookstoreDriver {
    public static void main(String[] args) {
        // 1. Build an empty Bookstore.
        // 2. Add Book("Inferno", 12.50, "Dante", 320),
        //        Magazine("Wired", 6.99, 251),
        //        Book("Dune", 15.00, "Herbert", 412).
        // 3. Call bookstore.listAll().
        // 4. Print "total: $" + bookstore.totalPrice().
        // 5. Inside try/catch, look up "Wired" and print
        //    "found: " + foundItem.summary().
        // 6. Inside try/catch, look up "Atlas" and let the
        //    catch block print "not found: " + e.getMessage().
    }
}
```

## What to do in lab today

* Open each of the seven `.java` files in this folder.
* Replace every `// 1.`, `// 2.`, ... comment with real Java.
* Run `./compileAndRun.sh`. The output should match the predicted trace in Step 3.
* Read the `Instructions.md` file for submission details.
