package REVQ;
/*
NO: xx
ID: 660710616
*/

import java.util.Scanner;

public class RevQ {

    public static void inputQ(Queue q) {
        Scanner keyboard = new Scanner(System.in);
        int data;
        try{
            do {
                data = keyboard.nextInt();
                if(data>=0)
                    q.enQueue(data);
            } while(data>=0);
        } catch(Exception e) {}
    } 

    public static void showQ(Queue q) {
        try {
            int size = q.getSize();
            int i = 0;
            while (i < size) {
                System.out.print(q.deQueue() + " ");
            }
        } catch (Exception e) {}
    }

    public static void reverseOddQ(Queue q) {
        try {
            stack odd = new stack();
            int size = q.getSize();
            for (int i = 0; i < size; i++) {
                if ((int)q.front()% 2!= 0) {
                    odd.push(q.front());  
                    q.enQueue(-1); 
                    q.deQueue(); 
                } else {
                    q.enQueue(q.front()); 
                    q.deQueue(); 
                }
            }
            for (int i = 0; i < size; i++) {
                if ((int)q.front() == -1) {
                    q.deQueue(); 
                    q.enQueue(odd.peek()); 
                    odd.pop(); 
                } else {
                    q.enQueue(q.front()); 
                    q.deQueue(); 
                }
            }
        } catch (Exception e) {}
    }
    
    public static void main(String[] args) {
        Queue q=new Queue();
        inputQ(q);
        reverseOddQ(q);
        showQ(q);
    }
}
