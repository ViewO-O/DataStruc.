package REVQ;

public class Node {
    private Object info;
    private Node link;
    public Node(Object info,Node link)
   {
       this.info=info;
       this.link=link;
    }
    public Node(Object info)
    {
        this(info,null);
    }
    public Node()
    {
        this(0,null);
    }
    public Object getInfo() {
	return this.info;
    }
    public Node getLink() {
        return this.link;
    }
    public void setInfo(Object info) 
    {
	this.info=info;
    }
    public void setLink(Node node) {
        this.link = node;
    }
    public String toString() {
        return ""+this.info;
        }
    }
    