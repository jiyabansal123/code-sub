class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    long windowSum = 0;
    long maxSum = 0;
    for (int i = 0; i < k; i++) {
        freq.merge(nums[i], 1, Integer::sum);
        windowSum += nums[i];
    }
    if (freq.size() == k) maxSum = windowSum;
    for (int i = k; i < nums.length; i++) {
        freq.merge(nums[i], 1, Integer::sum);
        windowSum += nums[i];
        int outVal = nums[i - k];
        freq.merge(outVal, -1, Integer::sum);
        if (freq.get(outVal) == 0) freq.remove(outVal);
        windowSum -= outVal;
        if (freq.size() == k)
            maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
}