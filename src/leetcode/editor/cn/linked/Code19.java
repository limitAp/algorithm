package leetcode.editor.cn.linked;

import leetcode.editor.cn.linked.data.ListNode;
import leetcode.editor.cn.linked.data.ListNodeUtil;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code19 {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode();
    }

    /**
     * 删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        slow = fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}
