import java.io.File;
import java.util.Scanner;

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return "["+String.format("%.2f",this.width)+":"+String.format("%.2f",this.height)
                +"]"+"=>"+String.format("%.2f",this.getArea());
    }
}

public class Challenge1Edit2 {
    
    public static void main(String[] args) {
        File file = new File("regdoc.txt");

        try {
            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            double sum = 0;
            Rectangle rec[] = new Rectangle[n];
            
            for(int i = 0;i<n;i++){
                String text = sc.next();
                String recArr[] = text.split(":");
                int x = Integer.parseInt(recArr[0]);
                int y = Integer.parseInt(recArr[1]);
                rec[i] = new Rectangle(x,y);
                sum += rec[i].getArea();
                System.out.println(rec[i].toString());
            }
            System.out.println("Total Area : " + sum);

            sc.close();
        } 
        
        catch (Exception e) {
            System.out.println("error");
        }
        
    }
}
