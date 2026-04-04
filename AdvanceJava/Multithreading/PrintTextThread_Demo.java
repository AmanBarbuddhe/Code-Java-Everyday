 //Q. Write PrintTextThread class , which prints message 'n' no. of times
 
 class PrintTextThread extends Thread{

    String msg;
    int n;

    PrintTextThread(String msg , int n){
        this.msg = msg;
        this.n = n;
    }

    public void run(){       
        
        
        try{
            for(int i = 1 ; i<=n; i++){
                System.out.println(i + " : " + msg);
                Thread.sleep(1000);         
            }

        }

        catch(InterruptedException ie) {            

            ie.printStackTrace();

        }
    }
}

public class PrintTextThread_Demo {
    public static void main(String args[]){

        /*
            This a good practice to write the code 

            First asked heap manager to give memory on heap to all objects(t1,t2,t3)

            and then ask ThreadManager to create all objects(t1.start,t2.start,t3.start)
       */

        PrintTextThread t1 = new PrintTextThread("IND" , 5);  // by doing this we have written a generic way to print both , IndiaThread and AustraliaThread , i.e. we dont need two separate thread to print IndiaThread and AustraliaThread
        PrintTextThread t2 = new PrintTextThread("AUS" , 5);
        PrintTextThread t3 = new PrintTextThread("ENG" , 5);
        
        t1.start();
        t2.start();
        t3.start();

    }
}
