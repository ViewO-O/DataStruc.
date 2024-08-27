package p6;


import java.util.Scanner;
 
public class p6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Base 10: ");
        int num=sc.nextInt();
        int n=num;
        Stack s = new Stack();
        try{
            while (num>0) {
                int bit = num % 2;
                s.push(bit);
                if(s.isFullStack()){
                    System.out.println("error");
                }
                num=num/2;
            }
            System.out.print(String.format("%d Base 10 is ", n));
            while (!(s.isEmptyStack())) {
                System.out.print(s.pop());
            }
            System.out.print(" Base 2");
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
}
