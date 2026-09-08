import java.util.Random;

class  Queue {

    private class Node {
        private Object info = null;
        private Node link = null;

        public Node(Object info, Node link) {
            this.info=info; 
            this.link=link;
        }
        public Node(Object info)	{
            this(info,null);
        }
        public Node()	{
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

    private Node queueFront = null;
    private Node queueBack = null;
    private int queueSize = 0;

    public Queue() { }

    public int getSize() {
        return this.queueSize;
    }

    public boolean isEmpty() { 
        return (queueSize == 0); 
    }

    public boolean isFull() { 
        return false; 
    }

    public void initialize()  { 
        queueFront = null;
        queueBack = null;
    }

    public void enQueue(Object newItem) throws Exception  { 
        Node newNode = new Node(newItem);    
        if(queueFront==null) {
            queueFront=newNode;
        } else
            queueBack.setLink(newNode);
        queueBack=newNode;
        queueSize++;
    }

    public Object deQueue() throws Exception {
        Object itemInfo;
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        itemInfo=queueFront.getInfo();
        queueFront=queueFront.getLink();
        queueSize--;
        return itemInfo;
    }

    public Object front() throws Exception { 
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        return queueFront.getInfo(); 
    }
    public Object back() throws Exception { 
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        return queueBack.getInfo(); 
    }
    public void print() {
        System.out.print("[ ");
            print(queueFront);
        System.out.println(" ]");
    }
    public void print(Node trav) {
        if(trav!=null)
        {   System.out.print(trav.getInfo());
            if(trav.getLink()!=null)
                System.out.print(" ");
            print(trav.getLink());
        }
    }
}

public class QueueOddEven {
 
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int n = rand.nextInt(11) + 10;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(101);
        }

        Queue evenQueue = new Queue();
        Queue oddQueue = new Queue();
 
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                evenQueue.enQueue(numbers[i]);

            } 
            else {
                oddQueue.enQueue(numbers[i]);
                
            }
        }

        int evenInitialSize = evenQueue.getSize();
        int oddInitialSize = oddQueue.getSize();

        System.out.println("--- Random Numbers [" + n + "] ---");

        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("--- Even Queue [" + evenInitialSize + "] ---");

        evenQueue.print();
        System.out.println("--- Odd Queue [" + oddInitialSize + "] ---");
        oddQueue.print();

        int winCountEven = 0;
        int winCountOdd = 0;
        int round = 0; 

        while (!evenQueue.isEmpty() && !oddQueue.isEmpty()) {
            int evenFront = (Integer) evenQueue.front();
            int oddFront = (Integer) oddQueue.front();
            round++;

            if (evenFront > oddFront) {
                evenQueue.deQueue();
                winCountEven++;

            } 
            else if (oddFront > evenFront) {
                oddQueue.deQueue();
                winCountOdd++;

            } 
            else {
                evenQueue.enQueue(evenQueue.deQueue());
                oddQueue.enQueue(oddQueue.deQueue());
            
            }
        }

        if (evenQueue.isEmpty()) {
            System.out.println("===>  Winner is Even!");
            System.out.println("Round = " + round + ", Win = {E:" + winCountEven + ",O:" + winCountOdd + "}, Odd Left = " + oddQueue.getSize());

        } 
        else {
            System.out.println("===> Winner is Odd!");
            System.out.println("Round = " + round + ", Win = {E:" + winCountEven + ",O:" + winCountOdd + "}, Even Left = " + evenQueue.getSize());

        }
    }
}