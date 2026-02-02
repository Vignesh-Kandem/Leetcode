/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static void placeInBetween(Node head) {
        Node temp=head;
        while(temp!=null) {
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
    }
    public static void connectRandomPointers(Node head) {
        Node temp=head;
        while(temp!=null) {
            Node copyNode=temp.next;
            if(temp.random!=null) copyNode.random=temp.random.next;
            else copyNode.random=null;
            temp=temp.next.next;
        }
    }
    public static Node connectNextPointers(Node head) {
        if(head==null) return null;
        Node temp=head;
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        while(temp!=null) {
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
    public Node copyRandomList(Node head) {
        placeInBetween(head);
        connectRandomPointers(head);
        return connectNextPointers(head);
    }
}