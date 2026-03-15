class node {
    String data ;
    Node prev;
    Node next;

    void insert(String data) {
    String[] info = new String[4] ; 
    this.data = data;
    data = info ;
    prev = null;
    next = null ;
        
    }
}

public class LINKLIST_STACK_QUEUE {

    public static void main(String[] args) {

        LinkList obj = new LinkList();

        obj.stack[0] = 2;
        obj.stack[1] = 3;
        obj.stack[2] = 4;
        obj.stack[3] = 5;
        obj.stack[4] = 6;

        obj.display_linklist();
    }
}