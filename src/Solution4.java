import java.util.Arrays;
import java.util.Scanner;
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] words;
        for (int i=0; i<T; i++){
            int n = scanner.nextInt();
            words = new String[n];
            for (int j=0; j<n; j++){
                StringBuilder sb =new StringBuilder();
                sb.append(scanner.next());
                words[j]=sb.reverse().toString();
            }
            printNumberOfRhymes(n, words, i+1);
        }
    }

    private static void printNumberOfRhymes(int n, String[] words, int caseId) {
        int i=1, count=0;
        Arrays.sort(words);
        for (String str:words
             ) {
            System.out.println(str);

        }
        while(i<n-1){
            int firstTwo = getMaxAccent(words[i-1], words[i]);
            int secThird = getMaxAccent(words[i], words[i+1]);
            if (firstTwo>0 && firstTwo>secThird){
                count = count + 2;
                System.out.println("Choosing "+words[i-1]+" "+words[i]);
                i = i+2;
            }
            else
            {
                i++;
            }
        }
        if (i==n-1 && getMaxAccent(words[i-1],words[i])>0)
            count=count+2;
        System.out.println(String.format("Case #%d: %d", caseId, count ));
    }

    private static int getMaxAccent(String word1, String word2) {
        char[] char1=word1.toCharArray();
        char[] char2=word2.toCharArray();
        int i=0;
        int count =0;
        while (i<char1.length && i<char2.length){
            if(char1[i]==char2[i])
                count++;
            else
                break;
            i++;
        }
        System.out.println("Accent of "+word1+ " & "+word2 + " is "+count);
        return count;

    }
}
