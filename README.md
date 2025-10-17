# CPE231 Algorithms Lab

This repository contains laboratory exercises for CPE231 Algorithms course, Semester 1/2025. The labs cover various algorithmic concepts including Object-Oriented Programming (OOP), Strategy patterns (Sorting, Searching), and Dynamic Programming.

## How to Compile and Run

### Compilation

```bash
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\<folder>\*.java
```

### Execution

```bash
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.<folder_and_filename>
```

## Available Labs

### Lab 4 - Brute Force & Exhaustive Search
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab4\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab4.Beads
```

### Lab 5 - Strategies
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab5\fee\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee.Fee
```

### Lab 6 - Bin Packing
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab6\binPacking\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking.BinPackingMain
```

### Lab 7 - Bin Packing (Extended)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab7\binPackingAddMethod\*.java

# Run - Main Program
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod.BinPackingMain

# Run - Modified Version (Show Bin 1 Only)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod.BinPackingMainModify
```

### Lab 8 - Dynamic Programming
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab8\*.java

# Run Zigzag
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab8.Zigzag

# Run Jaothi (Knapsack Problem)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab8.Jaothi

# Run EOD (Explosive Ordnance Disposal)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab8.EOD
```

## Project Structure

```
Algorithm_Lab/
├── bin/ (created after compilation)
├── src/
│   └── th/
│       └── ac/
│           └── kmutt/
│               └── cpe/
│                   └── algorithm/
│                       └── wisit/
│                           ├── Main.java
│                           └── lab/
│                              ├── lab4/
│                              │   └── Beads.java
│                              ├── lab5/
│                              │   └── fee/
│                              │       └── Fee.java
│                              ├── lab6/
│                              │   └── binPacking/
│                              │       ├── BinPackingMain.java
│                              │       ├── Bin.java
│                              │       ├── BoxSize.java
│                              │       └── [other files...]
│                              ├── lab7/
│                              │   └── binPackingAddMethod/
│                              │       ├── BinPackingMain.java
│                              │       ├── BinPackingMainModify.java
│                              │       └── [other files...]
│                              └── lab8/
│                                  ├── EOD.java
│                                  ├── Jaothi.java
│                                  └── Zigzag.java
└── README.md
```

## Important Notes

1. **Create bin directory**: If the `bin` directory doesn't exist, create it first:
   ```bash
   mkdir bin
   ```

2. **Input Files**: For Bin Packing Labs, you need CSV files containing box dimension data such as:
   - `boxSize1.csv`
   - `boxSize2.csv` 
   - `boxSize3.csv`

3. **Input Methods**: Most programs accept input from standard input or files

## Usage Examples

### Lab 6 Bin Packing
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab6\binPacking\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking.BinPackingMain

# Then input:
# - CSV filename (e.g., boxSize1.csv)
# - Bin width and height
```

### Lab 8 Jaothi (Knapsack Problem)
```bash
# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab8.Jaothi

# Then input:
# - Number of items and capacity
# - Weight and value pairs for each item
```

### Lab 8 EOD (Explosive Ordnance Disposal)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab8\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab8.EOD

# Then input:
# - Number of bombs (n)
# - Value of each bomb (n values)
```