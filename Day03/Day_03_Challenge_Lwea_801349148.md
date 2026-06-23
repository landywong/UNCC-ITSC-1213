# Day 03 Lab Challenge: Zoo Event Logs (Steps 1 to 4)

This challenge asks you to apply the **Design Recipe** (the same one introduced in Day 02 and recapped in `Class/0_Markdowns/`) to a small problem about zoo event logs. **Only Steps 1 to 4** are in scope; you will not implement, run, or test the code in this lab. We will return to Step 5 (implementation) in a later session.

Most of the document below is already filled in. **Your job is to complete the small number of fields marked with `___`.** The total amount of writing is intentionally small. Read the surrounding context for each blank and fill it in with the value, type, or short snippet that fits.

The example uses Python type hints because the Design Recipe is language-agnostic and Python's annotations make the inputs and outputs easier to skim. We will translate this kind of plan into Java in later modules.

## Problem context

We work with a list of log entries from a zoo. Each entry is a structured list with exactly three elements:

```python
[time, animal, event]
# Example
[25, "Lion", "feeding"]
```

Five small tasks (A through E) operate on a log of these entries. The Design Recipe walk-through follows.

## Step 1: Data Definitions

| Name   | Type      | Description                                       |
| ------ |-----------| ------------------------------------------------- |
| time   | integer   | Time of the event in 24h format (time >= 0)       |
| animal | string    | One-word name of the animal (non-empty string)    |
| event  | string    | One-word description of the event (non-empty)     |
| log    | **array** | A list of `[time, animal, event]` entries        |

> **Fill in:** the `Type` cell of `log`.

## Step 2: Method Signatures and Purpose Statements

Each task below has a function signature and a short purpose docstring. Fill in the missing return type for the two tasks where you see `___`.

### Task A: Count Escapes

```python
def count_escapes(log: list[list]) -> _int_:
    """
    Count the number of 'escape' events in the log.

    Args:
        log: A list of [time, animal, event] entries.

    Returns:
        An integer representing the total number of 'escape' events.
    """
```

### Task B: Gather Feeding Times

```python
def gather_feeding_times(log: list[list]) -> list[int]:
    """
    Collect all timestamps where a 'feeding' event occurred.

    Args:
        log: A list of [time, animal, event] entries.

    Returns:
        A list of integers representing feeding times.
    """
```

### Task C: Earliest Escape Time

```python
def earliest_escape_time(log: list[list]) -> _int_:
    """
    Find the earliest timestamp for an 'escape' event.

    Args:
        log: A list of [time, animal, event] entries.

    Returns:
        The smallest time of all 'escape' events, or -1 if none exist.
    """
```

### Task D: Count Animal Events

```python
def count_animal_events(log: list[list], animal: str) -> int:
    """
    Count the number of log entries involving the given animal.

    Args:
        log: A list of [time, animal, event] entries.
        animal: A string representing the animal's name.

    Returns:
        Number of log entries that involve the specified animal.
    """
```

### Task E: List Animals for an Event

```python
def list_animals_for_event(log: list[list], event_type: str) -> list[str]:
    """
    List distinct animals that had a specific event.

    Args:
        log: A list of [time, animal, event] entries.
        event_type: The event type to filter by.

    Returns:
        A list of unique animal names for the specified event type.
    """
```

> **Fill in:** the return types for `count_escapes` (Task A) and `earliest_escape_time` (Task C).

## Step 3: Examples and Tests

For each task, complete the missing **Expected Output** cells.

### Task A: `count_escapes`

| Case Type | Input                                                  | Expected Output | Notes              |
| --------- | ------------------------------------------------------ |-----------------| ------------------ |
| Edge      | `[]`                                                   | **_null_**      | Empty log          |
| Normal    | `[[10,"Lion","feeding"],[15,"Elephant","escape"]]`     | `1`             | One escape         |
| Normal    | `[[10,"Lion","feeding"],[15,"Elephant","feeding"]]`    | `0`             | No escape events   |

### Task B: `gather_feeding_times`

| Case Type | Input                                                | Expected Output |
| --------- | ---------------------------------------------------- | -------------- |
| Normal    | `[[10,"Lion","feeding"],[20,"Penguin","feeding"]]`   | `[10, 20]`     |
| Edge      | `[]`                                                 | **_Empty log_**         |

### Task C: `earliest_escape_time`

| Case Type | Input                                                | Expected Output |
| --------- | ---------------------------------------------------- |-----------------|
| Normal    | `[[10,"Elephant","escape"], [5,"Lion","escape"]]`    | `5`             |
| Edge      | `[[10,"Lion","feeding"]]`                            | **_-1_**        |

### Task D: `count_animal_events`

| Case Type | Input                                                       | Expected Output |
| --------- | ----------------------------------------------------------- | --------------- |
| Normal    | `[[10,"Lion","feeding"], [20,"Lion","escape"]]`, `"Lion"`   | `2`             |
| Normal    | `[[10,"Lion","feeding"], [20,"Tiger","escape"]]`, `"Tiger"` | `1`             |

### Task E: `list_animals_for_event`

| Case Type | Input                                                                                | Expected Output       |
| --------- | ------------------------------------------------------------------------------------ |-----------------------|
| Normal    | `[[10,"Lion","feeding"],[15,"Penguin","feeding"],[20,"Lion","escape"]]`, `"feeding"` | `["Lion", "Penguin"]` |
| Edge      | `[]`, `"escape"`                                                                     | **_Empty log_**       |

> **Fill in:** the four `Expected Output` cells marked above.

## Step 4: Skeleton and Method Template

Fill in the missing pieces in each skeleton.

### Task A skeleton

```python
def count_escapes(log: list[list]) -> int:
    count = 0
    for entry in log:
        time, animal, event = entry
        if event == _"escape"_:
            count += 1
    return count
```

> **Fill in:** the literal that the comparison checks against.

### Task B skeleton

```python
def gather_feeding_times(log: list[list]) -> list[int]:
    feeding_times = []
    for entry in log:
        time, animal, event = entry
        if event == "feeding":
            feeding_times.append(time)
    return feeding_times
```

### Task C skeleton

```python
def earliest_escape_time(log: list[list]) -> int:
    escape_times = [time for time, animal, event in log if event == "escape"]
    if not escape_times:
        return _-1_
    return min(escape_times)
```

> **Fill in:** the value returned when there are no escape events.

### Task D skeleton

```python
def count_animal_events(log: list[list], animal: str) -> int:
    return sum(1 for time, a, event in log if a == animal)
```

### Task E skeleton

```python
def list_animals_for_event(log: list[list], event_type: str) -> list[str]:
    return list(set(a for time, a, event in log if event == event_type))
```

## Summary of what to fill in

You should have made changes in **eight** spots total:

* Step 1: one `Type` cell.
* Step 2: two return types.
* Step 3: four `Expected Output` cells.
* Step 4: one literal in Task A and one return value in Task C.

Save this file with your name, like `Day_03_Challenge_<lastname>_<800id>.md`, and include it in the ZIP you submit on Canvas. See `Instructions.md` for packaging details.
