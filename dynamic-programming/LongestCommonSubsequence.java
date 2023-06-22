class LongestCommonSubsequence {
    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int arr[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Integer.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[m][n];
    }

    public static void main(String[] args) {
        String s1 = "MQKABCLJH";
        String s2 = "XAYZBZCYX";

        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
