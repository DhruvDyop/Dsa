import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[][] starts = new int[n][2];

        // store start and index
        for(int i = 0; i < n; i++){
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // sort by start
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int end = intervals[i][1];

            int idx = binarySearch(starts, end);

            result[i] = idx;
        }

        return result;
    }

    int binarySearch(int[][] starts, int target){

        int left = 0, right = starts.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(starts[mid][0] >= target){
                ans = starts[mid][1];  // store original index
                right = mid - 1;       // try smaller start
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }
}