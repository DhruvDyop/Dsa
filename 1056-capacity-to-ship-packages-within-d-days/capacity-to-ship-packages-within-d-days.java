class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if(days> n) return -1;

        int start = 0; 
        int end = 0;

        for(int i = 0; i < n; i++){
            start = Math.max(start, weights[i]);
            end += weights[i];
        }

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(checkPackage(weights, days, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;

        
    }
     private boolean checkPackage(int[] weights, int days, int mid){
        int ship = 1;
        int sum = 0;

        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            
            if(sum<=mid){
                continue;
            }

            if(sum > mid){
                ship++;
                sum = weights[i];
            }

            if(ship > days) return false;
        }

        return true;
    }
}