import java.util.Scanner;
public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            printWithoutFour(scanner.next(), i+1);
        }
    }

    private static void printWithoutFour(String originalNumber, int caseId) {
        int firstNumber = Integer.parseInt(originalNumber.replaceAll("4","2"));
        int secondNumber = Integer.parseInt(originalNumber)-firstNumber;
        System.out.println(String.format("Case #%d: %d %d", caseId,firstNumber, secondNumber ));

    }
}
