package main.java.recursion;

public class eggDropRecursion {
	static int min_drops(int n, int k){
		if (k==0 || k==1 || n==1){
			return k;
		}
		int res;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++){
			res = max(min_drops(n-1, i-1),
					min_drops(n, k-i));
			if (res < min)
				min = res;
		}
		return min+1;

	}
	static int max(int a, int b){
		return (a > b) ? a : b;
	}
	public static void main(String[] args) {
	int n =2 ;
	int k =10;
	System.out.println("Minimum trials:" + min_drops(n, k));
	}
}
