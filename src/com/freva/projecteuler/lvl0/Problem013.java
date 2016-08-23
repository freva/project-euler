package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #013:
 * Answer: 5537376230, Time: 0ms
 *
 * Work out the first ten digits of the sum of the one-hundred 50-digit numbers in res/013.txt.
 */

public class Problem013 implements Problem {
    public Number solve() {
        long sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("res/013.txt"))) {
            for (int i = 0; i < 100; i++) {
                sum += Long.parseLong(br.readLine().substring(0, 11));
            }
        } catch (Exception ignored) { }

        while (sum > Math.pow(10, 10)) {
            sum /= 10;
        }
        return sum;
    }
}
