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

### Practice Exercise M.2 – Strategies, D&C, and Applications

Compile all M.2 apps:

```bash
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\PracticeM2\*.java
```

Run any app (replace <AppClass>):

```bash
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2.<AppClass>
```

Available app classes (renamed with question numbers) and I/O notes:

- Q01_NextPermutation
   - Input: n then n integers. Output: next lexicographic permutation or the first if none.
- Q02_Android
   - Input per worksheet; prints the minimal steps/unlock check as specified.
- Q03_PancakeSort
   - Input: n then n integers. Output: ascending order on one line.
- Q04_QuickSelectApp
   - Input: n, k, then n integers. Output: k-th smallest value.
- Q05_BottomUpMergeSortApp
   - Input: n then n integers. Output: ascending order on one line.
- Q06_QuickSortApp
   - Input: n then n integers. Output: ascending order on one line.
- Q07_2DClosestPairApp
   - Input: n then n pairs x y. Output: minimum distance printed with 3 decimals.
- Q08_MakeAWish
   - Input: n then n integers. Output: maximum subarray sum (long).
- Q09_PresortedUniquenessApp
   - Input: n then n integers. Output: unique values in ascending order.
- Q10_HeapSortApp
   - Input: n then n integers. Output line 1: array after Min-Heap bottom-up heapify; line 2: numbers in descending order.
- Q11_Lottery
   - Input: m n, then student ticket string (length m) and prize pattern (length n).
   - Output: YES <shiftCount> <firstIndex> if matched, else NO <shiftCount> -1.
- Q12_HashTableApp
   - Input: Z n, then n words (uppercase A–Z). Output: a closed-hashing table (size Z) using linear probing; empty slots printed as NULL.

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
│                              ├── lab8/
│                              │   ├── EOD.java
│                              │   ├── Jaothi.java
│                              │   └── Zigzag.java
│                              └── PracticeM2/
│                                  ├── Q01_NextPermutation.java
│                                  ├── Q02_Android.java
│                                  ├── Q03_PancakeSort.java
│                                  ├── Q04_QuickSelectApp.java
│                                  ├── Q05_BottomUpMergeSortApp.java
│                                  ├── Q06_QuickSortApp.java
│                                  ├── Q07_2DClosestPairApp.java
│                                  ├── Q08_MakeAWish.java
│                                  ├── Q09_PresortedUniquenessApp.java
│                                  ├── Q10_HeapSortApp.java
│                                  ├── Q11_Lottery.java
│                                  └── Q12_HashTableApp.java
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

### Practice M.2 Q04 – QuickSelect (k-th smallest)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\PracticeM2\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2.Q04_QuickSelectApp

# Then input:
# - Number of elements (n) and k (1-based position)
# - n integers (space-separated or newlines)
```