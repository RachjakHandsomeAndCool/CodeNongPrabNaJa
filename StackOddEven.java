import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Stack {

    private class Node {
        private Object info = null;
        private Node link = null;

        public Node(Object info, Node link) {
            this.info=info; 
            this.link=link;
        }
        public Node(Object info) {
            this(info,null);
        }
        public Node() {
            this(null,null);
        }
        public Object getInfo() {
            return this.info;
        }
        public void setInfo(Object info) {
            this.info=info;
        }
        public Node getLink() {
            return this.link;
        }
        public void setLink(Node node) {
            this.link = node;
        }
    }

    private Node stackTop = null;
    private int stackSize = 0;

    public Stack() {
        stackTop = null;
    }
    public int getSize() {
        return this.stackSize;
    }
    public boolean isEmptyStack() { 
        return (stackTop == null); 
    }
    public boolean isFullStack() { 
        return false; 
    }
    public void initializeStack() { 
        stackTop = null;
    }
    public void push(Object newItem) throws Exception { 
        Node newNode = new Node(newItem);
        newNode.setLink(stackTop);	
        stackTop = newNode;
        stackSize++; 	//increment stackSize
    }
    public Object pop() throws Exception {
        Object itemInfo;
        if (isEmptyStack()) 
            throw new Exception("StackUnderflow"); 
        itemInfo=stackTop.getInfo();
        stackTop=stackTop.getLink();
        stackSize--; 	//decrement stackSize 
        return itemInfo;
    }
    public Object peek() throws Exception { 
        if (isEmptyStack()) 
            throw new Exception("StackUnderflow"); 
        return stackTop.getInfo(); 
    }
}


 
public class StackOddEven {
   public static void main(String[] args) throws Exception {

        Random rand = new Random();
        int n = rand.nextInt(11) + 10; 
        int[] numbers = new int[n]; 
        Stack evenStack = new Stack();
        Stack oddStack  = new Stack();

        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(101); 
            numbers[i] = value;
            if (value % 2 == 0) {
                evenStack.push(value);
            } else {
                oddStack.push(value);
            }
        }
        System.out.println("--- Random Numbers [" + n + "] ---");

        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("--- Even Stack [" + evenStack.getSize() + "] ---");

        Stack evenStackNew = new Stack();
        while (!evenStack.isEmptyStack()) {
            Object value = evenStack.pop();
            System.out.print(value + " ");
            evenStackNew.push(value);
        }
        System.out.println();
        System.out.println("--- Odd Stack [" + oddStack.getSize() + "] ---");

        Stack oddStackNew = new Stack();
        while (!oddStack.isEmptyStack()) {
            Object value = oddStack.pop();
            System.out.print(value + " ");
            oddStackNew.push(value);
        }
        System.out.println();

        while (!evenStackNew.isEmptyStack() && !oddStackNew.isEmptyStack()) {
            int evenTop = (Integer) evenStackNew.peek();
            int oddTop  = (Integer) oddStackNew.peek();

            if (evenTop > oddTop) {
                evenStackNew.pop();

            } 
            else if (oddTop > evenTop) {
                oddStackNew.pop();

            } 
            else {
                evenStackNew.pop();
                oddStackNew.pop();
            }
        }

        if (evenStackNew.isEmptyStack() && oddStackNew.isEmptyStack()) {
            System.out.println("===> Draw");
            
        } 
        else if (evenStackNew.isEmptyStack()) {
            System.out.println("===> Even is the winner!");

        } 
        else {
            System.out.println("===> Odd is the winner!");

        }
    }
}
