// Java program to illustrate yield() method 
// in Java 
import java.lang.*; 
  
// MyThread extending Thread 
class MyThread extends Thread 
{ 
    public void run() 
    { 
        for (int i=0; i<100 ; i++) 
            System.out.println(Thread.currentThread().getName() 
                                + " in control"); 
    } 
} 
  
// Driver Class 
public class yieldDemo 
{ 
    public static void main(String[]args) 
    { 
//        MyThread t = new MyThread(); 
//        t.start(); 
//  
//        for (int i=0; i<5; i++) 
//        { 
//            // Control passes to child thread 
//            Thread.yield(); 
//  
//            // After execution of child Thread 
//            // main thread takes over 
//            System.out.println(Thread.currentThread().getName() 
//                                + " in control"); 
//        } 
    	
    	spawnThread();
    } 
    
    public static void spawnThread() {

        Thread innerThread = new Thread(new Runnable() {

            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.println("I am a new thread, count "+ i);
                }
            }
        });
        
        innerThread.setDaemon(true);
        innerThread.start();
        System.out.println("Main thread exiting");
    }
} 
