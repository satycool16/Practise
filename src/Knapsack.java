public class Knapsack {
    static int getMaxValue(int TotalWeight, int[] weights, int[] values, int n){
        if (n==0 || TotalWeight == 0)
            return 0;
        if (weights[n-1] > TotalWeight)
            return getMaxValue(TotalWeight, weights, values, n-1);
        return Math.max(
                values[n-1] + getMaxValue(TotalWeight-weights[n-1],weights, values, n-1),
                getMaxValue(TotalWeight, weights, values, n-1)
        );
    }
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int TotalWeight = 50;
        System.out.println(getMaxValue(TotalWeight, weights, values, values.length));
    }
}
