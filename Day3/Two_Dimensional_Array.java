import java.io.*;

public class Two_Dimensional_Array {

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[][] = new int[3][2];

        System.out.println("Enter array element :");

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
            
        }

        System.out.println("Array Element :");

        for(int i = 0 ; i < arr.length ; i++){

            System.out.print(i + " : ");

            for(int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
                }

            System.out.println();


        }

    }
    
}
