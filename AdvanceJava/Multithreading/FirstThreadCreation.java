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

/************************************************** USING THREAD CLASS ************************************************************************* */

// class IndiaThread extends Thread{

//     public void run(){      // public void run() is the method of Thread class , we are overiding it here , and 
//                             // there is an compulsion that all logic of thread should be written in run() method only 
        
        
//         try{
//             for(int i = 1 ; i<=5; i++){
//                 System.out.println(getName() + " : INDIA");
//                 Thread.sleep(1000);         // 1000 ms = 1 second , added this for delay of 1 second between iterations
//             }

//         }

//         catch(InterruptedException ie) {            // why try-catch witten : because in sleep() method a execption called "Interrupted Exception"
//                                                     // may occur , if sleep is not executed properly

//             ie.printStackTrace();

//         }
//     }
// }

// class AustraliaThread extends Thread{

//     public void run(){      // public void run() is the method of Thread class , we are overiding it here , and 
//                             // there is an compulsion that all logic of thread should be written in run() method only 
        
        
//         try{
//             for(int i = 1 ; i<=5; i++){
//                 System.out.println(getName() + " : AUSTRALIA");
//                 Thread.sleep(1000);         // 1000 ms = 1 second , added this for delay of 1 second between iterations
//             }

//         }

//         catch(InterruptedException ie) {            // why try-catch witten : because in sleep() method a execption called "Interrupted Exception"
//                               // may occur , if sleep is not executed properly

//             ie.printStackTrace();

//         }
//     }
// }

// public class FirstThreadCreation {

//     public static void main (String arg[]){
    
//                                                            //Default names , without using setName()
//     IndiaThread t = new IndiaThread();                                // Thread-0
//     AustraliaThread at = new AustraliaThread();                       // Thread-1
//     t.setName("IND-Thread");
//     at.setName("AUS-Thread");
    
//      t.start(); 
//     at.start();                         //start() method internally calls run() method i.e. go to start()
//                                         //it will take you to ThreadManager , which you make a thread for you and ,
//                                         //assign run() method to that thread , and this all logic is inside start()

//         System.out.println(t);          //Thread[Thread-0,5,main] --> if t.setName() not used
//         System.out.println(at);        //Thread[IND-Thread,5,main] --> if t.setName() is used
//     }
// }


/*
    1st india thread is executed , i = 1 , and System.out.println(getName() + " : INDIA"); is executed
    then it goes in sleep mode.

    then australia thread is executed , i = 1 , and System.out.println(getName() + " : AUSTRALIA"); is executed
    then it goes in sleep mode.

    and this is done till last iteration 

    Note : This overall process is carried out by ThreadScheduler 

    If we do not include sleep in any of the thread , then it will get executed weirdly 
    and each time the order will be different because , sequence depends on how much time "CPU" gives to ThreadScheduler 

*/

/************************************************** USING INTERFACE RUNNABLE ************************************************************************* */

//CHANGE
class IndiaThread implements Runnable{

    public void run(){     
                             
        
        
        try{
            for(int i = 1 ; i<=10; i++){
                System.out.println(Thread.currentThread().getName() + " : INDIA");
                //Thread.currentThread() --> we are implementing Runnable and .getName() is a method of Thread class therfore we directly cannot call .getName() method
                // Thread.currentThread() --> When run() executes:
                                             //If tob1 is running → Thread.currentThread() returns tob1 and it becomes tob1.getName() and tob1 is object of Thread class , in which t1(object of IndiaThread) is passed
                                             //If tob2 is running → Thread.currentThread() returns tob2 and it becomes tob1.getName() and tob2 is object of Thread class , in which t2(object of AustraliaThread) is passed
                Thread.sleep(1000);         
            }

        }

        catch(InterruptedException ie) {            

            ie.printStackTrace();

        }
    }
}

//CHANGE
class AustraliaThread implements Runnable{

    public void run(){       
        
        
        try{
            for(int i = 1 ; i<=5; i++){
                System.out.println(Thread.currentThread().getName() + " : AUSTRALIA");
                Thread.sleep(1000);        
            }

        }

        catch(InterruptedException ie) {            

            ie.printStackTrace();

        }
    }
}

public class FirstThreadCreation {

    public static void main (String arg[]){
    
    //CHANGE                                                    
    IndiaThread t1 = new IndiaThread(); // object of IndiaThread t1 created , and then object of Thread class tob1 is created and t1 is passed in it
    Thread tob1 = new Thread(t1); // IndiaThread is Implemented using Runnable and , now using this line : Thread tob1 = new Thread(t1); we are making it Thread Class
    // or , Thread t1 = new Thread(new IndiaThread) 

    /*
       Q. Why we are making it Thread Class
       ---> Because start and setName method are in thread class , and we have done IndiaThread as implements Runnable ,
            therefore to make IndiaThread a Thread class , Step 1 : Make object of IndiaThread
                                                           Step 2 : and While making object of Thread class , pass object of IndiaThread to it
    
    
         earlier we were extending Thread class , therefore object of IndiaThread or AustraliaThread class , was equivalent to object of Thread class
    */
    
    //CHANGE
    AustraliaThread t2 = new AustraliaThread();
    Thread tob2 = new Thread(t2);
    // or , Thread t2 = new Thread(new AustraliaThread)

    //CHANGE    
    tob1.setName("IND-Thread");
    tob2.setName("AUS-Thread");
    
    //CHANGE
    tob1.start(); 
    tob2.start();                         

    /*
    main() is also Thread , can this thread run parallely with IndiaThread and AustraliaThread?
    */

    try{

        for(int i=1;i<=2;i++){
            System.out.println("Main-Thread");
            Thread.sleep(1000);
        }
        //tob1.interrupt();
    }
    
    catch(InterruptedException e){
        e.printStackTrace();
      }
    
    System.out.println(tob1);
    System.out.println(tob2);

    }

    
}

/*
    Main methods ends means , program ends it is true only for "Uni-Threading"

    lets say , if IndiaThread is printed 10 times i.e. i=1;i<=10
                  AustraliaThread is printed 5 times i.e. i=1;i<=5

                  and Main Thread is printed two times i.e.

                  for(int i=1;i<2;i++){
                    System.out.println("Main-Thread");
                    Thread.sleep(1000);
                }

   now even if , Main-Thread is executed 2 times , i.e. code of main is done , still IndiaThread and AustraliaThread will complete its execution
   i.e. completion of one Thread does not means completion of other thread also.

   try{

        for(int i=1;i<=2;i++){
            System.out.println("Main-Thread");
            Thread.sleep(1000);
        }
        tob1.interrupt();  // it stops the excution of IndiaThread , after completion of itself
    }
    
    catch(InterruptedException e){
        e.printStackTrace();
      }

*/


/*

    Q. What is mean by Daemon Thread?
    --> Daemon Thread is a low priority(i.e. 1) thread which runs in background
        [#1,main,5,main] , 5 is Thread Priority (Priority : 1 to 10 , 1(lowest) , 10(highest))
    --> eg: Garbage Collector
    --> it does not have System.out.println() statement , because if it has it then it will show that it is existing by printing some msg

*/

/*

    IndiaThread and AustraliaThread both are doing same work i.e. printing some msg , and this could have done in
    a single class. --> this is generic coding , How this is done --> it is in PrintTextThread_Demo.java




*/

/*  
 
 we can call run() method without start() method , but then we will not be able to see multi-threading behaviour
 
 i.e. it will behave just like a display() method , means first code of run will execute and then , the code after 
 t1.run() will execute which is in main method i.e. parallelism will be lost
 
 ex:

 class IndiaThread extends Thread{

    public void run(){       
        
        
        try{
            for(int i = 1 ; i<=5; i++){
                System.out.println("I am in run");
                Thread.sleep(1000);         
            }

        }

        catch(InterruptedException ie) {            

            ie.printStackTrace();

        }
    }
}

public class FirstThreadCreation {
    public static void main(String args[]){

        PrintTextThread t1 = new PrintTextThread();
        t1.run();

            try{

        for(int i=1;i<=5;i++){
            System.out.println("Main-Thread");
            Thread.sleep(1000);
        }
        
    }
    
    catch(InterruptedException e){
        e.printStackTrace();
      }

    }
}


OutPut -->        I am in run
                  I am in run
                  I am in run
                  I am in run
                  I am in run
                  Main-Thread
                  Main-Thread
                  Main-Thread
                  Main-Thread
                  Main-Thread  

 1st run() will get executed and then on its completion , main() will execute its code 
 
 
 */

 /*
 
    class IndiaThread extends Thread{

    public void run(){       
        
        
        try{
            for(int i = 1 ; i<=5; i++){
                System.out.println("I am in run");
                Thread.sleep(1000);         
            }

        }

        catch(InterruptedException ie) {            

            ie.printStackTrace();

        }
    }
}

public class FirstThreadCreation {
    public static void main(String args[]){

        PrintTextThread t1 = new PrintTextThread();
        t1.start();

            try{

        for(int i=1;i<=5;i++){
            System.out.println("Main-Thread");
            Thread.sleep(1000);
        }
        
    }
    
    catch(InterruptedException e){
        e.printStackTrace();
      }

    }
}
 
Q. Why , always Main-Thread gets executed even when , t1.start() is called above it?

Main-Thread <-----------
I am in run
I am in run
Main-Thread
I am in run
Main-Thread
I am in run
Main-Thread
I am in run
Main-Thread
 
--> Because , JVM takes time to build configuration for start()
i.e. to run the thread parallel , it has to create the environment i.e. to give the thread its stack , its heap , its registor , etc...

and here it is getting printed 1st only one time because we have added sleep(1000) there that gives time JVM to setup start()
if we remove sleep(1000) from main-thread , then Main-Thread will get printed 5 times 1st , because it takes very less time to print Main-Thread just 5 times 

o/p on removing sleep(1000) from Main-Thread

Main-Thread
Main-Thread
Main-Thread
Main-Thread
Main-Thread
I am in run
I am in run
I am in run
I am in run
I am in run

*/

