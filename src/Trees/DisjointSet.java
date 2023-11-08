/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;
import java.io.Serializable;
/**
 *
 * @author die_a
 */
public class DisjointSet implements Serializable {
      private int[] parent;
    private int[] rank;  // Para realizar uniones basadas en rango.

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Cada elemento es su propio padre al principio.
            rank[i] = 0;   // Inicialmente, el rango es 0 para todos los elementos.
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Aplicación de compresión de ruta (path compression).
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;  // Incrementa el rango de rootY si son del mismo rango.
            }
        }
    }
}
