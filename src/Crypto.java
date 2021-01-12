import java.util.*;
import java.math.BigInteger;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BigInteger> l_arr;
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            int N = scanner.nextInt();
            int L = scanner.nextInt();
            l_arr = new ArrayList<BigInteger>(L);
            for(int j=0; j<L; j++){
                l_arr.add(scanner.nextBigInteger());
            }
            decipher(L, l_arr, i+1);
            System.gc();
        }
    }
    private static void decipher(int l, ArrayList<BigInteger> l_arr, int caseId) {
        ArrayList<BigInteger> res_arr = new ArrayList<BigInteger>(l+1);
        BigInteger firstIndex;
        int count = 0;
        while (l_arr.get(count).equals(l_arr.get(count+1)))
        {
            count++;
        }
        if (count%2==0){
            firstIndex = hcf(l_arr.get(count), l_arr.get(count+1));
        }
        else{
            firstIndex =  l_arr.get(count).divide(hcf(l_arr.get(count), l_arr.get(count+1)));

        }
        res_arr.add(0, l_arr.get(0).divide(firstIndex));
        res_arr.add(1, firstIndex);

        for(int i=2; i<l+1; i++){
            BigInteger value = BigInteger.ZERO;
            value = l_arr.get(i-1).divide(res_arr.get(i-1));

            res_arr.add(i, value);
        }

        ArrayList<BigInteger> sorted_res = (ArrayList<BigInteger>) res_arr.clone();
        Collections.sort(sorted_res);
        HashMap<BigInteger, Character> hm = new HashMap<>();
        int ascii = 65;
        for (BigInteger i: sorted_res){
            if (hm.get(i) == null){
                hm.put(i, (char)ascii);
                ascii++;
            }
        }
        String result = "";
        for (BigInteger i: res_arr) {
            result= result+hm.get(i).toString();
        }
        System.out.println(String.format("Case #%d: %s", caseId, result ));
    }
    static BigInteger hcf(BigInteger a, BigInteger b)
    {
        if (b.equals(BigInteger.ZERO))
            return a;
        return hcf(b, a.mod(b));
    }

}
