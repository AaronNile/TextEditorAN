package editorpack;

/*
 * Each node object stores a line in the linelist class
 *
 */


 //
public class Node{


    private String line;
    private Node next;

    public Node(String line){
        setLine(line);
        next=null;
    }

    public String getLine(){ // getter
        return line;
    }
    public void setLine(String line){ // setter
        // null is not allowed and set to an empty String
        if(line ==null){
            line ="";
        }
        this.line = line;
    }
    public Node getNext(){
        return next;
    }

    public void setNext(Node node){
        next=node;
    }

    public void replace(String s1, String s2){
        line = line.replace(s1, s2);
    }
}

