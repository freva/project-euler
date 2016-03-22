package com.freva.projecteuler;

public interface Problem {
    Number solve();

    /**
     * @return The true answer to the problem
     */
    Number solution();
}
