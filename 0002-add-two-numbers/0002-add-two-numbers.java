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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        int c = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dum = new ListNode(-1);
        ListNode temp = dum;
        while(c!=0 || c1!=null || c2!=null){
            int sum = c;
            if(c1!=null){
                sum+=c1.val;
                c1 = c1.next;
            }
            if(c2!=null){
                sum+=c2.val;
                c2 = c2.next;
            }
            ListNode nn = new ListNode((sum)%10);
            temp.next = nn;
            temp = temp.next;
            c = sum/10;
        }
        return dum.next;
    }
}