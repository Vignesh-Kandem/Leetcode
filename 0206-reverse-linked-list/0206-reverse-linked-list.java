/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 /* //Iterative.
class Solution {
    public ListNode reverseList(ListNode head) {
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
}
*/
//Recursive.
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}