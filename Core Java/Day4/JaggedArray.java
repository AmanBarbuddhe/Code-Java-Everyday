import java.io.*;

public class JaggedArray {

    public static void main(String args[]) throws Exception
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter no. of rows :");
        int k = Integer.parseInt(br.readLine());

        int arr[][] = new int[k][];

        for(int i = 0 ; i < arr.length ; i++){  // arr.length = k
            System.out.print("Enter no. of column in " + (i+1)+" row :");
            int t = Integer.parseInt(br.readLine());

            arr[i] = new int[t]; // int arr[0] = new int[3] , lets say t = 3 , this implies 0 --> [0,0,0] //as size is 3 and as java is robust , array initialized to 0

            for(int j = 0 ; j < t ; j++){
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
