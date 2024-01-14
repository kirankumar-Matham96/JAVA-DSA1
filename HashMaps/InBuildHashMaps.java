package HashMaps;

import java.util.HashMap;
import java.util.Set;

public class InBuildHashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insert
        map.put("price", 200);
        map.put("number", 10234);

        // retrieve
        if(map.containsKey("number")){
            System.out.println("number: "+map.get("number"));
        }

        // size
        System.out.println("size: "+map.size());

        // is empty?
        System.out.println("isEmpty: "+map.isEmpty());

        // contains key
        System.out.println("contains price: "+map.containsKey("price"));

        // contains value
        System.out.println("contains value: "+map.containsValue(200));

        // iterate a hash map
        Set<String> keys = map.keySet();

        for(String key: keys){
            System.out.println("Key: "+key);
        }

        // update/replace: returns boolean after the operation
        System.out.println("is value replaced: "+map.replace("price", 200, 500));
        if(map.containsKey("price")){
            System.out.println("price after update: "+map.get("price"));
        }

        // remove: returns the value after removing
        System.out.println(map.remove("price"));
    }
}
