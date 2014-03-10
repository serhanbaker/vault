import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> head;

    // empty list
    public LinkedList() {
        head = null;
    }

    // check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // returns the data at the specified position in the list.
    public AnyType get(int pos) {
        if (head == null)
            throw new IndexOutOfBoundsException();

        Node<AnyType> tmp = head;
        for (int k = 0; k < pos; k++)
            tmp = tmp.next;

        if (tmp == null)
            throw new IndexOutOfBoundsException();

        return tmp.data;
    }

    // insert a new element to beginning
    public void addFirst(AnyType item) {
        head = new Node<AnyType>(item, head);
    }

    // append an item
    public void add(AnyType item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<AnyType> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<AnyType>(item, null);
        }
    }

    // insert an item after another item (key)
    public void insertAfter(AnyType key, AnyType item) {
        Node<AnyType> tmp = head;
        while (tmp != null && !tmp.data.equals(key)) {
            tmp = tmp.next; // traverse through the list
        }
        if (tmp != null) {
            tmp.next = new Node<AnyType>(item, tmp.next);
        }
    }

    // insert an item before another item (key)
    public void insertBefore(AnyType key, AnyType item) {
        if (head == null) {
            return;
        }
        if (head.data.equals(key)) {
            addFirst(item);
            return;
        }
        Node<AnyType> prev = null;
        Node<AnyType> cur = head;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            prev.next = new Node<AnyType>(item, cur);
        }
    }

    // removes the first occurance of the key
    public void remove(AnyType key) {
        if (head == null) {
            throw new RuntimeException("cannot delete");
        }

        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        Node<AnyType> cur = head;
        Node<AnyType> prev = null;

        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == null) {
            throw new NoSuchElementException("couldn't find the key");
        }

        // delete cur node
        prev.next = cur.next;
    }

    // returns reversed list (O(n) time)
    public LinkedList<AnyType> reverse() {
        LinkedList<AnyType> list = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        while (tmp != null) {
            list.addFirst(tmp.data);
            tmp = tmp.next;
        }
        return list;
    }

    // returns a deep copy of the immutable list
    // with a tail reference (O(n) time)
    public LinkedList<AnyType> clone1() {
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        if (head == null)
            return null;
        twin.head = new Node<AnyType>(head.data, null);
        Node<AnyType> tmpTwin = twin.head;
        while (tmp.next != null) {
            tmp = tmp.next;
            tmpTwin.next = new Node<AnyType>(tmp.data, null);
            tmpTwin = tmpTwin.next;
        }
        return twin;
    }
    
    // returns a string representation
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object x : this)
            result.append(x + " ");

        return result.toString();
    }

    /* ***** The Node class ***** */
    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    /* ***** The Iterator class ***** */
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> nextNode;

        public LinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public AnyType next() {
            if (!hasNext())
                throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("h");
        list.addFirst("r");
        list.addFirst("e");
        list.addFirst("s");
        System.out.println(list);

        LinkedList<String> twin = list.clone1();
        System.out.println(twin);

        System.out.println(list.get(0)); // .get(4) will get an exception

        list.add("s");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();

        for (Object x : list)
            System.out.print(x + " ");
        System.out.println();

        list.insertAfter("e", "ee");
        System.out.println(list);

        list.insertBefore("h", "R");
        System.out.println(list);

        list.remove("e");
        System.out.println(list);
    }
}