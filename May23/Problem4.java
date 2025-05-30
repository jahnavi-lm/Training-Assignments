/* Linked Lists
Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. 
Add the two numbers and return the sum as a linked list. */
public class Problem4 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node sumLinkedlist(Node l1, Node l2){
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int a = (l1 != null) ? l1.data : 0;
            int b = (l2 != null) ? l2.data : 0;
            int sum = a+b+carry;
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry>0){
            curr.next = new Node(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        Node sum = sumLinkedlist(l1,l2);
        while (sum != null) {
            System.out.print(sum.data + " ");
            sum = sum.next;
        }

    }
    
}
