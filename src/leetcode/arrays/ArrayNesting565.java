package leetcode.arrays;

public class ArrayNesting565 {
	public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] cache = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prevValue = nums[i];
            if (!cache[prevValue]) {
                int currentLength = 1;
                while (nums[prevValue] != nums[i]) {
                    cache[prevValue] = true;
                    prevValue = nums[prevValue];
                    currentLength++;  
                }
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
}
