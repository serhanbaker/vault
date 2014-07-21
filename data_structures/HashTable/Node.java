/**
 * @serhanbaker, 21.Jul.2014.
 */
public class Node<K, V> {
    K key;
    V val;
    Node next;

    public Node() {
        next = null;
    }

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        next  = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append("-> ");
        Node p = this.next;
        while (p != null) {
            sb.append(p.val);
            sb.append("-> ");
            p = p.next;
        }
        sb.append("X");
        return sb.toString();
    }
}
