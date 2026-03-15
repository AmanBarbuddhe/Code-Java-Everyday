// array if not initialized is by default initialized to 0 and fill functions fills array with value given by us for all indices
import java.io.*;
import java.util.Arrays;

public class ArrayFilling {

    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter array size :");

        int k =Integer.parseInt(br.readLine());
        int arr[] = new int[k];

        System.out.print("Enter no. you want to fill in the entire array :");
        int x = Integer.parseInt(br.readLine());

        Arrays.fill( arr , x );
        System.out.println(Arrays.toString(arr));
    
    }
}
