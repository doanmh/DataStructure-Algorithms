package leetcode.stackandqueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetter316 {
	public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<Character>();
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int[] indexOf = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (set.contains(current)) {
                if (map.get(current) == i) {
                    map.put(current, indexOf[current - 'a']);
                }
                continue;
            }
            while(!stack.empty() && indexOf[stack.peek() - 'a'] != map.get(stack.peek()) && current < stack.peek()) {
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(current);
            set.add(current);
            indexOf[current - 'a'] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}
