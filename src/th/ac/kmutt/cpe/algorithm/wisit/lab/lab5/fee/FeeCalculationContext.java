package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

import java.util.List;

public class FeeCalculationContext {

    private FeeSearchStrategy strategy;
    private CSVReader.EMSData emsData;

    public FeeCalculationContext(FeeSearchStrategy strategy) {
        this.strategy = strategy;
        try {
            this.emsData = CSVReader.loadEMSData();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load EMS data: " + e.getMessage(), e);
        }
    }

    public void setStrategy(FeeSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public FeeSearchStrategy getStrategy() {
        return strategy;
    }

    public String findDomesticCost(int weight) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set");
        }

        List<CSVReader.EMSDomesticRate> domesticRates = emsData.getDomesticRates();
        int cost = strategy.findDomesticCost(domesticRates, weight);

        if (cost != -1) {
            return cost + " Baht";
        } else {
            return "No rate found for this weight range";
        }
    }

    public String findWorldCost(int weight, int zone) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set");
        }

        List<CSVReader.EMSWorldRate> worldRates = emsData.getWorldRates();
        int cost = strategy.findWorldCost(worldRates, weight, zone);

        if (cost == -1) {
            return "No rate found for this weight range";
        } else if (cost == -2) {
            return "Shipping to this zone is not available for this weight range";
        } else {
            return cost + " Baht";
        }
    }

    public String getCurrentAlgorithmName() {
        if (strategy == null) {
            return "No strategy set";
        }
        return strategy.getAlgorithmName();
    }
}