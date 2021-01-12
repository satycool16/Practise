package main.java.temp;

import java.util.HashSet;
import java.util.Set;

public class ShiningBulbs {

	public static int solution(int[] a) {
		Set<Integer> missing = new HashSet<>();
		Set<Integer> store = new HashSet<>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println("i:"+i+" e:"+a[i]);
			if (!store.contains(i + 1) && i + 1 != a[i] && (i+1 < a[i]))
				missing.add(i + 1);
			if (i + 1 < a[i])
				store.add(a[i]);
			else
				missing.remove(a[i]);
			if (missing.isEmpty())
				count++;
			System.out.println("store:"+store);
			System.out.println("missing:"+missing);
		}
		return count;
	}

	public static void main(String[] args) {
	int[] arr = new int[]{3,4,5,1, 2};

//	int[] arr = new int[]{4, 3, 1, 2};
	System.out.println(solution(arr));

	}
}
