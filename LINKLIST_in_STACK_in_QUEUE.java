import java.util.*;
public class LINKLIST_in_STACK_in_QUEUE {

    public static void main(String[] args) {

        LinkedListSystem system = new LinkedListSystem();

        // create nodes
        system.addNode();
        system.addNode();

        // create queues
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(20);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(30);
        q2.add(40);

        // push queues into stacks
        system.addQueueToStack(1, q1);
        system.addQueueToStack(1, q2);

        system.display();
    }
}
class Node {

    Stack<Queue<Integer>> stack;
    Node next;

    Node() {
        stack = new Stack<>();
        next = null;
    }
}

class LinkedListSystem {

    Node head;

    // add new node to linked list
    void addNode() {

        Node newNode = new Node();

        if (head == null){
            head = newNode;}
        else {

            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }

        System.out.println("New node with stack created");
    }

    // push queue into stack of node
    void addQueueToStack(int nodePosition, Queue<Integer> q) {

        Node temp = head;
        int count = 1;

        while (temp != null && count < nodePosition) {
            temp = temp.next;
            count++;
        }

        if (temp != null) {
            temp.stack.push(q);
            System.out.println("Queue added to stack of node " + nodePosition);
        }
    }

    // display 
    void display() {

        Node temp = head;
        int nodeNum = 1;

        while (temp != null) {

            System.out.println("Node " + nodeNum);

            for (Queue<Integer> q : temp.stack) {
                System.out.println(q);
            }

            temp = temp.next;
            nodeNum++;
        }
    }
}
//more to do
