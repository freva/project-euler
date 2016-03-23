package com.freva.projecteuler;

import com.freva.projecteuler.lvl0.*;

public class Main {
    public static void main(String args[]) {
        Problem problem = new Problem015();

        final long startTime = System.currentTimeMillis();
        final Number solution = problem.solve();
        final long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("Solution: " + solution + " | Time: " + executionTime + "ms");
    }
}
