package leetcode.editor.cn.linked;

import leetcode.editor.cn.linked.data.ListNode;
import leetcode.editor.cn.linked.data.ListNodeUtil;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code141 {


    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createListNode();
        boolean b = hasCycle(head);
        System.out.println(b);
    }

    /**
     * 链表有环
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
