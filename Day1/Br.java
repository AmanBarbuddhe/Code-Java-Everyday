import java.io.*;

public class Br {
    
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter 1st no :");
        int a = Integer.parseInt(br.readLine());

        System.out.print("Enter 2nd no :");
        int b = Integer.parseInt(br.readLine());

        System.out.println("Sum of a and b is " + (a+b));


    }

}
