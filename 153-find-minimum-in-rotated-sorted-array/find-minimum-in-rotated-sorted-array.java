class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Min is in right half
                left = mid + 1;
            } else {
                // Min is in left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }
}