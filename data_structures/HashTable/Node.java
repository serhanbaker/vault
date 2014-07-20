public class Node {
    String key;
    int val;
    Node next;
    
    public Node(){
        next = null;
    }
    
    public Node(String key, int val){
        this.key = key;
        this.val = val;
        next = null;
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
