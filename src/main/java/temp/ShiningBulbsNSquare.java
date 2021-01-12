package main.java.temp;
import java.util.Arrays;

public class ShiningBulbsNSquare {
	public static int solution(int[] arr) {
		int i, j, count = 0;

		boolean shines;
		for (i = 0; i < arr.length; i++) {
			shines = true;
			for (j = i + 1; j < arr.length && shines; j++) {
				if (arr[i] > arr[j])
					shines = false;
			}
			if (shines)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = {2,4,1,3};
		System.out.println(solution(arr));
	}
}
