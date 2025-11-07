package oopsexp8og;

import java.util.*;

class TableTask implements Runnable {
    int n;
    TableTask(int n){ this.n = n; }

    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("[table] " + n + " x " + i + " = " + (n*i));
            try{ Thread.sleep(2000);}catch(Exception e){}
        }
    }
}

class DivisorTask implements Runnable {
    int n;
    DivisorTask(int n){ this.n = n; }

    public void run(){
        for(int i=1;i<=n;i++){
            if(n % i == 0){
                System.out.println("[divisor] " + i);
                try{ Thread.sleep(2000);}catch(Exception e){}
            }
        }
    }
}

public class ThreadNumberDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        Thread t1 = new Thread(new TableTask(num),"table");
        Thread t2 = new Thread(new DivisorTask(num),"divisor");

        t1.start();
        t2.start();
    }
