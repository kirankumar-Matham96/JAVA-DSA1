package HashMaps;

import java.util.ArrayList;

public class Map<K,V> {
    private int count;
    private int numberOfBuckets;
    ArrayList<MapNode<K,V>> buckets;

    public Map(){
        buckets = new ArrayList<>();
        this.numberOfBuckets = 20;

        for (int i = 0; i < this.numberOfBuckets; i++){
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        // hashCode is an internal java function that gives the hash code
        int hc = key.hashCode();
        int index = hc%numberOfBuckets;
        return index;
    }

    private void reHash() {
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2*numberOfBuckets; i++) {
            buckets.add(null);
        }
        count = 0;
        numberOfBuckets *= 2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K,V> head = temp.get(i);
            while(head != null){
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public double loadFactor() {
        return (1.0*count)/numberOfBuckets;
    }
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        // if element is there? update the element
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // element is not there? insert the new element at the 0th position of linked-list
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key,value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        // re-hashing: (When load factor increases 0.7)
        double loadFactor = (1.0*count)/numberOfBuckets;
        if(loadFactor > 0.7){
            reHash();
        }
    }

    public int size() {
        return this.count;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        // if element is there?
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        // if element is there?
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    // if value present at the first node
                    buckets.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}
