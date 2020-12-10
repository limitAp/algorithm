package leetcode.editor.cn.linked.data;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class ListNodeUtil {

    /**
     * 创建一个链表
     * @return
     */
    public static ListNode createListNode() {
        ListNode listNode = new ListNode(3);
        ListNode head = listNode;
        int[] nums = new int[]{2, 0, -4};
        for (int num : nums) {
            ListNode temp = new ListNode(num);
            listNode.next = temp;
            listNode = temp;

        }
        listNode.next = head;

        return head;
    }
}
