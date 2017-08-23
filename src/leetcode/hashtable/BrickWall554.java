package leetcode.hashtable;

import java.util.HashMap;
import java.util.List;

public class BrickWall554 {
	public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum = sum + list.get(i);
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
                max = Math.max(max, hm.get(sum));
            }
        }
        return wall.size() - max;
    }
}
