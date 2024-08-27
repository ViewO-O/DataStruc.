package REVQ;

public class stack {
    private int stacksize = 0;
    private Node stackTop = null;

    public stack(){
        stackTop =null;
    }
    public void initializeStack(){
        stackTop=null;
       
    }
    public boolean isEmptyStack(){
       return(stackTop==null);
    }
    public boolean isFullStack(){
        return false;
       
    }
    public void push(Object newItem){
        Node newNode = new Node(newItem);
        newNode.setLink(stackTop);
        stackTop=newNode;
        stacksize++;
       
    }
    public Object pop() throws Exception{
        Object itemInfo;
        if (isEmptyStack()) {
            throw new Exception("StackUnderflow");
        }
        itemInfo=stackTop.getInfo();
        stackTop=stackTop.getLink();
        stacksize--;
        return itemInfo;
    }
    public Object peek() throws Exception{
        if (isEmptyStack()) 
            throw new Exception("StackUnderflow");
        
        return stackTop.getInfo();
    }
    public int getSize(){  //count
        return stacksize;
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        Node current = stackTop;
        while(current!=null){
            sb.append(current.getInfo()).append(" ");
            current = current.getLink();
        }
        return sb.toString().trim();
    }
   
 
}