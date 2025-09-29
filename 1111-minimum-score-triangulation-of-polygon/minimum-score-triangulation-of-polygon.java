import java.util.Arrays;

public class Solution {
    private int[][] dp = new int[101][101];

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return util(values, 1, n - 1);
    }

    private int util(int[] values, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp =
                    util(values, i, k)
                            + util(values, k + 1, j)
                            + (values[i - 1] * values[k] * values[j]);

            ans = Math.min(ans, temp);
            dp[i][j] = ans;
        }
        return dp[i][j];
    }
}