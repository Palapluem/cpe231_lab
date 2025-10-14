package th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod;

public interface BinPackingAlgorithm {
    BinPackingResult pack(java.util.List<BoxSize> boxes, double binWidth, double binHeight);
}