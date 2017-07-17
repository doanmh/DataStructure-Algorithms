package leetcode.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK560 {
	public int subarraySumSlow(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j< nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
	
	public int subarraySumFast(int[] nums, int k) {
        int count = 0; int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
