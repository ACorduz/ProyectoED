
package Data;

import java.io.Serializable;

public class Product implements Serializable {
    //  Es la superclase
    
    // metodos constructores
    public Product( String typeProduct,String nameProduct, int quantity, String emailDonor){
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        // luego el estado va a ser verdadero
        this.estate = true;
        this.quantity = quantity;
        this.emailDonor = emailDonor;
    }
    


    public Product(String typeProduct, String nameProduct, boolean estate, int quantity, String emailDonor) {
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        this.estate = estate;
        this.quantity = quantity;
        this.emailDonor = emailDonor;
    }
       
    
    // atributos
    private String typeProduct;
    private String nameProduct;
    private boolean estate;// el estado se refiere a si ya lo eligieron o no
    private int quantity;
    private String emailDonor; // el imail para luego saber quien publico este producto

    public Product() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // metodos setters y getters
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

    @Override
    public String toString() {
        return "Product{" + "typeProduct=" + typeProduct + ", nameProduct=" + nameProduct + ", estate=" + estate + ", quantity=" + quantity + ", emailDonor=" + emailDonor + '}';
    }
    
    
}
