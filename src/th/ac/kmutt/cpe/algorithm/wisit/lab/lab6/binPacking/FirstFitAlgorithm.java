package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

import java.util.ArrayList;
import java.util.List;

public class FirstFitAlgorithm implements BinPackingAlgorithm {

    @Override
    public BinPackingResult pack(List<BoxSize> boxes, double binWidth, double binHeight) {
        List<BoxSize> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((b1, b2) -> {
            double area1 = b1.getWidth() * b1.getHeight();
            double area2 = b2.getWidth() * b2.getHeight();
            return Double.compare(area2, area1);
        });

        List<Bin> bins = new ArrayList<>();
        List<BoxSize> unpackedItems = new ArrayList<>();

        for (BoxSize box : sortedBoxes) {
            boolean placed = false;

            for (Bin bin : bins) {
                if (bin.canFit(box) && bin.canFitDimensions(box)) {
                    if (bin.addBox(box)) {
                        placed = true;
                        break;
                    }
                }
            }

            if (!placed) {
                Bin newBin = new Bin(binWidth, binHeight);
                if (newBin.addBox(box)) {
                    bins.add(newBin);
                } else {
                    unpackedItems.add(box);
                    System.out.println("Box " + box.getWidth() + "x" + box.getHeight() + " could not be placed");
                }
            }
        }

        return new BinPackingResult(bins, unpackedItems, "First Fit Decreasing Algorithm");
    }
}