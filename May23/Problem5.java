public class Problem5{
    static class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
    } 
    public void reorder(Node head){
        if (head==null || head.next == null){
            return;
        }
        Node slow  = head;
        Node fast = head;
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow.next;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        Node first = head;
        Node Second = prev;
        while(Second!=null){
            Node temp1 = first.next;
            Node temp2 = Second.next;
            first.next = Second;
            Second.next = temp1;
            first = temp1;
            Second = temp2; 
        }
    }
    public static void main(String[] args){
        Problem5 obj = new Problem5();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        obj.reorder(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}