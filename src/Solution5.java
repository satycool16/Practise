import java.util.Scanner;
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            scanner.next();
            getDirection(scanner.next(), i+1);
        }
    }
    private static void getDirection(String lydiaPath, int caseId) {
        String myPath = lydiaPath.replaceAll("S","A").replaceAll("E", "S").replaceAll("A", "E");
        System.out.println(String.format("Case #%d: %s", caseId, myPath ));
    }
}
