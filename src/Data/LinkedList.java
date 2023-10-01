
package Data;


public class LinkedList <T extends Comparable<T>> implements EstructureLinkedList<T>{
    private Node head;
    private Node tail; 
    private int counter;
    private  T reference;
    
    public LinkedList(){
        counter = 0;
        head = new Node(null);
        tail = new Node(null);
    }
    
    // add to front
    public void pushFront(T value){
        Node node = new Node(value);
        // el nuevo nodo tener el next del head
        node.setNext(head.getNext());
        // ponerle el next al head
        head.setNext(node);
        if(tail.getNext() == null){
            // verificar esto
            tail.setNext(node);
           
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
        // sino es null obtner el valor del nodo a hacer pop
        Node nodePop = head.getNext();
        head.setNext(nodePop.getNext());
        if(head.getNext() == null){
           tail.setNext(null);
        }
        //return(T) (nodePop.getData()); 
        counter--;
    }
     
    // add to back
    public void pushBack(T value){
        // crear el nodo nuevo
        Node nodeNew = new Node(value);
        nodeNew.setNext(null);
        // si tail es igual a null no hay valores 
        if(tail.getNext()== null){
            head.setNext(nodeNew);
            tail.setNext(nodeNew);
        }else{
            tail.getNext().setNext(nodeNew);
            tail.setNext(nodeNew);
        }
        //System.out.println("Push back correcto=" + head.getNext().getData());
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
        if(head.getNext() == null){
            throw new RuntimeException("empty list, null head");
        }
        else if(head.getNext() == tail.getNext()){
            //nodePop = tail.getNext();
            head.setNext(null);
            head.setNext(null);
        }
        // es o(n) no sabemos cual es el anterior al tail 
        else{
            // p es el nodo anterior al final
            Node current = head;
            Node prev = new Node();
            prev.setNext(null);
            
            while(current.getNext().getNext() != null){
                prev = current; 
                current = current.getNext();
            }
            //nodePop = tail.getNext();
            current.setNext(null);
            tail.setNext(current);
        }
        counter--;
        //return(T) (nodePop.getData());
    }
    
    // ojo con este probar
    public void addAfter(Node node,T key){
        Node nodeNew = new Node(key);
        nodeNew.setNext(node.getNext());
        node.setNext(nodeNew);
        if(tail.getNext() == node){
            tail.setNext(nodeNew);
        }
        counter++;
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
                    prev = current; 
                    current = current.getNext();
                    Comparable i = (Comparable) current.getData();
                    //System.out.println("El comparable es asi:"+i.compareTo(key));
                    if(i.compareTo(key) == 0){
                        return(true);
                    }
                }
                if(tail.getNext().getData() == key){
                    found = true; 
                }
            }
            return(found);
        }
         
    }
    
        public int compareTo(T item){
        int result;
        // la referencia hace como decir a lo que se va a llamar
        if(reference.compareTo(item) > 0){
            result = 1;
        }else if(reference.compareTo(item) < 0){
            result = -1;
        }
        else{
            result =0;
        }
        return(result);
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
                prev = current; 
                current = current.getNext();
                Comparable i = (Comparable) current.getData();
                //System.out.println("El comparable es asi:"+i.compareTo(key));
                if(i.compareTo(key) == 0){
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
    
    
    
}
