import java.io.File;
import java.util.Scanner;

// class Rectangle {
//     private double width;
//     private double height;

//     public Rectangle(double width, double height) {
//         this.width = width;
//         this.height = height;
//     }
    
//     public double getWidth() {
//         return width;
//     }

//     public void setWidth(double width) {
//         this.width = width;
//     }

//     public double getHeight() {
//         return height;
//     }

//     public void setHeight(double height) {
//         this.height = height;
//     }

//     public double getArea() {
//         return width * height;
//     }

//     public double getPerimeter() {
//         return 2 * (width + height);
//     }

//     public String toString() {
//         return "["+String.format("%.2f",this.width)+":"+String.format("%.2f",this.height)
//                 +"]"+"=>"+String.format("%.2f",this.getArea());
//     }
// }

public class Challenge1Edit {
    
    public static void main(String[] args) {
        File file = new File("regdoc.txt");

        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("[:\\s]+");
            int n = sc.nextInt();
            double sum =0;
            Rectangle rec[] = new Rectangle[n];

            for(int i = 0;i<n;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                rec[i] = new Rectangle(x, y);
                sum += rec[i].getArea();
            }
            
            for(int j = 0;j<n;j++){
                System.out.println(rec[j].toString());
            }
            System.out.println("Total Area : " + sum);

            sc.close();
        } 
        
        catch (Exception e) {
            System.out.println("error");
        }
        
    }
}
