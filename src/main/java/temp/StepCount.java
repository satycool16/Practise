package main.java.temp;

public class StepCount {
	public static int steps_to_become_zero(int number){
		int steps=0;
		if (number==0 || number==1){
			return number;
		}
		String binaryNumber = Integer.toBinaryString(number);
		int zeroes = binaryNumber.length()- binaryNumber.replaceAll("0", "").length();
		System.out.println(binaryNumber);
		int ones = binaryNumber.length()- binaryNumber.replaceAll("1", "").length();
		ones = 2 * ones;
		return zeroes+ones-1;
	}
	public static void main(String[] args) {
	int x = 15;
	System.out.println(steps_to_become_zero(x));
	}

}

