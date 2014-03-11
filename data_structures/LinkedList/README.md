Linked Lists
=============
##The Node class
In linked lists, each element is a seperate object (Node).   

---
Each node is comprising of 2 items:
* Data
* Reference to next node (last node has a reference to null)
```java
public Node(int data){
    this.data = data;
    next = null;
}
```
---

###Head Node:
* This is the entry point to a linked list.
* If list is empty, head references to null

In order to understand this abstraction, we could write a code like this:
```java
 public static Node buildList(int[] arr){
    Node head = new Node(arr[0]);
    Node p = head;
    for (int i = 1; i < arr.length; i++){
        p.next = new Node(arr[i]);
        p = p.next;
    }
    return head;
}
```

---
###The whole Node class:

```java
public class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        next = null;
    }
    
    public Node(int[] arr){
        //arr.length > 0
        Node node = buildList(arr);
        this.data = node.data;
        this.next = node.next;
     }
    
    public static Node buildList(int[] arr){
        Node head = new Node(arr[0]);
        Node p = head;
        for (int i = 1; i < arr.length; i++){
           p.next = new Node(arr[i]);
           p = p.next;
        }
        return head;
     }

    public void add(int val) {
        Node end = new Node(val);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
    
    public String printList(){
      StringBuilder sb = new StringBuilder();
      sb.append(data);
      sb.append("-> ");
      Node p = this.next;
      while (p != null){
         sb.append(p.data);
         sb.append("-> ");
         p = p.next;
      }
      sb.append("null");
      return sb.toString();
   }
}
```
