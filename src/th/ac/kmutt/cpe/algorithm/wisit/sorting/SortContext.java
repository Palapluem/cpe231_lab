package th.ac.kmutt.cpe.algorithm.wisit.sorting;

public class SortContext<T extends Comparable<T>> {
    private SortStrategy<T> strategy;

    public SortContext(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public int executeSort(java.util.ArrayList<T> list, T target) {
        return strategy.sort(list, target);
    }
}