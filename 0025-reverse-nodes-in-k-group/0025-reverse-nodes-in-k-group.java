/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head) {
        ListNode temp=head;
        ListNode back=null;
        while(temp!=null) {
            ListNode front=temp.next;
            temp.next=back;
            back=temp;
            temp=front;
        }
        return back;
    }
    public static ListNode getKthGroup(ListNode temp, int k) {
        k=k-1;
        while(temp!=null && k>0) {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null) {
            ListNode kthNode=getKthGroup(temp,k);
            if(kthNode==null) {
                if(prevNode!=null) prevNode.next=temp;
                break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head) {
                head=kthNode;
            }
            else {
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}