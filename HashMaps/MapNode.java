package HashMaps;

public class MapNode<K,V> {
    V value;
    MapNode<K,V> next;
    K key;

    MapNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
