import java.util.Arrays;
import java.io.*;

public class PrintEntireArrayWithoutLoop 
{
  public static void main(String[] args) throws Exception
  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter array size :");
    
    int k = Integer.parseInt(br.readLine());

    int arr[] = new int[k]; 

    System.out.println("Enter array elements :");

    for( int i = 0 ; i < arr.length ; i++ ){
        arr[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(Arrays.toString(arr));     // toString is a static method of arrays class , which prints entire array.

   }
    
}
