import java.util.*;

public class Scan {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st no :");
        int a = sc.nextInt();

        System.out.print("Enter 2nd no :");
        int b = sc.nextInt();

        System.out.println("Sum of a and b is " + (a+b));

        sc.close();


    }
    
}
