package th.ac.kmutt.cpe.algorithm.wisit.sorting;

public class HashFunction {

    private int m; // hash table size

    public HashFunction(int m) {
        this.m = m;
    }

    public int hashInteger(int K) {
        return K % m;
    }

    public int hashString(String K) {
        int sum = 0;

        // Calculate sum of character positions (ASCII values)
        for (int i = 0; i < K.length(); i++) {
            sum += (int) K.charAt(i); // ord(ci)
        }

        return sum % m;
    }

    public int hashStringPolynomial(String K) {
        int hash = 0;
        int prime = 31; // commonly used prime number

        for (int i = 0; i < K.length(); i++) {
            hash = (hash * prime + (int) K.charAt(i)) % m;
        }

        return hash;
    }

    public void setTableSize(int newSize) {
        this.m = newSize;
    }

    public int getTableSize() {
        return m;
    }
}
