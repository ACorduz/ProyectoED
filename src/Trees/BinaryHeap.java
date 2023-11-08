/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;

import Data.Product;
import java.util.Date;

/**
 *
 * @author die_a
 */
public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize; // Number of elements in the heap
    private Product[] array; // The heap array

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Product[capacity + 1];
    }

    public void insert(Product x) {
        if (x.getExpirationDate() == null) {
            // Producto sin fecha de vencimiento, se agrega al final del montículo
            currentSize++;
            if (currentSize == array.length) {
                enlargeArray(array.length * 2 + 1);
            }
            array[currentSize] = x;
        } else {
            // Producto con fecha de vencimiento, se inserta según la lógica actual
            if (currentSize == array.length - 1) {
                enlargeArray(array.length * 2 + 1);
            }

            // Percolate up
            int hole = ++currentSize;

            for (array[0] = x; x.getExpirationDate().compareTo(array[hole / 2].getExpirationDate()) < 0; hole /= 2) {
                array[hole] = array[hole / 2];
            }

            array[hole] = x;
        }
    }
    public Product deleteMin() {
        if (isEmpty()) {
            return null;
        }
        Product minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public Product findMin() {
        if (isEmpty()) {
            return null;
        }
        return array[1];
    }

    private void percolateDown(int hole) {
        int child;
        Product tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].getExpirationDate().compareTo(array[child].getExpirationDate()) < 0) {
                child++;
            }
            if (array[child].getExpirationDate().compareTo(tmp.getExpirationDate()) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    private void percolateUp(int index) {
        Product newValue = array[index];
        while (index > 1 && newValue.getExpirationDate().compareTo(array[index / 2].getExpirationDate()) < 0) {
            array[index] = array[index / 2];
            index /= 2;
        }
        array[index] = newValue;
    }

    private void enlargeArray(int newSize) {
        Product[] newArray = new Product[newSize];
        System.arraycopy(array, 1, newArray, 1, currentSize);
        array = newArray;
    }
    
    public void printHeap() {
        BinaryHeap tempHeap=new BinaryHeap(); // Crear un montículo temporal

        while (!isEmpty()) {
            Product minItem = deleteMin(); // Eliminar el elemento mínimo
            System.out.println(minItem); // Imprimir el elemento mínimo
            tempHeap.insert(minItem); // Insertar el elemento mínimo en el montículo temporal
        }

        // Restaurar el montículo original con los elementos eliminados
        while (!tempHeap.isEmpty()) {
            insert(tempHeap.deleteMin());
        }
    }
}