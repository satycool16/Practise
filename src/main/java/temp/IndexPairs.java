package main.java.temp;

import java.util.HashMap;
import java.util.Map;

public class IndexPairs {
	public static int get_pairs(int[] arr){
		int n= arr.length;
		int frequency;
		int ans = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i=0; i<arr.length; i++){
			int element = arr[i];
			if (hm.containsKey(element))
				hm.put(element, hm.get(element)+1);
			else
				hm.put(element, 1);
		}
		for (int key: hm.keySet()){
			frequency = hm.get(key);
			if (frequency > 1){
				ans = ans + (frequency*(frequency-1)/2);

			}
		}
		return ans;
	}
	public static void main(String[] args)
	{
		int arr[] = new int[]{1, 2, 3, 1};
		System.out.println(get_pairs(arr));
	}
}
