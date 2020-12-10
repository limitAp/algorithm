package leetcode.editor.cn.linked;

import leetcode.editor.cn.linked.data.ListNode;
import leetcode.editor.cn.linked.data.ListNodeUtil;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code142 {


    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createListNode();
        ListNode temp = detectCycle(head);
    }

    /**
     * 找到环形链表入口
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow == fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
