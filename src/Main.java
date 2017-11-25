import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String,Integer> map=new TreeMap<String, Integer>();
        map.put("a",1);
        map.put("b",2);

        System.out.println(map);
    }
}
