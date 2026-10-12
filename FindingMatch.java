import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class HashTable {

    private int[] table;
    private int[] status;
    private int tableSize;

    private static final int EMPTY = 0;
    private static final int OCCUPIED = 1;
    private static final int DELETED = 2;

    public HashTable(int size) {
        tableSize = size;
        table = new int[size];
        status = new int[size];
    }

    // Hash Function
    private int hashFunction(int key) {
        return key % tableSize;
    }

    // Insert using Linear Probing
    public void insert(int key) {

        int index = hashFunction(key);
        int startIndex = index;

        do {

            if (status[index] == EMPTY ||
                status[index] == DELETED) {

                table[index] = key;
                status[index] = OCCUPIED;

                System.out.print(
                    index+ ":" + key + " "
                );

                return;
            }

            // move to next position
            index = (index + 1) % tableSize;

        } while (index != startIndex);

        System.out.println("Hash table is full.");
    }

    // Search using Linear Probing
    public int search(int key) {

        int index = hashFunction(key);
        int startIndex = index;

        do {

            // ถ้าเจอตำแหน่งที่ไม่เคยถูกใช้
            // แสดงว่า key นี้ไม่มีอยู่ใน table
            if (status[index] == EMPTY) {
                return -1;
            }

            if (status[index] == OCCUPIED &&
                table[index] == key) {

                return index;
            }

            index = (index + 1) % tableSize;

        } while (index != startIndex);

        return -1;
    }

    // Delete
    public boolean delete(int key) {

        int index = search(key);

        if (index == -1) {
            return false;
        }

        status[index] = DELETED;

        return true;
    }

    // Display
    public void display() {
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if(status[i]==OCCUPIED){
                count++;
            }
        }
        System.out.println("--- Hash Table ["+count+"] ---");

        for (int i = 0; i < tableSize; i++) {
            if(status[i]==OCCUPIED){
                int key = table[i];
                int OriganoIndex = hashFunction(key);
                if(OriganoIndex!=i){
                    System.out.print(i+":"+key+"* ");
                }
                else{
                    System.out.print(i+":"+key+" ");
                }
            }
        }
        
    }
}

public class FindingMatch {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10,21);
        HashTable hashTable = new HashTable(2*n);
        ArrayList<Integer> arr = new ArrayList<>();
        int result[] = new int[n];
        
//Part 1 สุ่มค่าหรรษา
//--------------------------------------------------------------------------------//

        System.out.println("--- Random Numbers ["+n+"] ---");
        for(int i = 0;i<n;i++){
            int idx = random.nextInt(101);
            arr.add(idx);
        }

        Collections.shuffle(arr);
        List<Integer> arrShuf = arr.subList(0, n);

        for (int i = 0 ; i < arrShuf.size();i++) {
            int x = arrShuf.get(i);
            System.out.print(x + " ");
            result[i] = x;
        }
        System.out.println();

//Part 2 พิมพ์ HashTable ธรรมดา
//--------------------------------------------------------------------------------//
        
        System.out.println("--- Hash Table ["+n+"] --- ");
        for(int i=0;i<n;i++){
            hashTable.insert(result[i]);
        }
        System.out.println();

//Part 3 Finding Match 0w0
//--------------------------------------------------------------------------------//

        System.out.println("--- Finding Match ---");
        int stop = 0;
        int turtle = 0; //จริงๆแล้วมันคือ total นาจา (ตัวนับรอบ search) 

        while(stop<3){
            int m = random.nextInt(101);
            int target = 100-m;
            int x = hashTable.search(target);

            if(x!=-1){
                System.out.print(m +" ");
                hashTable.delete(target);
                stop++;
            }
            else System.out.print("!"+m+" ");
            turtle++;
        }
        System.out.println();
        System.out.println("Total Finding: "+turtle);

//Part 4 HashTable Finally
//--------------------------------------------------------------------------------//

        //ส่วนนี้แก้ตรง display ข้างบน
        hashTable.display();

    }
}
