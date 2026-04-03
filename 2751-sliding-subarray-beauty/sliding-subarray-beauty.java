class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int[] freq = new int[101]; // index shift: num + 50

        int l = 0;

        for(int r = 0; r < n; r++){
            // add current element
            freq[nums[r] + 50]++;

            // maintain window size
            if(r - l + 1 > k){
                freq[nums[l] + 50]--;
                l++;
            }

            // when window is valid
            if(r - l + 1 == k){
                int count = 0;

                // check negatives from -50 → -1
                for(int i = 0; i < 50; i++){
                    count += freq[i];

                    if(count >= x){
                        ans[l] = i - 50; // convert back
                        break;
                    }
                }
                // if not found → default 0
            }
        }

        return ans;
    }
}