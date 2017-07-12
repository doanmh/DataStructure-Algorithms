package leetcode.arrays;

import java.util.Arrays;

public class TaskScheduler621 {
	public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char x : tasks) {
            map[x - 'A']++;
        }
        Arrays.sort(map);
        int maxIdle = (map[25]-1)*n;
        int actualIdle = maxIdle;
        for(int i = 24; i >= 0; i--) {
            if(map[i] == 0) {
                break;
            }
            if (map[i] == map[25]) {
                actualIdle = actualIdle - map[i] + 1;   
            } else {
                actualIdle -= map[i];
            }
        }

        return tasks.length > actualIdle + tasks.length ? tasks.length : actualIdle + tasks.length;
    }
}
