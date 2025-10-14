package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

import java.util.ArrayList;
import java.util.List;

public class BestFitAlgorithm implements BinPackingAlgorithm {

    @Override
    public BinPackingResult pack(List<BoxSize> boxes, double binWidth, double binHeight) {
        List<BoxSize> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((b1, b2) -> Double.compare(b2.getArea(), b1.getArea()));

        List<Bin> bins = new ArrayList<>();
        List<BoxSize> unpackedItems = new ArrayList<>();

        for (BoxSize box : sortedBoxes) {
            int bestBinIndex = -1;
            double minRemainingArea = Double.MAX_VALUE;

            for (int i = 0; i < bins.size(); i++) {
                Bin bin = bins.get(i);
                if (bin.canFit(box) && bin.canFitDimensions(box)) {
                    double remainingAfterPlacement = bin.getRemainingArea() - box.getArea();
                    if (remainingAfterPlacement < minRemainingArea) {
                        bestBinIndex = i;
                        minRemainingArea = remainingAfterPlacement;
                    }
                }
            }

            if (bestBinIndex != -1) {
                bins.get(bestBinIndex).addBox(box);
            } else {
                Bin newBin = new Bin(binWidth, binHeight);
                if (newBin.addBox(box)) {
                    bins.add(newBin);
                } else {
                    unpackedItems.add(box);
                }
            }
        }
        return new BinPackingResult(bins, unpackedItems, "Best Fit Algorithm");
    }
}