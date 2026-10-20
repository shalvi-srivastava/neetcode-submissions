class Solution {
    public int reverseBits(int n) {
        String bin = String.format("%32s", Integer.toBinaryString(n))
                .replace(' ', '0');

        String rev = reverse(bin);

        return (int) Long.parseLong(rev, 2);
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}