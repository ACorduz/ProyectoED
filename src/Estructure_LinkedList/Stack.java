package Estructure_LinkedList ;

import java.io.Serializable;

public class Stack<T> extends LinkedList implements EstructureStack<T>,  Serializable{
    
     public Stack() {
        super();
    }
     
    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            return (T) topBack(); // El método peek debe devolver el elemento en la parte superior de la pila
        }
    }
    
    public void push(T item) {
        pushBack((Comparable) item); // El método push debe agregar elementos en la parte superior de la pila
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            T output = (T) topBack(); // El método pop debe eliminar y devolver el elemento en la parte superior de la pila
            popBack();
            return output;
        } 
    }
}
