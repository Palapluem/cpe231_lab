package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class SandSort {
    private ArrayList<Long> heap;

    private void swap(int i, int j) {
        long temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int i) {
        int n = heap.size();
        while (true) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < n && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void insert(long value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private long extractMin() {
        long min = heap.get(0);
        int last = heap.size() - 1;
        heap.set(0, heap.get(last));
        heap.remove(last);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return min;
    }

    public long sandSort(int n, ArrayList<Long> A) {
        heap = new ArrayList<>(A);

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }

        long total = 0L;

        while (heap.size() > 1) {
            long a = extractMin();
            long b = extractMin();
            long sum = a + b;
            total += sum;
            insert(sum);
        }
        return total;
    }
}