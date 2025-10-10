package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

public interface BinPackingAlgorithm {
    BinPackingResult pack(java.util.List<BoxSize> boxes, double binWidth, double binHeight);
}