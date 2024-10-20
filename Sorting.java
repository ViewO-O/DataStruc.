package FINALdt;

import java.util.Random;

class sortMethod{
    int arr[];
    public sortMethod(int n){
        this.arr = new int[n];
    }

    public void randVal(int m){
        Random rand = new Random();
        for(int i = 0 ; i<arr.length;i++){
            arr[i] = rand.nextInt(-m,m);
        }
    }

    public void insertSort(){
        int i,j,tmp;
        for (i=1;i<arr.length;i++){
            tmp =arr[i];
            for( j = i ; j>0 && arr[j-1]>tmp; j--){
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
            }
        }
    }

    public  void selectionSort(){
        int i,j,minIndex,tmp;
        int n=arr.length;
        for(i=0;i<n-1;i++){
            minIndex=i;
            for(j=i+1;j<n;j++)
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            if(minIndex != i){
                tmp=arr[i];
                arr[i]=minIndex;
                arr[minIndex]=tmp;
            }
        }
   }

    public void bubbleSort(){
    boolean swapped = true;
    int j=0;
    int tmp;
    while(swapped){
        swapped = false;
        j++;
        for(int i =0;i<arr.length-j;i++){
            if(arr[i]>arr[i+1]){
                tmp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
                swapped = true;
            }
        }
        }
   }

   public void shellsort(){
    int j;
    for(int gap= arr.length/2;gap>0;gap/=2){
       for(int i = gap;i<arr.length;i++){
        int tmp = arr[i];
        for(j=i;j>=gap&&tmp<(arr[j-gap]);j-=gap){
            arr[j]=arr[j-gap];
            arr[j-gap]=tmp;
        }      
       }
    }

}
   /* public void quicksort(int L,int R){
        int pivot , tmp ;
        int i = L ; int j = R;
        pivot = arr[(L+R)/2];
        do {
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                tmp=arr[i];
                arr[i] = arr[i];
                arr[j] = tmp ;
                i++ ;
                j++ ;
            }
        } while (i<=j);
        if(L<j){
            quicksort(L, j);
        }
        if(i<R){
            quicksort(i, R);
        }
    } /* */

    public void printVal(){
        for(int i = 0 ; i<arr.length ;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
}

public class Sorting {
    public static void main(String[] args) {
        Random r = new Random();

        for(int i=0;i<4;i++){
        int n=r.nextInt(10,20);
        int m=r.nextInt(10, 50);

         sortMethod SArr = new sortMethod(n);
         System.out.println("Random numbers "+n+" numbers [-"+m+"..."+m+"] :");
         SArr.randVal(m);
         SArr.printVal();
 
         if(i==0){
             System.out.println("Insertion Sort : ");
             SArr.insertSort();
             SArr.printVal();
             System.out.println("----------------------------------");
 
         }
         if(i==1){
            System.out.println("Selection Sort : ");
            SArr.insertSort();
            SArr.printVal();
            System.out.println("----------------------------------");

        }
        if(i==2){
            System.out.println("Bubblesort Sort : ");
            SArr.bubbleSort();
            SArr.printVal();
            System.out.println("----------------------------------");

        }
        if(i==3){
            System.out.println("shell Sort : ");
            SArr.shellsort();
            SArr.printVal();
            System.out.println("----------------------------------");

        }

        }
        

    }
}
