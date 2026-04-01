/*

    How to create Thread in Java?
    ----------------------------
    1) Extending Thread Class
        ex:
                 class A extends Thread{
                 
                 
                 
                 }

    2) Implementing Runnable interface
         ex:

                class A implements Runnable{
                
                
                }


    Why there are two ways of creating Thread class?
    ------------------------------------------------

    If class is already extended by some other class , then there is only one option to write thread logic , 
    that is by implementing "Runnable interface" because "java does not support multiple inheritance" 

    If class is already extended by some other class 
            i.e. class LogicScreen extends JFrame , Thread {
                         not allowed - java does not support multiple inheritance
            }
 
             here class LogicScreen is extending 2 classes , which is not possible 
             if class LoginScreen wants to create thread then it will have to , implement Runnable


*/


class IndiaThread extends Thread{

    public void run(){      // public void run() is the method of Thread class , we are overiding it here , and 
                            // there is an compulsion that all logic of thread should be written in run() method only 
        
        
        try{
            for(int i = 1 ; i<=5; i++){
                System.out.println("INDIA");
                Thread.sleep(1000);         // 1000 ms = 1 second , added this for delay of 1 second between iterations
            }

        }

        catch(InterruptedException ie) {            // why try-catch witten : because in sleep() method a execption called "Interrupted Exception"
                              // may occur , if sleep is not executed properly

            ie.printStackTrace();

        }
    }
}

public class FirstThreadCreation {

    public static void main (String arg[]){
    
    IndiaThread t = new IndiaThread();
    t.start();                          //start() method internally calls run() method i.e. go to start()
                                        //it will take you to ThreadManager , which you make a thread for you and assign
                                        //run() method to that thread , and this all logic is inside start()
    }
}
