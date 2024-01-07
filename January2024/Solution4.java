class Solution4 {
  public int numDecodings(String s) {
    final int n = s.length();
    // dp[i] := the number of ways to decode s[i..n)
    int[] dp = new int[n + 1];
    dp[n] = 1; // Empty string has one way to decode
    dp[n - 1] = isValid(s.charAt(n - 1)) ? 1 : 0; // Last character

    for (int i = n - 2; i >= 0; --i) {
      if (isValid(s.charAt(i)))
        dp[i] += dp[i + 1]; // Consider single-digit decoding
      if (isValid(s.charAt(i), s.charAt(i + 1)))
        dp[i] += dp[i + 2]; // Consider two-digit decoding
    }

    return dp[0]; // Result for the entire string
  }

  private boolean isValid(char c) {
    return c != '0'; // A single digit is valid if it's not '0'
  }

  private boolean isValid(char c1, char c2) {
    return c1 == '1' || (c1 == '2' && c2 < '7'); // Two digits are valid if they form a valid mapping
  }
}
