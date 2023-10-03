
package Business;
import Data.Product;
import Data.Beneficiary;
import Data.OccasionalDonor;
import Data.CompanyDonor;
import Data.Donnor;
import Estructure_LinkedList.Queue;
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;



public class Main {
    private static Queue listForChooseProduct = new Queue(); // primero una cola para poner los beneficiarios por orden de llegada
    private static DoubleLinkedList<Product> listOfProducts = new DoubleLinkedList(); // segundo una lista donde se van a poner todos los productos
    private static LinkedList<Beneficiary> listOfBeneficiaries= new LinkedList();
    private static LinkedList<Donnor> listOfDonors = new LinkedList(); 

    // lo de historial de acciones esta en la clase donador
    // luego cada donador tiene enlazado un producto
    
    
    
    public static void main(String[] args) {
        // prueba lista de objetos
        
        Product producto = new Product("FOOD", "Harina", 5,"@gmail");
        Product producto2 = new Product("FOOD", "Frijol", 5,"@gmail");
        Queue<Product> cola = new Queue();
        cola.enqueue(producto);
        cola.enqueue(producto2);
        Product product2 =cola.dequeue();
        System.out.println(product2.toString());
        System.out.println(cola.find(producto2));
        
        
    }
    
    // setter y getter de Main

    public static Queue getListForChooseProduct() {
        return listForChooseProduct;
    }

    public static void setListForChooseProduct(Queue listForChooseProduct) {
        Main.listForChooseProduct = listForChooseProduct;
    }

    public static DoubleLinkedList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public static void setListOfProducts(DoubleLinkedList<Product> listOfProducts) {
        Main.listOfProducts = listOfProducts;
    }

    public static LinkedList<Beneficiary> getListOfBeneficiaries() {
        return listOfBeneficiaries;
    }

    public static void setListOfBeneficiaries(LinkedList<Beneficiary> listOfBeneficiaries) {
        Main.listOfBeneficiaries = listOfBeneficiaries;
    }

    public static LinkedList<Donnor> getListOfDonors() {
        return listOfDonors;
    }

    public static void setListOfDonors(LinkedList<Donnor> listOfDonors) {
        Main.listOfDonors = listOfDonors;
    }
    
    
}
