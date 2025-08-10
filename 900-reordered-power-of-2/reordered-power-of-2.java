class Solution {
    public boolean reorderedPowerOf2(int n) {
        String sig = signature(n);
        for (int i = 0; i < 31; i++) { // 2^30 = 1,073,741,824 > 1e9
            if (sig.equals(signature(1 << i))) return true;
        }
        return false;
    }

    private String signature(int x) {
        int[] cnt = new int[10];
        while (x > 0) {
            cnt[x % 10]++;
            x /= 10;
        }
        // Build a compact signature string like "0#1#0#...#"
        StringBuilder sb = new StringBuilder(30);
        for (int c : cnt) sb.append('#').append(c);
        return sb.toString();
    }
}
