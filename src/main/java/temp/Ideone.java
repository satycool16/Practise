package main.java.temp;

import java.util.ArrayList;
import java.util.Arrays;

public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 4;
//		int arr[] = {2,1,3,5, 4};
		int arr[] = {2,4,1,3};
		int leftmax[] = new int[n];
		leftmax[0] = arr[0];
		for(int i=1;i<n;i++)
			leftmax[i]= Math.max(leftmax[i-1],arr[i]);

		System.out.println(Arrays.toString(leftmax));
		int ans = 0;
		for(int i=0;i<n;i++)
			if(leftmax[i] == i+1)
				ans++;
		System.out.println(ans);
	}
}
