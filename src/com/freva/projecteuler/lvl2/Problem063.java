package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #63:
//How many n-digit positive integers exist which are also an nth power?
//Answer: 49, Time: 0ms

public class Problem063 implements Problem {
    public Number solve() {
        int sum = 0;

        //This problem can be written as how many 10^(n-1) <= x^n < 10^n solutions are there with x > 0 and n > 0.
        //To satisfy x^n < 10^n, we have that x < 10. Since 10^n will grow faster than x^n, we only need to find
        //for each x how many n values are possible before x^n < 10^(n-1).
        //Solving x^n = 10^(n-1) ==> nlogx = (n-1)log(10) ==> n(log(10)-logx) = log(10) ==> n = log(10) / (log(10)-logx)
        for (int x = 1; x < 10; x++) {
            sum += (int) (Math.log(10) / (Math.log(10) - Math.log(x)));
        }

        return sum;
    }
}
