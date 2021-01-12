public class FindPairWithSumInSortedArray {
	public static void main(String[] args) {
		int[] elements2 = {1, 3, 6, 8, 11, 11, 22, 31, 65, 81};
		int[] elements = {};
		int sum = 22;
		boolean hasPair = hasPair(elements, sum);
		System.out.println("hasPair:" + hasPair);
	}
	private static boolean hasPair(int[] arr, int sum){
		int length = arr.length;
		int i = 0, j = length-1;
		while(i<j){
			int current_sum = arr[i]+arr[j];
			if (current_sum == sum){
				System.out.println(String.format("i=%d, j=%d and first=%d, second=%d",i, j, arr[i], arr[j]));
				return true;
			}
			else if (current_sum > sum)
				j--;
			else
				i++;
		}
		return false;
	}
}
