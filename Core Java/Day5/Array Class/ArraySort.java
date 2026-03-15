import java.util.*;
import java.util.Arrays;

public class ArraySort {
    
  public static void main(String[] args){
 
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size :");
    int k = sc.nextInt();

    int arr[] = new int[k];

    System.out.println("Enter arrays element :");

    for( int i = 0 ; i < arr.length ; i++ ){
        arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);
    System.out.println("Sorted array : " + Arrays.toString(arr));

    sc.close();

  }

}
