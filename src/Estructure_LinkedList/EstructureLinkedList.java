
package Estructure_LinkedList;

public interface EstructureLinkedList<T>{
    void pushFront(T value);
    T topFront();
    void popFront();
    void pushBack(T value);
    T topBack();
    void popBack(); // o(n)
    void addAfter(Node node,T key);
    boolean empty();
    boolean find(T key);// o(n)
    //Node getNodeForKeyWhioutCheck(T key);
    //Node getNodeForakey(T key);
    //int compareTo(T item);
    
}
