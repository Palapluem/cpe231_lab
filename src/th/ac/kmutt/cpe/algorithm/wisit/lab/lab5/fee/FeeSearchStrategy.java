package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

public interface FeeSearchStrategy {

    int findDomesticCost(java.util.List<CSVReader.EMSDomesticRate> domesticRates, int weight);

    int findWorldCost(java.util.List<CSVReader.EMSWorldRate> worldRates, int weight, int zone);

    String getAlgorithmName();
}