
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
    private int expirationDateYear;
    private int expirationDateMonth;
    private int expirationDateDay;
    

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

    public Producto( String typeProduct, String nameProduct, int quantity, String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay) {       
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.emailDonor = emailDonor;
        this.expirationDateYear = expirationDateYear;
        this.expirationDateMonth = expirationDateMonth;
        this.expirationDateDay = expirationDateDay;     
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
    
    public String getExpirationDate() {
        String year = String.valueOf(expirationDateYear);
        String month = String.format("%02d", expirationDateMonth); // Asegura que el mes tenga dos dígitos (por ejemplo, 03 en lugar de 3).
        String day = String.format("%02d", expirationDateDay); // Asegura que el día tenga dos dígitos (por ejemplo, 09 en lugar de 9).
        return year + "-" + month + "-" + day;
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
            "\n  Tipo: " + typeProduct +
            "\n  Nombre: " + nameProduct +
            "\n  Fecha Vencimeinto: " + getExpirationDate() +
            "\n  Cantidad: " + quantity +
            "\n  Email Donor: " + emailDonor +
            "\n}";
}
    
    
}
