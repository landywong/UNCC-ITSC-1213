// BUG #1: MenuItem.java Line 15, runtime error, MenuItem() method lacks validation 
for empty names and negative prices. Added validation for said cases using throw.

// BUG #2: Pastry.java Line 20, logic error, Missing override on top of the
describe() method. While it still complies, adding the @Override now calls
java to scan for a match in the superclass. 

// BUG #3: Inventory.java Line 30, logic error, for loop in the lookup()
method is misconfigured. Removed = from  for loop range, restoring
index.

// BUG #4: Inventory.java Line 39, logic error,
if statement in the lookup() method is misconfigured. Changed "=="
to ".equals()" as we are comparing Strings rather than integers. 

// BUG #5 CoffeeShop.java Line 30, runtime error, exception found when
creating a Drink class. Implemented a try-catch that validates the
cases from BUG #1.

// BUG #6: CoffeeShop.java Line 69, runtime error, try-catch does
not match the same exception received. Added IndexOutOfBoundsException to 
catch list containing only OutOfStockException.