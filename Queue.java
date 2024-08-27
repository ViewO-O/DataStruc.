package REVQ;
public class Queue {
    private Node queuefront=null;
    private Node queueRear=null;
    private int count =0;
  
    public void intitializeQueue(){
            queuefront=null;
            queueRear=null;
            count=0;
        }
        public boolean isEmptyQueue(){
            return(queuefront==null);
        }
        public boolean isFullQueue(){
            return false;
        }
        public Object front()throws Exception{ //peek
            if(isEmptyQueue())
                throw new Exception("QueueUnderflow");
                return queuefront.getInfo();
        }
        public Object back()throws Exception{
            if(isEmptyQueue())
                throw new Exception("QueueUnderflow");
                return queueRear.getInfo();
        }
        public void enQueue(Object newitem)throws Exception{
           Node newnode = new Node(newitem);
           if(queuefront==null){
            queuefront=newnode;
            queueRear=newnode;
           }
           else{
            queueRear.setLink(newnode);
            queueRear=queueRear.getLink();
           }
           count++;
            
        }
        public Object deQueue()throws Exception{
            Object iteminfo;
            if(isEmptyQueue())
            throw new Exception("QueueUnderflow");
            iteminfo = queuefront.getInfo();
            queuefront=queuefront.getLink();
            if(queuefront==null){
                queueRear=null;
            }
            count--;
            return iteminfo;
        
        }
        public int getSize(){
            return count;
        }
        
    }
    

