package th.ac.kmutt.cpe.algorithm.wisit.searching;

import java.util.ArrayList;

public class BinarySearch<T extends Comparable<T>> implements SearchStrategy<T> {

    @Override
    public int search(ArrayList<T> list, T target) {
        if (list == null || list.isEmpty()) {
            return -1;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}