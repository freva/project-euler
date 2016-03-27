package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

//Euler problem #13:
//Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
//Answer: 5537376230, Time: 0ms

public class Problem013 implements Problem {
    public Number solve() {
        long answer = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("res/013.txt"))) {
            for (int i = 0; i < 100; i++) {
                answer += Long.parseLong(br.readLine().substring(0, 11));
            }
        } catch (Exception ignored) { }

        while (answer > Math.pow(10, 10)) {
            answer /= 10;
        }
        return answer;
    }
}
