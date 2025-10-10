package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

import java.util.List;

public class BinPackingResult {
    private final List<Bin> bins;
    private final List<BoxSize> unpackedItems;
    private final String algorithmUsed;

    public BinPackingResult(List<Bin> bins, List<BoxSize> unpackedItems,
            String algorithmUsed) {
        this.bins = bins;
        this.unpackedItems = unpackedItems;
        this.algorithmUsed = algorithmUsed;
    }

    public List<Bin> getBins() {
        return bins;
    }

    public List<BoxSize> getUnpackedItems() {
        return unpackedItems;
    }

    public String getAlgorithmUsed() {
        return algorithmUsed;
    }

    public int getTotalBinsUsed() {
        return bins.size();
    }

    public double getAverageUtilization() {
        return bins.stream()
                .mapToDouble(Bin::getUtilization)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("BinPackingResult{algorithm='%s', bins=%d, unpacked=%d, avgUtil=%.1f%%}",
                algorithmUsed, bins.size(), unpackedItems.size(), getAverageUtilization());
    }
}