
package Estructure_DinamicArray;

public class DinamicArray<T> {
    private T[] dinamicArray;
    private int counter;
    private int capacity;
    private  static final int N = 3;

    public DinamicArray(){
        this(N);
    }
    
    public DinamicArray(int n) {
        this.capacity = n;
        this.counter = 0;
        this.dinamicArray = (T[]) new Object[capacity];
    }
    
    public void add(T value){
        if(isFull()){
            expandArray();
        }    
        dinamicArray[counter] = value;
        counter++;
    }

    public void remove(int index){
        if(index < counter && index >= 0){
            for (int i = index; i < counter - 1; i++) {
                dinamicArray[i] = dinamicArray[i+1];
            }
            counter--;
            dinamicArray[counter] = null;
        }
        
    }
    
    
    public boolean update( T valueFind, T valueChange){
        // primero encontrar el indice
        boolean find = false;
        for(int i =0; i < counter; i++){
            // si encuntra el valor entonces lo cambia
            if(dinamicArray[i] == valueFind){
                dinamicArray[i] = valueChange;
                return(true);
            }
        }
        System.out.println("archivo no encontrado");
        return(false);
        
        
    }
    
    
    public void removeLast(){
        remove(counter-1);
    }
    
    public void expandArray(){
        // arreglo de valor doble
        capacity *= 2;
        T[] newArray = (T[])new Object[capacity];
        // copiar y pegar todos los valores en un nuevo dinamicArray
        for( int i=0; i<dinamicArray.length; i++){
            newArray[i] = dinamicArray[i];
        }
        dinamicArray = newArray;
    }

    // Establecer un elemento en una posición específica del arreglo.
    public void set(int indice, T elemento) {
        // Establecer un elemento en una posición específica del arreglo.
    }
    

    public int size() {
        return(counter);
    }

    public boolean isEmpty() {
        return(counter == 0);
    }


    public T get(int index){
        return dinamicArray[index];
    }
    
    public T getLast(){
        return dinamicArray[counter-1];
    }
    
    public boolean isFull(){
        return counter == capacity;
    }

        

}
