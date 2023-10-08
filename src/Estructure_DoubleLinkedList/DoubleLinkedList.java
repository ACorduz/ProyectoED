
package Estructure_DoubleLinkedList;

import java.io.Serializable;


public class DoubleLinkedList <T> implements EstructureDoubleLinkedList<T> ,Serializable{
    // esta estrcutura esta hecha para soportar objetos
    private Node head;
    private Node tail; 
    private int counter;
    
    public DoubleLinkedList(){
        counter = 0;
        head = new Node(null);
        tail = new Node(null);
    }
    
    // add to front
    public void pushFront(T value){
        // si la cabeza es nula
        Node nodeNew = new Node(value);
        if(head.getNext()== null){
            head.setNext(nodeNew);
            tail.setNext(nodeNew);
        }else{
            // ponerle el prev
            head.getNext().setPrev(nodeNew);
            nodeNew.setNext(head.getNext());
            head.setNext(nodeNew);
        }
        counter++;
    }
    
    // Devuelve el item del frente
    public T topFront(){
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }else{
            return(T) (head.getNext().getData());
        }

    }
    
    // remove front item 
    public void popFront(){
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }
        // ponemos la cabeza en el nuevo 
        Node nodePop = head.getNext();
        head.setNext(nodePop.getNext());
        // si head es null solo hay un elemento
        if(head.getNext() == null){
           tail.setNext(null);
        }else{
            nodePop.getNext().setPrev(null);
        }
        counter--;
    }
     
    // add to back
    public void pushBack(T value){
        // crear el nodo nuevo
        Node nodeNew = new Node(value);
        // si tail es igual a null no hay valores 
        if(tail.getNext()== null){
            head.setNext(nodeNew);
            tail.setNext(nodeNew);
        }else{
            tail.getNext().setNext(nodeNew);
            nodeNew.setPrev(tail.getNext());
            tail.setNext(nodeNew);
        }
        counter++;
    }
    
    // return back item 
    public T topBack(){
        if(empty()){
            throw new RuntimeException("empty list, null tail");
        }else{
            return(T) (tail.getNext().getData());
        }
    }
    
    // remove back item 
    public void popBack(){
        //Node nodePop = null;
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }
        else if(head.getNext() == tail.getNext()){
            head.setNext(null);
            head.setNext(null);
        }
        // es o(n) no sabemos cual es el anterior al tail 
        else{
            tail.setNext(tail.getNext().getPrev());
            tail.getNext().setNext(null);
        }
        counter--;
    }
    
    // ojo con este probar
    public void addAfter(Node node,T key){
        Node nodeNew = new Node(key);
        nodeNew.setNext(node.getNext());
        nodeNew.setPrev(node);
        node.setNext(nodeNew);
        if(nodeNew.getNext() != null){
            nodeNew.getNext().setPrev(nodeNew);
        }
        else if(tail.getNext() == node){
            tail.setNext(nodeNew);
        }
        counter++;
    }
    
    public void addBefore(Node node, T key){
        Node nodeNew = new Node(key);
        nodeNew.setNext(node);
        nodeNew.setPrev(node.getPrev());
        node.setPrev(nodeNew);
        if(nodeNew.getPrev() != null){
            nodeNew.getPrev().setNext(nodeNew);
        }
        else if(head.getNext() == node){
            head.setNext(nodeNew);
        }
    }
    
    public boolean empty(){
        return(head.getNext()== null);
    }
    
    public boolean find(T key){
        boolean found = false;
        if(empty()){
            return(found);
            //throw new RuntimeException("empty list, null head");
        }else{
            if(tail == head && head.getNext().getData() == key){
                found = true;
            }
            else{
                Node current = head;
                Node prev = new Node();
                prev.setNext(null);

                while(current.getNext() != null){
                    current = current.getNext();
                    T i = (T) current.getData();
                    //System.out.println("El comparable es asi:"+i.compareTo(key));
                    if(i == key){
                        return(true);
                    }
                }
            }
            if(tail.getNext().getData() == key){
                    found = true; 
            }
        }
            return(found);
    }
           
        
    public Node getNodeForKeyWhioutCheck(T key){
        if(empty()){
            return(null);
        }
        else if(tail == head && head.getNext().getData() == key){
            return(head.getNext());
        }else{
            Node current = head;
            Node prev = new Node();
            prev.setNext(null);
            while(current.getNext() != null){
                current = current.getNext();
                T i = (T) current.getData();
                if(i == key){
                    return(current);
                }
            }
            if(tail.getNext().getData() == key){
                return(tail.getNext()); 
            }
        }
        return(null);
    }
    
    
    public Node getNodeForakey(T key){
        if(find(key)){
            return(getNodeForKeyWhioutCheck(key));
        }else{
            return(null);
        }
    }
    
    public boolean updateNode(T keySearch,T valueUpdate ){
        boolean found = false;
        if(empty()){
            return(found);
            //throw new RuntimeException("empty list, null head");
        }else{
            if(tail == head && head.getNext().getData() == keySearch){
                found = true;
            }
            else{
                Node current = head;
                Node prev = new Node();
                prev.setNext(null);

                while(current.getNext() != null){
                    current = current.getNext();
                    T i = (T) current.getData();
                    //System.out.println("El comparable es asi:"+i.compareTo(key));
                    if(i == keySearch){
                        current.setData(valueUpdate);
                        return(true);
                    }
                }
            }
            if(tail.getNext().getData() == keySearch){
                    tail.getNext().setData(valueUpdate);
                    found = true; 
            }
        }
            return(found);
    }
    
    public int getCounter(){
        return(counter);
    }
    
    public void setCounter(int counter){
        this.counter = counter;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" + "head=" + head + ", tail=" + tail + ", counter=" + counter + '}';
    }
    
    
    
}
