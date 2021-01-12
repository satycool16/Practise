import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Solution7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            int people = scanner.nextInt();
            int max = scanner.nextInt();
            HashMap<String, Integer> my_map = new HashMap<String, Integer>();
            for (int j=0;j<people; j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String direction = scanner.next();
                my_map = get_updated_map(x,y, direction,max, my_map);
            }
            get_max_key(my_map, i+1);
            System.out.println("Next case");
        }
    }

    private static void get_max_key(HashMap<String, Integer> my_map, int caseId) {
        int max_value = Collections.max(my_map.values());
        List<String> keys = new ArrayList<>();
        for (Entry<String, Integer> entry : my_map.entrySet()) {
            if (entry.getValue()==max_value) {
                keys.add(entry.getKey());
            }
        }
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator iterator1 = keys.iterator();
        int i=0;
        int min = 0;
        while(iterator.hasNext()) {
            if (i==0) {
                min = Integer.parseInt(keys.get(i).replace(",", ""));
                i++;
                iterator.next();
                continue;
            }
            int value = Integer.parseInt(keys.get(i).replace(",",""));
            if (min>value){
                min=value;
            }
            i++;
            iterator.next();
            //System.out.println(min);
        }
        int x = min/10;
        int y = min%10;

        // System.out.println(String.format("Case #%d: %d %d", caseId, x, y ));
    }

    private static HashMap<String, Integer> get_updated_map(int x, int y, String direction, int max, HashMap<String, Integer> my_map) {
        if (direction.equals("N")){
            y++;
            x=0;
            for(int i=y;i<=max; i++){
                String key = x+","+i;
                if (my_map.containsKey(key))
                    my_map.put(key, my_map.get(key)+1);
                else
                    my_map.put(key, 1);
            }
        }
        if (direction.equals("S")){
            y--;
            x=0;
            for(int i=0;i<=y; i++){
                String key = x+","+i;
                if (my_map.containsKey(key))
                    my_map.put(key, my_map.get(key)+1);
                else
                    my_map.put(key, 1);
            }
        }
        if (direction.equals("E")){
            x++;
            y=0;
            for(int i=x;i<=max; i++){
                String key = i+","+y;
                if (my_map.containsKey(key))
                    my_map.put(key, my_map.get(key)+1);
                else
                    my_map.put(key, 1);
            }
        }
        if (direction.equals("W")){
            x--;
            y=0;
            for(int i=0;i<=x; i++){
                String key = i+","+y;
                if (my_map.containsKey(key))
                    my_map.put(key, my_map.get(key)+1);
                else
                    my_map.put(key, 1);
            }
        }
        return my_map;
    }
}
