package utils;

import static java.lang.Math.sqrt;

public class MethodExamples {

    public static double factorial(int n) {
        double result = 1.0;
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers");
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int m = 3; m <= (int) sqrt(n); m += 2) {
            if (n % m == 0) return false;
        }
        return true;
    }

    public static boolean isPerfect(int n) {
        int sum = 1;
        if (n < 2) {
            return false;
        }
        for (int m = 2; m <= n / 2; m++) {
            if (n % m > 0) continue;
            sum += m;
            if (sum > n) break;
        }
        return sum == n;
    }

    public static int digitCountInNumber(int n, int m) {
        if (m < 0 || m > 9) {
            throw new IllegalArgumentException(
                    "Parameter m must be a digit from 0 to 9");
        }
        n = Math.abs(n);
        return n == m ? 1 : (n < 10 ? 0 : digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m));
    }
}
