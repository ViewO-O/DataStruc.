package p8;

import java.util.Random;

import p7.stack;

public class P8ex {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10, 20); // random number 
        
        stack OddStack = new stack();
        stack EvenStack = new stack();
       
        stack newOdd = new stack(); //new
        stack newEven = new stack();

        String line = String.format("--- Random Numbers [%d] ---", n);
        System.out.println(line);
        try {
    
            for (int i = 0; i < n; i++) {
                int num = random.nextInt(0, 100);  //number 0-100
                System.out.print(num + " ");
                
                if (num % 2 == 0) {
                    EvenStack.push(num);
                } else {
                    OddStack.push(num);
                }
            }
            System.out.println();


            String EVENstr = String.format("--- Even Stack [%d] ---", EvenStack.getSize());
            String ODDstr = String.format("--- Odd Stack [%d] ---", OddStack.getSize());
            System.out.println(EVENstr);
            while (!EvenStack.isEmptyStack()) {
                int NewEven = (Integer) EvenStack.pop();
                System.out.print(NewEven+ " ");
                newEven.push(NewEven);
            }
            System.out.println();
            System.out.println(ODDstr);
            while (!OddStack.isEmptyStack()) {
                int NewOdd = (Integer) OddStack.pop();
                System.out.print(NewOdd + " ");
                newOdd.push(NewOdd);
            }
            System.out.println();

            
            int evenScr = 0;
            int oddScr = 0;
            while (!newEven.isEmptyStack() && !newOdd.isEmptyStack()) {
                int even = (Integer) newEven.pop();
                int odd = (Integer) newOdd.pop();
                if (even > odd) {
                    evenScr++;
                } else if (odd > even) {
                    oddScr++;
                }
            }
            if (evenScr > oddScr) {
                System.out.println("===> Even is the winner!");
            } else if (oddScr> evenScr) {
                System.out.println("===> Odd is the winner!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
