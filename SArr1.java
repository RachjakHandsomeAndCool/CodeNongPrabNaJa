import java.util.Random;

class SArr {
    private int arr[];
    Random rand = new Random();

    public SArr(int n) {
        arr = new int[n];
    }
    
    public void randVal(int m){
        for(int i = 0; i < arr.length ; i++){
            arr[i] = rand.nextInt(2*m+1) - m;
        }
    }

    public void insertSort(){
        int i,j,tmp;
        for( i = 1 ; i < arr.length ; i++){
            tmp = arr[i];
            for( j=i ; j > 0 && arr[j-1] > tmp ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    public  void selectionSort(){
        int i,j,tmp,minIndex;
        int n = arr.length;
        for(i=0;i<n;i++){
            minIndex = i;
            for(j = i+1 ; j<n ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public void bubbleSort(){
        boolean swapped = true;
        int j = 0;
        int tmp;
        while(swapped){
            swapped = false;
            j++;
            for(int i = 0;i<arr.length-j;i++){
                if(arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public void shellSort(){
        int j;
        for(int gap = arr.length/2 ; gap>0 ; gap/=2){
            for(int i = gap; i < arr.length; i++){
                int tmp = arr[i];
                for(j = i;j>=gap&&tmp<(arr[j-gap]);j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = tmp;
            }
        }
    }

    public void printVal(){
        for(int i = 0;i<arr.length;i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

}

public class SArr1 {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int round = 0 ; round < 4 ; round++){
            int n = rand.nextInt(11)+10;
            int m = rand.nextInt(41)+10;
            SArr A = new SArr(n);
            
            if(round == 0){
                A.randVal(m);
                System.out.println("Random " + n +" numbers" + " [" + n*-1 + ".." + n + "] :");
                A.printVal();
                A.insertSort();
                System.out.println("Insertion Sort :");
                A.printVal();
                System.out.println();
            }
            else if(round == 1){
                A.randVal(m);
                System.out.println("Random " + n +" numbers" + " [" + n*-1 + ".." + n + "] :");
                A.printVal();
                A.selectionSort();
                System.out.println("Selection Sort :");
                A.printVal();
                System.out.println();
            }
            else if(round == 2){
                A.randVal(m);
                System.out.println("Random " + n +" numbers" + " [" + n*-1 + ".." + n + "] :");
                A.printVal();
                A.bubbleSort();
                System.out.println("Bubble Sort :");
                A.printVal();
                System.out.println();
            }
            else if(round == 3){
                A.randVal(m);
                System.out.println("Random " + n +" numbers" + " [" + n*-1 + ".." + n + "] :");
                A.printVal();
                A.shellSort();
                System.out.println("Shell Sort :");
                A.printVal();
                System.out.println();
            }
        }
    }    
}
