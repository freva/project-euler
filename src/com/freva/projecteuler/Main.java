package com.freva.projecteuler;

import com.freva.projecteuler.lvl0.*;

public class Main {
    static final Problem[] allProblems = {new Problem001(), new Problem002(), new Problem003(), new Problem004(),
            new Problem005(), new Problem006(), new Problem007(), new Problem008(), new Problem009(), new Problem010()};

    public static void main(String args[]) {
        runProblems(allProblems);
    }

    public static void runProblems(Problem... problems) {
        for(int i=0; i<problems.length; i++) {
            final long startTime = System.currentTimeMillis();
            final Number solution = problems[i].solve();
            final long executionTime = System.currentTimeMillis() - startTime;

            System.out.println("Problem: " + String.format("%03d", i+1) + " | Solution: " + String.format("%12s", solution) +
                    " | Correct: " + solution.equals(problems[i].solution()) + " | Time: " + executionTime + "ms");
        }
    }
}
