package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

public enum SearchAlgorithm {
    BINARY_SEARCH(1, "Binary Search",
            "Binary Search - searches a sorted list by repeatedly dividing the search interval in half.");

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
                return new BinarySearchFee();
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