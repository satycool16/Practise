public class LootHouses {
    static int getMaxLoot(int[] arr, int n){
        if (n==0)
            return 0;
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i=2; i<n; i++){
            dp[i] = Math.max((arr[i] + dp[i-2]), dp[i-1]);
        }

        System.out.println(dp.toString());
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] houses = {5, 3, 4, 11, 2};
        int n =houses.length;
        System.out.println(getMaxLoot(houses, n));
    }
}
