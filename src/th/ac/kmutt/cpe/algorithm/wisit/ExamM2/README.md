# 🚀 Compile & Run Guide - Exam M2

> **📚 สำหรับรายละเอียดโจทย์ อัลกอริทึม และผลลัพธ์ทุก test case:**  
> **👉 ดูที่ [README_Exam2.md](README_Exam2.md)**

---

## 📌 ตั้งค่าเบื้องต้น

ก่อนรันครั้งแรก ต้องสร้าง directory `bin` สำหรับเก็บไฟล์ `.class`:

```cmd
cd d:\Algorithm_Lab
mkdir bin
```

---

## 🔨 Compile

### Compile ทั้ง 2 ข้อพร้อมกัน:
```cmd
javac -sourcepath src -d bin src/th/ac/kmutt/cpe/algorithm/wisit/ExamM2/*.java
```

### หรือ Compile แยกทีละข้อ:

**ข้อ 1: Histogram Select**
```cmd
javac -sourcepath src -d bin src/th/ac/kmutt/cpe/algorithm/wisit/ExamM2/Exam1_HistogramSelect.java
```

**ข้อ 2: Sand**
```cmd
javac -sourcepath src -d bin src/th/ac/kmutt/cpe/algorithm/wisit/ExamM2/Exam2_Sand.java
```

---

## ▶️ Run with Test Cases

### 🪟 สำหรับ CMD (Command Prompt)

#### ข้อ 1: Histogram Select
```cmd
REM ตัวอย่าง: Test in1.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in1.txt

REM ตัวอย่าง: Test in2.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in2.txt

REM ตัวอย่าง: Test in10.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in10.txt
```

#### ข้อ 2: Sand
```cmd
REM ตัวอย่าง: Test in1.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in1.txt

REM ตัวอย่าง: Test in2.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in2.txt

REM ตัวอย่าง: Test bonus1.txt
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\bonus1.txt
```

---

### 🔵 สำหรับ PowerShell

**⚠️ สำคัญ:** PowerShell ไม่รองรับ `<` ต้องใช้ `Get-Content` แทน!

#### ข้อ 1: Histogram Select
```powershell
# ตัวอย่าง: Test in1.txt
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in1.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect

# ตัวอย่าง: Test in2.txt
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in2.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect
```

#### ข้อ 2: Sand
```powershell
# ตัวอย่าง: Test in1.txt
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in1.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand

# ตัวอย่าง: Test in2.txt
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in2.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand

# ตัวอย่าง: Test bonus1.txt
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\bonus1.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand
```

---

### 🔄 รัน Test Cases ทั้งหมดด้วย Loop

#### PowerShell: ข้อ 1 (in1-in10)
```powershell
for ($i=1; $i -le 10; $i++) {
    Write-Host "Test in$i.txt:" -ForegroundColor Yellow
    Get-Content "src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testOne\in$i.txt" | `
        java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam1_HistogramSelect
}
```

#### PowerShell: ข้อ 2 (in1-in10)
```powershell
for ($i=1; $i -le 10; $i++) {
    Write-Host "Test in$i.txt:" -ForegroundColor Yellow
    Get-Content "src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in$i.txt" | `
        java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand
}
```

#### PowerShell: ข้อ 2 Bonus Cases
```powershell
Write-Host "Test bonus1.txt:" -ForegroundColor Cyan
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\bonus1.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand

Write-Host "Test bonus2.txt:" -ForegroundColor Cyan
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\bonus2.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand
```

---

## 📋 สรุปคำสั่งแบบสั้น

### ✅ CMD (แนะนำ)
```cmd
cd d:\Algorithm_Lab

REM Compile
javac -sourcepath src -d bin src/th/ac/kmutt/cpe/algorithm/wisit/ExamM2/*.java

REM Run
java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand < src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in1.txt
```

### ✅ PowerShell
```powershell
cd d:\Algorithm_Lab

# Compile
javac -sourcepath src -d bin src/th/ac/kmutt/cpe/algorithm/wisit/ExamM2/*.java

# Run
Get-Content src\th\ac\kmutt\cpe\algorithm\wisit\ExamM2\testTwo\in1.txt | `
    java -cp bin th.ac.kmutt.cpe.algorithm.wisit.ExamM2.Exam2_Sand
```

---

## 🔍 Tips & Troubleshooting

### ❌ Error: "package does not exist"
```
Solution: ใช้ -sourcepath src -d bin
```

### ❌ Error: "class not found"
```
Solution: ใช้ -cp bin แทน -classpath
```

### ❌ PowerShell: "The '<' operator is reserved"
```
Solution: ใช้ Get-Content ... | java แทน java ... <
```

---

## 🎯 Quick Reference

| Task | CMD | PowerShell |
|------|-----|------------|
| **Compile** | `javac -sourcepath src -d bin ...` | เหมือนกัน |
| **Run (input)** | `java -cp bin ... < file.txt` | `Get-Content file.txt \| java -cp bin ...` |
| **Path separator** | `\` (backslash) | `\` (backslash) |

---

**Last Updated:** November 12, 2025  
**Working Directory:** `d:\Algorithm_Lab`
