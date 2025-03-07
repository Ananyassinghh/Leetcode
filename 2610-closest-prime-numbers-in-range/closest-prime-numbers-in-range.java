class Solution {
    public int[] closestPrimes(int left, int right) {
        int primeCount = 0;
        boolean[] sieve = new boolean[right + 1];
        int[] primes = new int[right + 1];
        for (int i = 2; i <= right; ++i) {
            if (!sieve[i]) {
                primes[primeCount++] = i;
            }
            for (int j = 0; primes[j] <= right / i; ++j) {
                sieve[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        int firstPrimeIndex = -1, secondPrimeIndex = -1;
        for (int k = 0; k < primeCount; ++k) {
            if (primes[k] >= left && primes[k] <= right) {
                if (firstPrimeIndex == -1) {
                    firstPrimeIndex = k;
                }
                secondPrimeIndex = k;
            }
        }
        int[] result = new int[] {-1, -1};
        if (firstPrimeIndex == secondPrimeIndex || firstPrimeIndex == -1) {
            return result;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int k = firstPrimeIndex; k < secondPrimeIndex; ++k) {
            int distance = primes[k + 1] - primes[k];
            if (distance < minDistance) {
                minDistance = distance;
                result[0] = primes[k];
                result[1] = primes[k + 1];
            }
        }
        return result;
    }
}