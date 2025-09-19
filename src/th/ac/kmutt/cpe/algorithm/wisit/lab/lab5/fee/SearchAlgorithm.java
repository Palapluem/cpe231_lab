package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

import th.ac.kmutt.cpe.algorithm.wisit.searching.BinarySearch;

public enum SearchAlgorithm {
    BINARY_SEARCH(1, "Binary Search", "ค้นหาแบบ Binary Search - เรียงลำดับแล้วค้นหาแบบแบ่งครึ่ง O(log n)");

    private final int id;
    private final String name;
    private final String description;

    SearchAlgorithm(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FeeSearchStrategy createStrategy() {
        switch (this) {
            case BINARY_SEARCH:
                return new BinarySearch();
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + this);
        }
    }

    public static SearchAlgorithm fromId(int id) {
        for (SearchAlgorithm algorithm : values()) {
            if (algorithm.getId() == id) {
                return algorithm;
            }
        }
        return null;
    }
}