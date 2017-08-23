package leetcode.hashtable;

import java.util.HashMap;

public class ContiguousArray525 {
	public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return max;
    }
}
