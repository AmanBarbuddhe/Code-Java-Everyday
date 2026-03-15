import java.util.*;
public class One_Dimensional_Array {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[3];

        System.out.println("Enter array element :");
        for(int i = 0 ; i < arr.length ; i++){

            arr[i] = sc.nextInt();

        }

        System.out.println("Array Elements :");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }

        sc.close();

    }
}
