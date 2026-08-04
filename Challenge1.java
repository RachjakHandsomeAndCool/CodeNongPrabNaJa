import java.io.File;
import java.util.Scanner;

public class Challenge1 {
    
    public static void main(String[] args) {
        File file = new File("regdoc.txt");

        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("[:\\s]+");
            int n = sc.nextInt();
            System.out.println(n);

            for(int i = 0;i<n;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x + "" + y);
            }

            sc.close();
        } 
        
        catch (Exception e) {
            System.out.println("error");
        }
    }
}
