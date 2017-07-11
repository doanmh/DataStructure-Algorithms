package codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class CrosswordSolving_822B {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt(); //s length
		int m = reader.nextInt(); //t length
		String s = reader.next(); 
		String t = reader.next();
		reader.close();
		int mark = 0;
		int min = 2000;
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<Integer> minIndex = new ArrayList<Integer>();
		for (int i = 0; i < m - n + 1; i++) {
			mark = 0;
			index.clear();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) != t.charAt(i + j)) {
					mark++;
					index.add(j);
				}
			}
			if (mark < min) {
				min = mark;
				minIndex.clear();
				for (int h = 0; h < min; h++) {
					minIndex.add(index.get(h));
				}
			}
		}
		System.out.println(min);
		for(int i = 0; i < minIndex.size(); i++) {
			System.out.print((minIndex.get(i) + 1) + " ");
		}
	}
}
