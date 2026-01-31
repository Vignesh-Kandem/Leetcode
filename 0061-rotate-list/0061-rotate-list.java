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
    public static ListNode findNthNode(ListNode head, int k) {
        ListNode temp=head;
        int count=1;
        while(temp!=null && count<k) {
            count++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode tail=head;
        int length=1;
        while(tail.next!=null) {
            tail=tail.next;
            length++;
        }
        tail.next=head;
        k=k%length;
        if(k==0) {
            tail.next=null;
            return head;
        }
        ListNode newLastNode=findNthNode(head,length-k);
        ListNode newHead=newLastNode.next;
        newLastNode.next=null;
        return newHead;
    }
}