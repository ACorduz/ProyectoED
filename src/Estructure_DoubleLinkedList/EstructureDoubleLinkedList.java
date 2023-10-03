
package Estructure_DoubleLinkedList;

import Estructure_DoubleLinkedList.Node;


public interface EstructureDoubleLinkedList<T> {
    void pushFront(T value);
    T topFront();
    void popFront();
    void pushBack(T value);
    T topBack();
    void popBack();
    void addAfter(Node node,T key);
    void addBefore(Node node, T key);
    boolean empty();
    boolean find(T key);
    Node getNodeForKeyWhioutCheck(T key);
    Node getNodeForakey(T key);
    
}
