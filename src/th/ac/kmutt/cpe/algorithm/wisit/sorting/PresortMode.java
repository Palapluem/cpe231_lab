package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class PresortMode {
    public int presortMode(ArrayList<Integer> A) {
        int n = A.size();

        // sort the array A
        Collections.sort(A);

        // i ← 0
        int i = 0;

        // modefrequency ← 0 //highest frequency seen so far
        int modefrequency = 0;
        int modevalue = 0;

        // while i ≤ n - 1 do
        while (i <= n - 1) {
            // runlength ← 1; runvalue ← A[i] //current run begins at position i
            int runlength = 1;
            int runvalue = A.get(i);

            // while i + runlength ≤ n - 1 and A[i + runlength] = runvalue
            while (i + runlength <= n - 1 && A.get(i + runlength).equals(runvalue)) {
                // runlength ← runlength + 1
                runlength = runlength + 1;
            }

            // if runlength > modefrequency
            if (runlength > modefrequency) {
                // modefrequency ← runlength; modevalue ← runvalue
                modefrequency = runlength;
                modevalue = runvalue;
            }

            // i ← i + runlength
            i = i + runlength;
        }

        // return modevalue
        return modevalue;
    }
}
