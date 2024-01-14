package HashMaps;

import java.util.ArrayList;

public class Map<K,V> {
    private int count;
    private int numberOfBuckets;
    ArrayList<MapNode<K,V>> buckets;

    Map(){
        buckets = new ArrayList<>();
        this.numberOfBuckets = 20;

        for (int i = 0; i < this.numberOfBuckets; i++){
            buckets.add(null);
        }
    }
}
