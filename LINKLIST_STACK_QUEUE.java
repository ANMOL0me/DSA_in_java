class LinkList {

    int[] stack = new int[5];
    int ptr;

    void display_linklist() {

        System.out.println(stack[0]);
        System.out.println(stack[1]);
        System.out.println(stack[2]);
        System.out.println(stack[3]);
        System.out.println(stack[4]);
    }
}

public class SQL {

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