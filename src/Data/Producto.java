
package Data;

import java.io.Serializable;

public class Producto implements Serializable {
    //  Es la superclase
 
    // ATRIBUTOS
    private int index; 
    private String typeProduct;
    private String nameProduct;
    private boolean estate;// el estado se refiere a si ya lo eligieron o no
    private int quantity;
    private String emailDonor; // el imail para luego saber quien publico este producto

    // COSNTRUCTORES
    public Producto(int index, String typeProduct,String nameProduct, int quantity, String emailDonor){
        this.index = index;
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        // luego el estado va a ser verdadero
        this.estate = true;
        this.quantity = quantity;
        this.emailDonor = emailDonor;
    }
    

     // luego el estado se va a elegir
    public Producto(int index, String typeProduct, String nameProduct, boolean estate, int quantity, String emailDonor) {
        this.index = index;
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        this.estate = estate;
        this.quantity = quantity;
        this.emailDonor = emailDonor;
    }
      
    public Producto() {
        
    }

    // METODOS SET, GET 
    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    
    public boolean getIsEstate() {
        return estate;
    }

    public void setEstate(boolean estate) {
        this.estate = estate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEmailDonor() {
        return emailDonor;
    }

    public void setEmailDonor(String emailDonor) {
        this.emailDonor = emailDonor;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
    return "Product{" +
            "\n  Type: " + typeProduct +
            "\n  Name: " + nameProduct +
            "\n  Estate: " + estate +
            "\n  Quantity: " + quantity +
            "\n  Email Donor: " + emailDonor +
            "\n}";
}
    
    
}
