package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

//Euler problem #22:
//What is the total of all the name scores in the file?
//Answer: 871198282, Time: 9ms

public class Problem022 implements Problem {
	public Number solve() {
		String[] names = new String[0];
		try (BufferedReader br = new BufferedReader(new FileReader("res/022.txt"))) {
            names = br.readLine().split(",");
		} catch (Exception ignored) {}

		Arrays.sort(names);
		int total = 0;
		for (int i = 0; i < names.length; i++) {
			for (int j = 1; j < names[i].length()-1; j++) {
                total += (i+1) * (names[i].charAt(j) - 64);
            }
		}

		return total;
	}
}
