import java.util.Arrays;
import java.io.*;

public class ArraySearch {
    
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter array size :");
        int k = Integer.parseInt(br.readLine());

        int arr[] = new int[k];

        System.out.println("Enter array elements :");

         for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter the element to be searched :");
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int pos = Arrays.binarySearch( arr , x );

        if( pos >= 0){
            System.out.println("Element is found at position :" + pos + " index");
        }
        else{
            System.out.println("Element not found");
        }

    }

}
