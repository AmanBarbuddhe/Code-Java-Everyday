/*

    Thread Synchronization
    --> Thread Synchronization is a mechanism that ensures that only one thread can access a critical section
        (shared resources --> crictical section is that region , which many programs want to access it) at a time.
        ex : printer is a critical section , only one person can access it at a time.
        ex : if Synchronization is not there , then it will be like at front page notes of C language are printed
             and at back page Java notes are printed i.e. inconsistency
    
    --> This prevents race conditions(i.e. avoids multiple programs to access a resourse(critical section) at a time ) 
        and ensures data consistency when multiple threads operate on shared data.
    
    --> If we do not do synchronization then each thread may modify same resources at the same time which may leave
        the resources in an inconsistent state such situation is called "race condition".


     ex of inconsistent state:

     count = 0;
     count = count + 1;

     thread 1 --> t1 , thread 2 --> t2 

     t1 is accessing count : count = count + 1
                                        0  + 1
     but before assigning it to count , cpu stops t1 (tells t1 that its time is over)

     then comes t2 , count = count + 1
                               0   + 1
     and count becomes , count = 1 , work of t2 is done it goes back , and t1 is again scheduled 

     after t1 comes again it will complete its previous task that was kept incomplete earlier 
     and gives count = 1 

     but t2 already made it count = 1 and again t1 is making it count = 1 , whereas count should have been count = 2

     this is inconsistent state

     if this operation was synchronised then t2 will not perform the operation until and unless t1 completes its operation



*/

/******************** Method Synchronized ********************/
class Resource {

    int count = 0;

    public synchronized void increment(){    // synchronized means , until t1 completes using the resource , t2 will not use the resource
        count ++; // critical section 
    }

}

/******************** Block Synchronized ********************/

/* 


    class Resource {

    int count = 0;

    public void increment(){    
        
       System.out.println("Hello");    // now this can be used by both threads at a time


       synchronized(this){
        count++; // critical section  --> But this will be used by only one thread at a time
       }


       System.out.println("Byeeeee");  // now this can be used by both threads at a time


    }

}

*/ 

class AddThread extends Thread{

    Resource r;
    
    public AddThread(Resource r){
        this.r = r;
    }

    public void run(){
        
      for(int i = 1 ; i <= 5000 ; i++){
            r.increment();
      }

    }

}

public class ThreadSynchronization {
    
    public static void main(String args[]) throws InterruptedException
    {

        Resource r = new Resource();

        // two threads are sharing same resource
        AddThread t1 = new AddThread(r);
        AddThread t2 = new AddThread(r);   
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count : " + r.count);

    }

}
