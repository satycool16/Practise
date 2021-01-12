import java.util.HashSet;

public class FindPairWithSumInArray {
	public static void main(String[] args){
		int[] elements1 = {2,5,6,1,11,546,35,66,43,77,22,0};
		int[] elements = {};
		int sum = 545;
		boolean hasPair = hasPair(elements, sum);
		System.out.println("hasPair:" + hasPair);


	}
	private static boolean hasPair(int[] arr, int sum){
		HashSet<Integer> tracedSet = new HashSet<Integer>();
		for (int element : arr){
			int compliment = sum - element;
			if (tracedSet.contains(compliment)){
				System.out.println(String.format("first=%d, second=%d",compliment, element));
				return true;
			}
			tracedSet.add(element);
		}
		return false;
	}
}
