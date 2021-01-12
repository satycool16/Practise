package main.java.leetcode;

import jdk.nashorn.internal.objects.Global;

import javax.xml.bind.annotation.XmlElementDecl;

public class EditDistance {

	public static int x = 0;
	public static void main(String[] args) {
		String s1 = "hphenylhydrazine";
		String s2 = "xphenylhydrazine";
		int x = minDistance(s1, s2);
		System.out.println(x);

	}
	public static int minDistance(String word1, String word2) {
		x++;
		if (x>100){
			return 0;
		}
		System.out.println(word1 +" "+ word2);
		if (word1.equals(word2)){
			return 0;
		}
		if (word1.equals("")) return word2.length();
		if (word2.equals("")) return word1.length();

		int i=0, j=0, k=0;

		while(i<word1.length() && i<word2.length() && word1.charAt(i) == word2.charAt(i)){
			i++;
		}

		if (i<word1.length() && i<word2.length()){
			System.out.println("Replaced");
			int replace = minDistance(word2.charAt(i) + word1.substring(i+1),
					word2.substring(i));
			System.out.println("Deleted");
			int deletion = minDistance(word1.substring(i+1),
					word2.substring(i));
			System.out.println("Inserted");
			int insertion = minDistance(word2.charAt(i) + word1.substring(i),
					word2.substring(i));



			return 1+ Math.min(replace, Math.min(insertion, deletion));
		}
		else{
			return minDistance(word1.substring(i), word2.substring(i));
		}

	}
}