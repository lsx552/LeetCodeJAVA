package leetcode;

public class AddTwoNumbers_2 {
    //2.两数相加
    //给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p =l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q !=null) {
           int x = (p !=null) ? p.val:0;
           int y = (q !=null) ? q.val:0;
           int sum = x + y + carry;
           carry = sum / 10;
           curr.next = new ListNode(sum % 10);
           curr = curr.next;
           if (p !=null) p = p.next;
           if (q !=null) q = q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers_2 s = new AddTwoNumbers_2();
        ListNode res = s.addTwoNumbers(l1, l2);
        System.out.println(res.val+","+res.next.val+","+res.next.next.val);
    }
}
