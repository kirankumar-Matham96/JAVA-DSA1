package HashMaps;

public class MapNode<K,V> {
    private V value;
    private MapNode<K,V> next;
    private K key;

    MapNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
