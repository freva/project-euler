package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #70:
//Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
//Answer: 8319823, Time: 4ms

public class Problem070 implements Problem {
    public Number solve() {
        /**
         * As derived in the solution to problem 69:
         * n/φ(n) = product of n=1..r [p_k / (p_k - 1)]
         * The minimum ratio of n/φ(n) will have few unique prime factors, but is not prime (as φ(n)=n-1 cant be a
         * permutation of n. Therefore the solution will likely be a product of two primes close to sqrt(10^7).
         */

        final boolean[] isComposite = Functions.sieveOfEratosthenes(4_000);
        final int LIMIT = 10_000_000;

        int bestN = 0;
        double lowestRatio = Double.MAX_VALUE;
        for (int i = isComposite.length - 1; i > Math.sqrt(LIMIT); i--) {
            if (isComposite[i]) continue;
            for (int j = LIMIT / i; j > 2; j--) {
                if (isComposite[j]) continue;

                int n = i * j;
                int phiN = (i - 1) * (j - 1);
                double ratio = (double) n / phiN;
                if (ratio < lowestRatio) {
                    if (Functions.arePermutationsOfEachOther(n, phiN)) {
                        lowestRatio = ratio;
                        bestN = n;
                    }
                } else break;
            }
        }

        return bestN;
    }
}


//#Answer: 8319823
//#123.99ms
//
//
//primes = [2]
//bigPrimes = []
//n, sq = 3, 2
//while n<=5000:
//	prime=True
//	for i in primes:
//		if n%i == 0:
//			prime=False
//			break
//		if i > sq:
//			break
//	if prime:
//		primes.append(n)
//		if n>2000:
//			bigPrimes.append(n)
//	n+=2
//	sq = int(n**0.5)
//
//recordN, record, limit = 1, 2.0, 10**7
//for i in range(len(bigPrimes)):
//	for j in range(i+1, len(bigPrimes)):
//		n=bigPrimes[i]*bigPrimes[j]
//		if n>limit:
//			break
//
//		phi=(bigPrimes[i]-1)*(bigPrimes[j]-1)
//		ratio=n/float(phi)
//		if (sorted(list(str(n))) == sorted(list(str(phi)))) and (ratio < record):
//			recordN=n
//			record=ratio
//print recordN