package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;




public class Donnor extends User {
    // la clase donador es hijo de la clase usurio y a la vez superclase
    private String adress;
    private String locality;
    private Queue<Product> ListDonations;
    private Stack<Product> HistoryOfDonations; 
    private int numberDonates;
    // OJO typeOfUserNosDice Si es DonadorCompañia, donadorOcasional O Beneficiario
    
    // metodos constructores

    public Donnor(String names, String lastNames, String email, String document, String password, String TypeUser, String adress, String locality, Queue<Product> ListDonations, Stack<Product> HistoryOfDonations) {
        super(names,lastNames,email,document,password,TypeUser);
        this.adress = adress;
        this.locality = locality;
        this.ListDonations = ListDonations;
        this.HistoryOfDonations = HistoryOfDonations;
        this.numberDonates = 0;
    }
    
    
    
    //ED = Expiration Day
    public void DonateFood(String nameProduct, String type,int quantity,String emailDonor,int EDateYear, int EDateMonth, int EDateDay ){
        // se crea el producto 
        Food food = new Food(type,nameProduct,quantity,emailDonor,EDateYear,EDateMonth,EDateDay);
        HistoryOfDonations.push(food);
        // AQUI LLAMAR EL METODO AÑADIR
       
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

    public Queue<Product> getListDonations() {
        return ListDonations;
    }

    public void setListDonations(Queue<Product> ListDonations) {
        this.ListDonations = ListDonations;
    }

    public Stack<Product> getHistoryOfDonations() {
        return HistoryOfDonations;
    }

    public void setHistoryOfDonations(Stack<Product> HistoryOfDonations) {
        this.HistoryOfDonations = HistoryOfDonations;
    }

    public int getNumberDonates() {
        return numberDonates;
    }

    public void setNumberDonates(int numberDonates) {
        this.numberDonates = numberDonates;
    }

    @Override
    public String toString() {
        return "Donnor{" + "adress=" + adress + ", locality=" + locality + ", ListDonations=" + ListDonations + ", HistoryOfDonations=" + HistoryOfDonations + ", numberDonates=" + numberDonates + '}';
    }
    
    
}
