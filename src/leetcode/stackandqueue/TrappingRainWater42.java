package leetcode.stackandqueue;

import java.util.Stack;

public class TrappingRainWater42 {
	public int trapA(int[] height) {
        int max = 0; int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        if (height.length < 3) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
            stack.push(max);
        }
        int temp = height[height.length-1];
        for (int i = height.length-1; i >= 0; i--) {
            stack.pop();
            if (stack.empty()) {
                break;
            }
            if (height[i] > stack.peek()) {
                height[i] = stack.peek();
                temp = height[i];
            } 
            if (height[i] >= temp) {
                temp = height[i];
            } else {
                sum = sum + temp - height[i];
            }
        }
        return sum;
    }
}
