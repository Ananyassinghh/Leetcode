class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int[] count = {1, 0};
        int answer = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            answer = (answer + count[1 - (sum & 1)]) % MOD;
            ++count[sum & 1];
        }
        return answer;
    }
}