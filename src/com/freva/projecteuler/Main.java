package com.freva.projecteuler;

import com.freva.projecteuler.lvl0.*;

public class Main {
    static final Problem[] allProblems = {new Problem001(), new Problem002(), new Problem003(), new Problem004()};

    public static void main(String args[]) {
//        runProblems(allProblems);
        runProblems(new Problem004());

    }

    public static void runProblems(Problem... problems) {
        for(int i=0; i<problems.length; i++) {
            final long startTime = System.currentTimeMillis();
            final Number solution = problems[i].solve();
            final long executionTime = System.currentTimeMillis() - startTime;

            System.out.println("Problem: " + String.format("%03d", i+1) + " | Solution: " + String.format("%10s", solution) +
                    " | Correct: " + solution.equals(problems[i].solution()) + " | Time: " + executionTime + "ms");
        }
    }
}
