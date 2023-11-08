package EstructurasCorte2;
import Data.Food;
import java.util.Date;

public class HeapMinor_ComidaFecha {
    private Food[] heapArray;
    private int capacity;
    private int size;

    public HeapMinor_ComidaFecha(int n) {
        capacity = n;
        heapArray = new Food[capacity];
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

    public void insert(Food key) {
        if (size == heapArray.length - 1) {
            throw new RuntimeException("El array está lleno y no se puede insertar más.");
        }
        size += 1;
        heapArray[size] = key;
        siftUp(size);
    }
    
    public Food extractMin() {
        if (size == -1) {
            throw new IllegalStateException("El montículo está vacío");
        }
      
        Food result = heapArray[0];
        heapArray[0] = heapArray[size];
        size -= 1;
        siftDown(0);
        return result;
    }
    

        
    private void swap( int a, int b) {
        Food temp = heapArray[a];
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

    
    public Food getMin() {
        return heapArray[0];
    }

    public void changePriority(int index, Food newKey) {
        Food oldKey = heapArray[index];
        heapArray[index] = newKey;

        Date dateOldKey = new Date(oldKey.getExpirationDateYear(), oldKey.getExpirationDateMonth(), oldKey.getExpirationDateDay());
        Date dateNewKey = new Date(newKey.getExpirationDateYear(), newKey.getExpirationDateMonth(), newKey.getExpirationDateDay());
        if (dateNewKey.compareTo(dateOldKey) < 0) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    public Food[] heapSort(Food[] arraySort) {
        for (int i = 0; i < arraySort.length; i++) {
            insert(arraySort[i]);
        }

        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = extractMin();
        }

        return arraySort;
    }

    public void remove(int year, int month, int day, String emailDonnor, String nameProduct) {
        int index = -1;

        // Buscar el índice del elemento que deseas eliminar.
        for (int i = 0; i <= size; i++) {
            if (compareToComida(heapArray[i], year,  month,  day,  emailDonnor,  nameProduct ) == 0) {
                index = i;
                System.out.println("emailDonnor " + emailDonnor);
                break;
            }
        }

        if (index == -1) {
            // El elemento no se encontró en el montículo.
            return;
        }

        // Reemplaza el elemento que deseas eliminar con el último elemento en el montículo.
        heapArray[index] = heapArray[size];
        size--;

        // Reajusta el montículo para mantener sus propiedades.
        Date date1 = new Date(year, month, day);
        Date date2 = new Date(heapArray[index].getExpirationDateYear(), heapArray[index].getExpirationDateMonth(), heapArray[index].getExpirationDateDay());
        if (date1.compareTo(date2) < 0) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    private int compareToComida(Food comida,int year, int month, int day, String emailDonnor, String nameProduct){
        // primero comparar fechas
        Date date1 = new Date(year, month, day);
        Date date2 = new Date(comida.getExpirationDateYear(), comida.getExpirationDateMonth(), comida.getExpirationDateDay());
        int comparacion = date1.compareTo(date2);
        if(comparacion == 0){
            if(emailDonnor.compareTo(comida.getEmailDonor()) == 0 && nameProduct.compareTo(comida.getNameProduct()) == 0){
                return(0);
            }else{
                return(-1);
            }
        }else {
            return(comparacion);
        }
    }

    public Food[] heapSort() {
        Food[] arraySort = new  Food[capacity];

        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = extractMin();
        }

        setHeapArray(arraySort);
        return arraySort;
    }

    public Food[] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(Food[] heapArray) {
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
