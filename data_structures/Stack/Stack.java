public class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    Object peek() {
        return top.data;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
}