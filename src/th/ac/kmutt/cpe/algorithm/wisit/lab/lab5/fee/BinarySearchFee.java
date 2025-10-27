package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchFee implements FeeSearchStrategy {

    @Override
    public String getAlgorithmName() {
        return "Binary Search";
    }

    @Override
    public int findDomesticCost(List<CSVReader.EMSDomesticRate> rates, int weight) {
        if (rates == null || rates.isEmpty()) {
            return -1;
        }

        List<CSVReader.EMSDomesticRate> sortedRates = new ArrayList<>(rates);
        Collections.sort(sortedRates, Comparator.comparingInt(CSVReader.EMSDomesticRate::getFrom));

        int left = 0;
        int right = sortedRates.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            CSVReader.EMSDomesticRate rate = sortedRates.get(mid);

            if (weight >= rate.getFrom() && weight <= rate.getTo()) {
                return rate.getCost();
            }

            // If weight is less than current range, search in lower range
            if (weight < rate.getFrom()) {
                right = mid - 1;
            }
            // If weight is greater than current range, search in higher range
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public int findWorldCost(List<CSVReader.EMSWorldRate> rates, int weight, int zone) {
        if (rates == null || rates.isEmpty()) {
            return -1;
        }

        List<CSVReader.EMSWorldRate> sortedRates = new ArrayList<>(rates);
        Collections.sort(sortedRates, Comparator.comparingInt(CSVReader.EMSWorldRate::getFrom));

        int left = 0;
        int right = sortedRates.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            CSVReader.EMSWorldRate rate = sortedRates.get(mid);

            if (weight >= rate.getFrom() && weight <= rate.getTo()) {
                if (!rate.isZoneAvailable(zone)) {
                    return -2;
                }
                return rate.getZoneCost(zone);
            }

            if (weight < rate.getFrom()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
