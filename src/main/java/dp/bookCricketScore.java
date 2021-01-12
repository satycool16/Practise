package main.java.dp;

public class bookCricketScore {
	public static void main(String[] args) {
		int total = 6;
		int number_of_ways = find_ways_to_express_score(total);
		System.out.println("number_of_ways for "+ total + " is "+ number_of_ways);
	}
	private static int find_ways_to_express_score(int score){
		if (score<1 || score%2==1)
			return -1;
		int[] dp = new int[score+1];
		dp[0] = dp[2] = 1;
		dp[4] = 2;
		for (int i=6; i<=score; i=i+2){
			dp[i] = dp[i-2] + dp[i-4] + dp[i-6];
		}
		return dp[score];

	}
}
