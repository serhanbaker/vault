/**
 * @serhanbaker, 21.Jul.2014.
 */
import java.util.NoSuchElementException;

public class HashTable<K, V> {
    private static final int MAX = 50;
    private static Node[] arr = new Node[MAX];

    private int stringHash(K key, int modulus) {
        String str = String.valueOf(key);
        int kMult = 997;
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            val = (val * kMult + c) % modulus;
        }
        return val;
    }

    public void put(K key, V value) {
        int hashCode = stringHash(key, MAX);
        Node p = new Node(key, value);
        p.next = arr[hashCode];
        arr[hashCode] = p;
    }

    public void modify(K key, V value) {
        int hashCode = stringHash(key, MAX);
        Node p = arr[hashCode];
        p.val = value;
    }

    public void remove(K key) {
        int hashCode = stringHash(key, MAX);
        System.out.println("hashCode = " + hashCode);
        while (arr[hashCode] != null) {
            if (arr[hashCode].key.equals(key)) { // if we remove first element
                arr[hashCode] = arr[hashCode].next;
                return;
            }

            Node cur = arr[hashCode];
            Node prev = null;
            while (cur != null && !cur.key.equals(key)) {
                prev = cur;
                cur = cur.next;
            }
            if (cur == null) {
                throw new NoSuchElementException("couldn't find the key");
            }
            prev.next = cur.next; // delete cur node
        }
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        int hashCode = stringHash(key, MAX);
        Node tmp = arr[hashCode];
        while (tmp != null) {
            if (tmp.key == key) {
                return (V) tmp.val;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
