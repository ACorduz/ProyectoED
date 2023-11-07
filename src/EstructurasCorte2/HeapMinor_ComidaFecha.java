package EstructurasCorte2;
import Data.Comida;
import java.util.Date;

public class HeapMinor_ComidaFecha {
    private Comida[] heapArray;
    private int capacity;
    private int size;

    public HeapMinor_ComidaFecha(int n) {
        capacity = n;
        heapArray = new Comida[capacity];
        size = -1;
    }

 
    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(Comida key) {
        if (size == heapArray.length - 1) {
            throw new RuntimeException("El array está lleno y no se puede insertar más.");
        }
        size += 1;
        heapArray[size] = key;
        siftUp(size);
    }
    
    public Comida extractMin() {
        if (size == -1) {
            throw new IllegalStateException("El montículo está vacío");
        }
      
        Comida result = heapArray[0];
        heapArray[0] = heapArray[size];
        size -= 1;
        siftDown(0);
        return result;
    }
    

        
    private void swap( int a, int b) {
        Comida temp = heapArray[a];
        heapArray[a] = heapArray[b];
        heapArray[b] = temp;
    }

    public void siftUp(int index) {
        Date d2 = new Date(heapArray[index].getExpirationDateYear(), heapArray[index].getExpirationDateMonth(), heapArray[index].getExpirationDateDay());
        while (index > 0) {
            Date d1 = new Date(heapArray[parent(index)].getExpirationDateYear(), heapArray[parent(index)].getExpirationDateMonth(), heapArray[parent(index)].getExpirationDateDay());
            if (d1.compareTo(d2) > 0) {
                swap(index, parent(index));
                index = parent(index);
            } else {
                break;
            }
        }
    }
    

    public void siftDown(int index) {
        int minIndex = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        
        Date dateLeftChild = null;
        Date dateminIndex  = null; 
        try{
            dateLeftChild = new Date(heapArray[leftChild].getExpirationDateYear(), heapArray[leftChild].getExpirationDateMonth(), heapArray[leftChild].getExpirationDateDay()); 
            dateminIndex = new Date(heapArray[minIndex].getExpirationDateYear(), heapArray[minIndex].getExpirationDateMonth(), heapArray[minIndex].getExpirationDateDay());
        }catch(Exception io){
            //swap(index, minIndex);
            return; 
            
        }
        
        if (leftChild <= size && dateLeftChild.compareTo(dateminIndex) < 0) {
            minIndex = leftChild;
        }
        Date dateRightChild = null;
        try{
            dateRightChild = new Date(heapArray[rightChild].getExpirationDateYear(), heapArray[rightChild].getExpirationDateMonth(), heapArray[rightChild].getExpirationDateDay());            dateminIndex = new Date(heapArray[minIndex].getExpirationDateYear(), heapArray[minIndex].getExpirationDateMonth(), heapArray[minIndex].getExpirationDateDay());
        }catch(Exception io){
            return; 
        }
        
        if (rightChild <= size && dateRightChild.compareTo(dateminIndex) <0  ){
            
            minIndex = rightChild;
        }
        if (index != minIndex) {
            swap( index, minIndex);
            siftDown(minIndex);
            
        }
    }

    
    public Comida getMin() {
        return heapArray[0];
    }

    public void changePriority(int index, Comida newKey) {
        Comida oldKey = heapArray[index];
        heapArray[index] = newKey;

        Date dateOldKey = new Date(oldKey.getExpirationDateYear(), oldKey.getExpirationDateMonth(), oldKey.getExpirationDateDay());
        Date dateNewKey = new Date(newKey.getExpirationDateYear(), newKey.getExpirationDateMonth(), newKey.getExpirationDateDay());
        if (dateNewKey.compareTo(dateOldKey) < 0) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    public Comida[] heapSort(Comida[] arraySort) {
        for (int i = 0; i < arraySort.length; i++) {
            insert(arraySort[i]);
        }

        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = extractMin();
        }

        return arraySort;
    }


    public Comida[] heapSort() {
        Comida[] arraySort = new  Comida[capacity];

        siftDown(0);
        
        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = extractMin();
        }

        setHeapArray(arraySort);
        return arraySort;
    }

    public Comida[] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(Comida[] heapArray) {
        this.heapArray = heapArray;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
