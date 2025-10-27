package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.LexicographicPermute;

public class Q02_Android {

    // แปลง permutation 1..n ให้เป็นสตริงตัวอักษร 'A'.. ตามลำดับ
    private static String toAlphaString(List<Integer> perm) {
        StringBuilder sb = new StringBuilder(perm.size());
        for (int v : perm)
            sb.append((char) ('A' + (v - 1)));
        return sb.toString();
    }

    // ตรวจความถูกต้องง่ายๆ: ความยาวตรง, อยู่ในช่วง A..A+n-1, ไม่ซ้ำ
    private static boolean isValid(String s, int n) {
        if (s.length() != n)
            return false;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'A';
            if (x < 0 || x >= n || used[x])
                return false;
            used[x] = true;
        }
        return true;
    }

    // คืนค่าอันดับแบบ 1-indexed ของสตริง perm ในลำดับ lexicographic
    // โดยอาศัยตัวสร้าง LexicographicPermute
    private static long rankLexicographic(String perm, int n) {
        if (!isValid(perm, n))
            return -1L;
        LexicographicPermute gen = new LexicographicPermute();
        List<List<Integer>> all = gen.generatePermutations(n);
        long rank = 1L;
        for (List<Integer> p : all) {
            if (toAlphaString(p).equals(perm))
                return rank;
            rank++;
        }
        return -1L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine().trim();
        String[] parts = first.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            while (line != null && line.trim().isEmpty()) {
                if (!sc.hasNextLine()) {
                    line = null;
                    break;
                }
                line = sc.nextLine();
            }
            if (line == null)
                break;
            patterns.add(line.trim());
        }
        sc.close();

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < patterns.size(); i++) {
            long rank = rankLexicographic(patterns.get(i), n);
            out.append(rank);
            if (i + 1 < patterns.size())
                out.append('\n');
        }
        System.out.print(out.toString());
    }
}