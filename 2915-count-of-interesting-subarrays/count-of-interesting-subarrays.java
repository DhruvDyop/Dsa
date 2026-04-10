import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L); // base case

        long count = 0;
        int prefix = 0;

        for (int num : nums) {
            // Step 1: convert to 0/1
            if (num % modulo == k) {
                prefix++;
            }

            // Step 2: current mod
            int currMod = prefix % modulo;

            // Step 3: required previous mod
            int needed = (currMod - k + modulo) % modulo;

            // Step 4: add count
            count += map.getOrDefault(needed, 0L);

            // Step 5: update map
            map.put(currMod, map.getOrDefault(currMod, 0L) + 1);
        }

        return count;
    }
}