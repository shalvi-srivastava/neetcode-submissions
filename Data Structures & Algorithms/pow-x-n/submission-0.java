class Solution {
    public double myPow(double a, int n) {
        long N = n;

        if (N < 0) {
            a = 1 / a;
            N = -N;
        }

        return power(a, N);
    }

    private double power(double a, long n) {
        if (n == 0) return 1;

        double half = power(a, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }
}