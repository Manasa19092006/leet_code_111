/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        return head;
    }
    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;
        while (curr != null) {
            Node next = curr.next;
          if (curr.child != null) {
                Node childTail = dfs(curr.child);
                next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                last = childTail;
            } else {
                last = curr;
            }
            curr = next == null ? last.next : next;
        }
        return last;
    }
}