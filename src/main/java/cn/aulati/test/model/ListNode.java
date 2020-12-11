package cn.aulati.test.model;

/**
 * singly-linked list node.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    /**
     * Create a list from given int array.
     */
    public static ListNode fromArray(int[] nums) {
        ListNode root, cur;
        root = cur = new ListNode(0);

        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return root.next;
    }

    /**
     * 把这个单向链表以"->"链接起来，返回一个字符串
     * @param r 链表的根节点
     * @return 拼接成的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        ListNode cur = this.next;
        while (cur != null) {
            sb.append("->").append(cur.val);
            cur = cur.next;
        }

        return sb.toString();
    }

}
