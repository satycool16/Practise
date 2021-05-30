package main.java.dp;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "1111";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2; i<=n; i++){
            int first = s.substring(i-1, i).charAt(0) - '0';
            int second = (s.substring(i-2, i-1).charAt(0) - '0')*10 + first;

            if(first>=1 && first<=9)
                dp[i] += dp[i-1];
            if(second>=10 && second <=26)
                dp[i] += dp[i-2];
        }

        return dp[n];
    }
}
