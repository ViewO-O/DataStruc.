package FINALdt;


public class Binarysearch {
    public static int BinarySearch(int[]arr,int x){
        int low , mid ,high;
        low =0;
        high = arr.length -1 ;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]<x){
                low = mid +1;
            }
            else if (arr[mid]>x){
                high = mid -1 ;
            }
            else{
                return mid;  // FOUND! //
            }
        }
        return -1 ; // NOT FOUND //
    }

    public static void main(String[] args) {
        // test case //
                   //0,1,2,3,4//
        int arr[] = {2,3,4,10,40};
        int x = 10 ; // target

        int value = BinarySearch(arr, x);
        if (value == -1 ){
            System.out.println("Not Found");
        }
        else{
            System.out.println("Found");
            System.out.println("target is "+ value);
        }
        
    }
    
}
