class Solution {
    public boolean isHappy(int n) {
        int s = n, f = n;
        while (f != 1) {
            s = sum(s);
            f = sum(f);
            f = sum(f);
            if (f == s && s != 1) {
                return false;
            }
        }
        return true;
    }

    public int sum(int n) {
        int s = 0;
        while (n != 0) {
            int d = n % 10;
            s += d * d;
            n/=10;
        }
        return s;
    }
}