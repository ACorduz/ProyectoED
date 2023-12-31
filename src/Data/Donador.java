package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import EstructurasCorte2.DisjointSet;
import java.io.Serializable;




public class Donador extends Usuario implements Serializable {
    // la clase donador es hijo de la clase usurio y a la vez superclase
    private String adress;
    private String locality;
    private Queue<Producto> ListDonations;
    private Stack<Producto> HistoryOfDonations; 
    private int numberDonates;
    private DisjointSet productSet;
    // OJO typeOfUserNosDice Si es DonadorCompañia, donadorOcasional O Beneficiario
    
    // metodos constructores

    public Donador(String name,String lastName,  String email,String typeDocument ,String document, String password, String adress, String locality, Queue<Producto> ListDonations, Stack<Producto> HistoryOfDonations) {
        super(name,lastName, email, typeDocument, document,password);
        this.adress = adress;
        this.locality = locality;
        this.ListDonations = ListDonations;
        this.HistoryOfDonations = HistoryOfDonations;
        this.numberDonates = 0;
        this.productSet = new DisjointSet(50);
    }
    public Donador(String name,String lastName, String email, String typeDocument ,String document, String password, String adress, String locality){
        super(name,lastName,email,typeDocument,document,password); 
        this.adress = adress;
        this.locality = locality;
        this.numberDonates = 0;
    }
    
    
    //ED = Expiration Day
    /*
    public void DonateFood(String nameProduct, String type,int quantity,String emailDonor,int EDateYear, int EDateMonth, int EDateDay ){
        // se crea el producto 
        Food food = new Food(type,nameProduct,quantity,emailDonor,EDateYear,EDateMonth,EDateDay);
        HistoryOfDonations.push(food);
        // AQUI LLAMAR EL METODO AÑADIR
       
    }
    */
    
    public void donateFood(int index, String nameProduct, String type, int quantity, int EDateYear, int EDateMonth, int EDateDay) {
            // Crea el producto
            Producto product = new Producto(index, type, nameProduct, quantity, this.getEmail());

            // Agrega el producto al conjunto disjunto del donante
            int productIndex =1;
            productSet.union(productIndex, productIndex);

            // Agrega el producto a la lista de productos donados
            //donatedProducts.add(product);
        }
    public boolean DesahabilitateProduct(String nameProduct){
        // AQUI LLAMAR A BORRAR DE LA LISTA DE PRODUCTOS o lista de donacion 
        // O SIMPLEMENTE CAMBIAR EL state del producto
        return(true);
    }
    
    
    // metodos setters y getters

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Queue<Producto> getListDonations() {
        return ListDonations;
    }

    public void setListDonations(Queue<Producto> ListDonations) {
        this.ListDonations = ListDonations;
    }

    public Stack<Producto> getHistoryOfDonations() {
        return HistoryOfDonations;
    }

    public void setHistoryOfDonations(Stack<Producto> HistoryOfDonations) {
        this.HistoryOfDonations = HistoryOfDonations;
    }

    public int getNumberDonates() {
        return numberDonates;
    }

    public void setNumberDonates(int numberDonates) {
        this.numberDonates = numberDonates;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Donador donnor = (Donador) o;

        return email.equals(donnor.email); // Compara por dirección de correo electrónico u otro campo único.
    }

    public String toString() {
        return "Donnor{" + "adress=" + adress + ", locality=" + locality + ", ListDonations=" + ListDonations + ", HistoryOfDonations=" + HistoryOfDonations + ", numberDonates=" + numberDonates + '}';
    }
}
