import java.util.*;

public class SolutionDecipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] l_arr;
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            int N = scanner.nextInt();
            int L = scanner.nextInt();
            l_arr = new Integer[L];
            for(int j=0; j<L; j++){
                l_arr[j] = scanner.nextInt();
            }
            decipher(L, l_arr, i+1);
        }
    }

    private static void decipher(int l, Integer[] l_arr, int caseId) {
        Integer[] res_arr = new Integer[l+1];
        res_arr[1] = hcf(l_arr[0], l_arr[1]);
        res_arr[0] = l_arr[0]/res_arr[1];

        for(int i=2; i<l+1; i++){
            res_arr[i]=l_arr[i-1]/res_arr[i-1];
        }

        Integer[] sorted_res = res_arr.clone();
        Arrays.sort(sorted_res);
        HashMap<Integer, Character> hm = new HashMap<>();
        int ascii = 65;
        for (int i=0; i<l+1; i++){
            if (hm.get(sorted_res[i]) == null){
                hm.put(sorted_res[i], (char)ascii);
                ascii++;
            }
        }
        String result = "";
        for (Integer i: res_arr) {
            result= result+hm.get(i).toString();
        }
        System.out.println(String.format("Case #%d: %s", caseId, result ));
    }
    static Integer hcf(Integer a, Integer b)
    {
        if (b == 0)
            return a;
        return hcf(b, a % b);
    }

}
