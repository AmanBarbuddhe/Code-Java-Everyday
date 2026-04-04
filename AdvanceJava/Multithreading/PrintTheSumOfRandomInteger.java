/*

Q.Take an array of size 100 , insert Random no. in it using Random Class 
and then Do some of all those random no.s which are present in the array.

--> This will be done using multi-threading

Divide the array of size 100 in 5 equal parts

0      19   20       39   40      59   60       79    80          99
+-------------------------------------------------------------------+
|         |             |            |             |                |          
|         |             |            |             |                |        
+-------------------------------------------------------------------+
    20          20          20              20              20
    t1          t2          t3              t4              t5

--> all thread have same action i.e. go from start to end , all the no.s that came between start to end add them and store it in a sum variable

each thread will require 4 things --> a[] , start index , end index , sum variable to store addition of no. between start and end index  




*/



import java.util.Random;
import java.util.Arrays;

class SumThread extends Thread{
    
    int a[];
    int start;
    int end;
    int sum;

    public SumThread(int a[] , int start , int end){
        this.a = a;
        this.start = start;
        this.end = end;
        this.sum = 0;        // we are not sending sum but we are initializing it to 0
    } 

    public void run(){

        for(int i = start ; i <= end ; i++){

            sum = sum + a[i];

        }

    }

}

public class PrintTheSumOfRandomInteger {
    public static void main(String args[]) throws Exception
    {

        Random r = new Random();

        int n = 100;
        int a[] = new int[n]; 
        

        for(int i = 0 ; i < n ; i++){

            a[i] = r.nextInt(1000);  // this insert each position of array with random no.s between 0 < a[i] < 1000

        }

        System.out.println(Arrays.toString(a)); // o/p--> [851, 44, 329, 609, 446, 487, 563, 599, 174, 797] and every time random no.s will get generated and we have to find its sum
        
        SumThread t1 = new SumThread(a, 0 , 19);
        SumThread t2 = new SumThread(a, 20 , 39);
        SumThread t3 = new SumThread(a, 40 , 59);
        SumThread t4 = new SumThread(a, 60 , 79);
        SumThread t5 = new SumThread(a, 80 , 99);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        /*
            without join we will get wrong answer every time , because after starting threads t1,t2,t3,t4,t5
            main thread doesn't wait to complete their execution , i.e. it takes sum which might have calculated
            while starting the threads(t1,t2,t3,t4,t5) and immediately will print it.

            Therefore we use join method to tell the main thread to join only after completion of Threads(t1,t2,t3,t4,t5)
            i.e. Main Thread is waiting to get Execution of its child threads to complete.

        */

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        /*
        
            Join is like we are blocking the main thread until its child Threads finish their execution

            Difference Between Block and sleep?
            --> 1)Thread is in sleep mode for some seconds(seconds as specified by us)
            --> 2)Thread is in Block state until child threads finish their execution
        
        
        
        
        */










        int Total = t1.sum + t2.sum +t3.sum + t4.sum + t5.sum;

        System.out.println("Total Sum : " + Total);
    }
}
