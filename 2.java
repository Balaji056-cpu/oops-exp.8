package oopsexp8og;

import java.util.*;

class EvenTask implements Runnable {
    int arr[];
    EvenTask(int arr[]){ this.arr = arr; }
	
    public void run(){
        for(int x : arr){
            if(x % 2 == 0){
                System.out.println("[even] " + x);
                try{ Thread.sleep(2000); }catch(Exception e){}
            }
        }
    }
}

class OddTask implements Runnable {
    int arr[];
    OddTask(int arr[]){ this.arr = arr; }

    public void run(){
        for(int x : arr){
            if(x % 2 != 0){
                System.out.println("[odd]  " + x);
                try{ Thread.sleep(2000); }catch(Exception e){}
            }
        }
    }
}

public class ThreadArrayDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        System.out.println("Enter 10 numbers:");
        for(int i=0;i<10;i++){
            arr[i] = sc.nextInt();
        }

        Thread even = new Thread(new EvenTask(arr), "even");
        Thread odd  = new Thread(new OddTask(arr), "odd");

        even.start();
        odd.start();
    }
}
