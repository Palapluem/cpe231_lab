package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.ArrayList;
import java.util.Arrays;

public class TheSalesmanAlgo {
    private int n;
    private int[][] dist;
    private int[][] memo;
    private int[][] nextCity; // เก็บเมืองถัดไปที่ดีที่สุด สำหรับสร้างเส้นทางคำตอบ

    public TheSalesmanAlgo(int n, int[][] dist) {
        this.n = n;
        this.dist = dist;
        this.memo = new int[1 << n][n];
        this.nextCity = new int[1 << n][n];

        // กำหนดค่าเริ่มต้นให้ memo เป็น -1 (ยังไม่เคยคำนวณ)
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
    }

    public int getMaxCost() {
        // เริ่มต้นที่เมือง 0 (THA)
        // mask = 1 (ฐานสอง ...0001) หมายถึงเมืองที่ 0 ถูกเยี่ยมชมแล้ว
        return tsp(1, 0);
    }

    // ฟังก์ชัน Recursive หาค่ามากที่สุด (Longest Path TSP)
    // mask: สถานะการเยี่ยมชมเมือง (บิต 1 = ไปมาแล้ว, 0 = ยังไม่ไป)
    // u: เมืองปัจจุบันที่เราอยู่
    private int tsp(int mask, int u) {
        // Base Case: ถ้า mask มีค่าเท่ากับ (1 << n) - 1 แสดงว่าบิตทุกตัวเป็น 1
        // แปลว่าเราไปครบทุกเมืองแล้ว
        if (mask == (1 << n) - 1) {
            // ตรวจสอบว่ามีทางกลับไปเมืองเริ่มต้น (0) หรือไม่
            // ถ้ามี ให้คืนค่าระยะทางกลับ, ถ้าไม่มี ให้คืนค่าติดลบเยอะๆ (ว่าเป็นไปไม่ได้)
            return dist[u][0] != -1 ? dist[u][0] : -999999;
        }

        // Memoization: ถ้าเคยคำนวณ state นี้แล้ว ให้ใช้ค่าเดิมได้เลย ไม่ต้องคิดใหม่
        if (memo[mask][u] != -1) {
            return memo[mask][u];
        }

        int maxVal = -999999;
        int bestNext = -1;

        // ลองเดินไปเมืองถัดไป (v) ทุกเมืองที่เป็นไปได้
        for (int v = 0; v < n; v++) {
            // เช็ค 2 เงื่อนไข:
            // 1. เมือง v ยังไม่ถูกเยี่ยมชม: เช็คบิตที่ v ว่าเป็น 0 หรือไม่ ((mask & (1 <<
            // v)) == 0)
            // 2. มีเส้นทางจาก u ไป v: dist[u][v] != -1
            if ((mask & (1 << v)) == 0 && dist[u][v] != -1) {

                // คำนวณค่า cost:
                // ค่าเดินจาก u ไป v + ค่าที่ดีที่สุดหลังจาก v ไปจนจบ
                // ส่ง mask | (1 << v) ไปเพื่อบอกว่าเมือง v ถูกเยี่ยมชมแล้ว
                int val = dist[u][v] + tsp(mask | (1 << v), v);

                // หาค่าที่มากที่สุด
                if (val > maxVal) {
                    maxVal = val;
                    bestNext = v;
                }
            }
        }

        // บันทึกเมืองถัดไปที่ดีที่สุดสำหรับ state นี้ (เอาไว้ print path)
        nextCity[mask][u] = bestNext;

        // บันทึกค่า maxVal ลงใน memo และคืนค่ากลับไป
        return memo[mask][u] = maxVal;
    }

    // ฟังก์ชันสำหรับสร้าง String ของเส้นทางเดินจากข้อมูลใน nextCity
    public String getPathString(ArrayList<String> cities) {
        StringBuilder sb = new StringBuilder();
        int mask = 1;
        int u = 0; // เริ่มที่ THA

        sb.append(cities.get(u)).append(" ");

        while (true) {
            // ถ้า mask เต็มแล้ว แสดงว่าครบทุกเมือง
            if (mask == (1 << n) - 1) {
                sb.append("THA"); // กลับมาที่ THA
                break;
            }

            int v = nextCity[mask][u];
            if (v == -1)
                break; // กัน error กรณีไม่มีทางไป

            sb.append(cities.get(v)).append(" ");

            // อัปเดต state ไปเมืองถัดไป
            mask = mask | (1 << v);
            u = v;
        }
        return sb.toString();
    }
}
