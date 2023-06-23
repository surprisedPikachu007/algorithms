class LongestIncreasingPath {

    public static int dfs(int arr[][], int mem[][], int i, int j, int m, int n) {

        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int val = arr[i][j];

        int t1 = i < m - 1 && arr[i + 1][j] > val ? dfs(arr, mem, i + 1, j, m, n) : 0;
        int t2 = i > 0 && arr[i - 1][j] > val ? dfs(arr, mem, i - 1, j, m, n) : 0;

        int t3 = j < n - 1 && arr[i][j + 1] > val ? dfs(arr, mem, i, j + 1, m, n) : 0;
        int t4 = j > 0 && arr[i][j - 1] > val ? dfs(arr, mem, i, j - 1, m, n) : 0;

        mem[i][j] = 1 + Math.max(Math.max(t1, t2), Math.max(t3, t4));

        return mem[i][j];
    }

    public static int longestIncreasingPath(int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        int result = 0;
        int start = 0, end = 0;

        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = dfs(arr, mem, i, j, m, n);
                if (k > result) {
                    result = k;
                    start = i;
                    end = j;
                }
            }
        }

        printPath(arr, m, n, mem, start, end, result);
        return result;
    }

    private static void printPath(int[][] arr, int m, int n, int[][] mem, int start, int end, int result) {
        int[] path = new int[result];
        path[result - 1] = arr[start][end];

        while (result > 1) {
            // above
            if (start > 0 && mem[start - 1][end] == result - 1) {
                path[result - 2] = arr[start - 1][end];
                start--;
            }

            // below
            else if (start < m - 1 && mem[start + 1][end] == result - 1) {
                path[result - 2] = arr[start + 1][end];
                start++;
            }

            // left
            else if (end > 0 && mem[start][end - 1] == result - 1) {
                path[result - 2] = arr[start][end - 1];
                end--;
            }

            // right
            else if (end < n - 1 && mem[start][end + 1] == result - 1) {
                path[result - 2] = arr[start][end + 1];
                end++;
            }

            result--;
        }

        for (int i = path.length - 1; i >= 0; i--) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 },
        };

        System.out.println(longestIncreasingPath(arr));
    }
}
