/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasCorte3;

/**
 *
 * @author PC
 */
public class ChainingHashTableString<V> {

    private LinkedListGenerica<HashEntry<V>>[] harray;
    private int numberElements;

    public ChainingHashTableString(int size) {
        harray = new LinkedListGenerica[size];

        for (int i = 0; i < harray.length; i++) {
            harray[i] = new LinkedListGenerica();
        }
        numberElements = 0;
    }

    public void insert(String key, V value) {
        reHash(harray);
        HashEntry<V> entry = new HashEntry<>(key, value);
        harray[llamarPolyHash(key)].pushBack(entry);
        numberElements++;
    }

    public void delete(String key) {
        LinkedListGenerica<HashEntry<V>> list = harray[llamarPolyHash(key)];
        Node current = list.getHead().getNext();

        while (current != null) {
            HashEntry<V> entry = (HashEntry<V>) current.getData();
            if (entry.getKey().equals(key)) {
                list.delete(entry);
                numberElements--;
                break;
            }
            current = current.getNext();
        }
    }

    public V find(String key) {
        LinkedListGenerica<HashEntry<V>> list = harray[llamarPolyHash(key)];
        Node current = list.getHead().getNext();

        while (current != null) {
            HashEntry<V> entry = (HashEntry<V>) current.getData();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            current = current.getNext();
        }

        return null; // Clave no encontrada
    }

    public void printHashTable() {
        for (int i = 0; i < harray.length; i++) {
            System.out.print("harray[" + i + "] ");
            harray[i].printList();
        }
    }

    public int polyHash(String S, long p, int x) {
        int hash = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            hash = (int) ((hash * x + S.charAt(i)) % p);
        }

        return hash;
    }

    public int llamarPolyHash(String s) {
        int hash = polyHash(s, harray.length, 255);
        return hash;
    }

    public int llamarPolyHashRehash(String s, int modulo) {
        int hash = polyHash(s, modulo, 255);
        return hash;
    }

    private void reHash(LinkedListGenerica<HashEntry<V>>[] harrayViejo) {
        float loadFactor = (float) numberElements / harrayViejo.length;
        if (loadFactor > 0.9) {
            int nuevoTamaño = harrayViejo.length * 2;
            LinkedListGenerica<HashEntry<V>>[] harrayNuevo = new LinkedListGenerica[nuevoTamaño];

            for (int i = 0; i < harrayNuevo.length; i++) {
                harrayNuevo[i] = new LinkedListGenerica();
            }

            for (int i = 0; i < harrayViejo.length; i++) {
                Node current = harrayViejo[i].getHead().getNext();

                while (current != null) {
                    HashEntry<V> entry = (HashEntry<V>) current.getData();
                    harrayNuevo[llamarPolyHashRehash(entry.getKey(), nuevoTamaño)].pushBack(entry);

                    current = current.getNext();
                }
            }
            setHarray(harrayNuevo);
        }
    }

    public LinkedListGenerica<HashEntry<V>>[] getHarray() {
        return harray;
    }

    public void setHarray(LinkedListGenerica<HashEntry<V>>[] harray) {
        this.harray = harray;
    }

    public int getNumberElements() {
        return numberElements;
    }

    public void setNumberElements(int numberElements) {
        this.numberElements = numberElements;
    }

    private static class HashEntry<V> {
        private String key;
        private V value;

        public HashEntry(String key, V value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
