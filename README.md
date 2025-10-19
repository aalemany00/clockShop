# Clock Shop Assignment

A Java assignment implementing Clock and ClockShop classes for managing a collection of clocks with sorting, searching, and file I/O.

## Project Structure

- `src/` - Source code files
  - `Clock.java` - Represents a single clock with hour, minute, second
  - `ClockShop.java` - Manages a collection of Clock objects
  - `ClockTests.java` - Unit tests for Clock class
  - `ClockShopTests.java` - Unit tests for ClockShop class
- `input/` - Sample input files for testing
- `output/` - Expected output files

## Features

- Clock class with time validation and manipulation
- ClockShop class with sorting, searching, and file I/O capabilities
- Reads clock times from input files (format: hh:mm:ss)
- Sorts clocks in ascending order
- Searches for specific clocks in the collection
- Writes clock data to output files

## How to Run

Compile and run the test files:
```
javac src/*.java
java src.ClockTests
java src.ClockShopTests
```

## Skills Demonstrated

- Object-oriented programming
- ArrayLists and array manipulation
- File I/O in Java
- Sorting and searching algorithms
- Exception handling
