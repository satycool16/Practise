package main.java.stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamClass {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(21,13,14,6);
		List<Integer> squares = numbers.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(squares);

		List<String> strings = Arrays.asList("Sagar", "Saty", "Satyam","Umang");
		List<String> result = strings.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		numbers.stream().sorted().forEach(a->System.out.print(a + " "));
		System.out.println();
		Integer sum=  numbers.stream().filter(x->x%2==0).reduce(0,(ans, i)->ans+i);
		System.out.println(sum);
	}
}
