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

### Lab 9 - Greedy Algorithms
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab9\*.java

# Run - Huffman coding example
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab9.HuffmanCoding

# Run - Egyptian fraction example
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab9.EgyptianFraction
```

### Lab 10 - Iterative Improvement (Stable Matching)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab10\*.java

# Run - Gale-Shapley Algorithm for Internship Matching
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab10.Internship
```

### Practice Exercise M.2 – Strategies, D&C, and Applications

Compile all M.2 apps:

```bash
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM2\*.java
```

Run any app (replace <AppClass>):

```bash
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM2.<AppClass>
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

### Practice Exercise M.3
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM3\*.java src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM3\Strategy\*.java src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM3\image\*.java

# Run Wee (Partition Problem)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Wee

# Run GrilledGoose (Unbounded Knapsack Variant)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.GrilledGoose

# Run DragQueen (String Rearrangement)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.DragQueen

# Run TheSalesman (TSP Longest Path)
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.TheSalesman

# Run Image Processing
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy.ImageMain
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
│                           ├── lab/
│                           │   ├── lab4/
│                           │   │   └── Beads.java
│                           │   ├── lab5/
│                           │   │   └── fee/
│                           │       └── Fee.java
│                           │   ├── lab6/
│                           │   │   └── binPacking/
│                           │       ├── BinPackingMain.java
│                           │       └── [other files...]
│                           │   ├── lab7/
│                           │   │   └── binPackingAddMethod/
│                           │       ├── BinPackingMain.java
│                           │       └── [other files...]
│                           │   ├── lab8/
│                           │   │   ├── EOD.java
│                           │   │   ├── Jaothi.java
│                           │   │   └── Zigzag.java
│                           │   ├── lab9/
│                           │   │   ├── EgyptianFraction.java
│                           │   │   ├── HuffmanCoding.java
│                           │   │   └── Lab09-Greedy.pdf
│                           │   └── lab10/
│                           │       ├── Internship.java
│                           │       └── Lab10-IterativeImprovement.pdf
│                           ├── PracticeM2/
│                           │   ├── Q01_NextPermutation.java
│                           │   ├── Q02_Android.java
│                           │   ├── Q03_PancakeSort.java
│                           │   ├── Q04_QuickSelectApp.java
│                           │   ├── Q05_BottomUpMergeSortApp.java
│                           │   ├── Q06_QuickSortApp.java
│                           │   ├── Q07_2DClosestPairApp.java
│                           │   ├── Q08_MakeAWish.java
│                           │   ├── Q09_PresortedUniquenessApp.java
│                           │   ├── Q10_HeapSortApp.java
│                           │   ├── Q11_Lottery.java
│                           │   └── Q12_HashTableApp.java
│                           ├── PracticeM3/
│                           │   ├── Strategy/
│                           │   │   ├── DragQueenAlgo.java
│                           │   │   ├── GrilledGooseAlgo.java
│                           │   │   ├── ImageMain.java
│                           │   │   ├── TheSalesmanAlgo.java
│                           │   │   └── WeeAlgo.java
│                           │   ├── image/
│                           │   │   └── Image.java
│                           │   ├── DragQueen.java
│                           │   ├── GrilledGoose.java
│                           │   ├── TheSalesman.java
│                           │   └── Wee.java
│                           ├── searching/
│                           └── sorting/
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

### Lab 9 - Greedy Algorithms
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab9\*.java

# Run - Huffman coding example
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab9.HuffmanCoding

# Run - Egyptian fraction example
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab9.EgyptianFraction

# Notes: see src/th/ac/kmutt/cpe/algorithm/wisit/lab/lab9/Lab09-Greedy.pdf for problem statements and exact I/O formats.
```

### Lab 10 - Iterative Improvement (Stable Matching)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab10\*.java

# Run - Gale-Shapley Algorithm for Internship Matching
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab10.Internship

# With input file
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\lab\lab10\in1.txt | java -cp bin th.ac.kmutt.cpe.algorithm.wisit.lab.lab10.Internship

# Input format:
# - n (number of companies and students)
# - n lines: company preference lists (n integers each)
# - n lines: student preference lists (n integers each)

# Output: Stable matching pairs (company index, student index)

# Notes: see src/th/ac/kmutt/cpe/algorithm/wisit/lab/lab10/Lab10-IterativeImprovement.pdf for problem statements.
```

### Practice M.2 Q04 – QuickSelect (k-th smallest)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM2\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM2.Q04_QuickSelectApp

# Then input:
# - Number of elements (n) and k (1-based position)
# - n integers (space-separated or newlines)
```

### Practice M.3 - Grilled Goose (DP)
```bash
# Compile
javac -sourcepath src -d bin src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM3\*.java src\th\ac\kmutt\cpe\algorithm\wisit\PracticeM3\Strategy\*.java

# Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.GrilledGoose

# Then input:
# - Number of cities and paths
# - Path details (u v w)
```