class MaximumSubarraySum {
    private static int maximumSubarraySum(int[] arr) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;

        for (int i = 0; i < arr.length; i++) {
            localMax += arr[i];
            globalMax = Integer.max(localMax, globalMax);
            localMax = Integer.max(localMax, 0);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        System.out.println(maximumSubarraySum(arr));
    }
}