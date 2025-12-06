package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class DragQueenAlgo {
    public String dragQueen(String s) {
        // 1. นับความถี่
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // 2. หาตัวที่มีความถี่มากที่สุด
        int maxFreq = 0;
        int maxCharIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
                maxCharIndex = i;
            }
        }

        // 3. เช็คว่าเป็นไปได้ไหม (ถ้าตัวมากสุด เกินครึ่ง+1 คือจบ)
        if (maxFreq > (s.length() + 1) / 2) {
            return "IMPOSSIBLE";
        }

        // 4. สร้างอาร์เรย์ผลลัพธ์
        char[] res = new char[s.length()];
        int index = 0;

        // 5. วางตัวที่มากที่สุดก่อน (ลงช่องคู่: 0, 2, 4...)
        while (count[maxCharIndex] > 0) {
            res[index] = (char) (maxCharIndex + 'a');
            index += 2;
            count[maxCharIndex]--;
        }

        // 6. วางตัวที่เหลือ (ตัวไหนก็ได้)
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                // ถ้า index เกินความยาว (แปลว่าช่องคู่เต็มแล้ว) ให้กลับมาเริ่มที่ช่องคี่ (1)
                if (index >= s.length()) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }

        return new String(res);
    }
}
