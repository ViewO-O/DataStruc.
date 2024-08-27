package p5;
import java.util.Scanner;

public class ListNum {

    /**
     * @param args the command line arguments
     */
    private Node head=null;
    public ListNum()
    {
    } 
    public void addNode(int newInfo) {
    	Node newNode = new Node(newInfo);
		newNode.setLink(head);	
		head = newNode;
    }

    public void addTailNode(int newInfo){
        Node newNode = new Node(newInfo);
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 != null){
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
        if(trav1 != trav2){
            trav2.setLink(newNode);
        }
        else{
            head.setLink(newNode);
        }

    }
   
    public void addSorted(int newInfo){
        Node newNode = new Node(newInfo);
        Node trav1 = head;
        Node trav2 = head;

        while(trav1 !=null && trav1.getInfo()<newNode.getInfo()){
            trav2=trav1;
            trav1=trav1.getLink();
        }

        newNode.setLink(trav1);
        if(trav1!=trav2){
            trav2.setLink(newNode);
        }
        else{
            head = newNode;
        }

    }
    
    public void DeleteHead(){
        if(head!=null){
            head=head.getLink();
        }
    }

    public void DeleteTail(){
        Node trav1 = head;
        Node trav2 = head;
        while (trav1 !=null && trav1.getLink()!=null){
            trav2 = trav1;
            trav1=trav1.getLink();
        }
        if(trav2 !=null){
            trav2.setLink(null);
            if(trav1== head){
                head=null;
            }
        }

    }
    
    public int SearchNum(int info){
        Node trav=head;
        int count=1;
        while(trav!=null && trav.getInfo()!=info){
            trav = trav.getLink();
            count++;
        }
        if(trav!=null){
            return count;
        }
        else{
            return 0;
        }

    }
  
    public void DeleteSearch(int info){
        Node trav1=head;
        Node trav2=head;
        Node trav3=head;
        int found = SearchNum(info);
        for(int i=0;i<found-1;i++){
            trav2=trav1;
            trav1=trav1.getLink();
        }
        if(trav2!=null){
            trav2.setLink(null);
            if(trav1==head){
                head=null;
            }
            else{
                trav3.setLink(trav1.getLink());
            }
        }

    }
    public int Size(){
        Node trav = head;
        int count=0;
        while(trav!=null){
            if(trav!=null){
                count++;
                trav=trav.getLink();
            }
        }
        return count ;
    }
    
    public String toString() {
        Node trav=head;
	String str="";
	while (trav!=null) {			
		str=str.concat(trav.toString());
		//str=str.concat(""+trav.getInfo());
                trav=trav.getLink();
		if(trav!=null)
                    str=str.concat(" | ");		
	}
	return str;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ListNum listNum1=new ListNum();
        listNum1.addNode(10);
        listNum1.addNode(20);
        listNum1.addNode(30);       
        System.out.println(listNum1);

        System.out.println("one  "+listNum1.Size());//1

        listNum1.addTailNode(19); //2
        System.out.println("two  "+listNum1);
         
        listNum1.addSorted(21); //3
        System.out.println("three  "+listNum1);

        listNum1.DeleteHead(); //4
        System.out.println("four  "+listNum1);

        listNum1.DeleteTail(); //5
        System.out.println("five  "+listNum1);

        System.out.println("six");
        int Info =sc.nextInt();
        if(listNum1.SearchNum(Info)!=0){ //6
            System.out.println("Found  "+listNum1.SearchNum(Info));
        }
        else{
            System.out.println("not Found");
        }

        System.out.println("seven");
            int Info2=sc.nextInt();
            listNum1.DeleteSearch(Info2);
            System.out.println(listNum1);

    }    
}
