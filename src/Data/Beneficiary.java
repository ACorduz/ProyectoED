package Data;

import java.io.Serializable;


public class Beneficiary extends User implements Serializable{
    // esta es la clase beneficiario, clase hija de usuario 
    
    // sus atributos 
    int NumberProductSelect;// para ver cuantos productos ha seleccionado ese usuario 
    int QuantityAllow; // cual es la cantidad que puede coger ese usuario; 
    int NumberProductsSelectAllow;
    
    // constructor

    public Beneficiary(int NumberProductSelect, int QuantityAllow, String name,String lastName, String email, String document, String password) {
        super(name, lastName ,email, document, password, "Beneficiario");
        NumberProductSelect=0;
        this.QuantityAllow = QuantityAllow;
    }
    
    
    public boolean selectProduct(String nameProduct, String emailDonor,int Quantity){
        //Aqui se va a seleccionar el producto que busca el usuario dandole el nombre y algo mas
        //Aqui buscar el producto cambiar las cantidades
        // Si se terminaron las cantidades, cambiar el estado.
        
        return(true);
    }
    
    // metodos setter y getters

    public int getNumberProductSelect() {
        return NumberProductSelect;
    }

    public void setNumberProductSelect(int NumberProductSelect) {
        this.NumberProductSelect = NumberProductSelect;
    }

    public int getQuantityAllow() {
        return QuantityAllow;
    }

    public void setQuantityAllow(int QuantityAllow) {
        this.QuantityAllow = QuantityAllow;
    }

    public int getNumberProductsSelectAllow() {
        return NumberProductsSelectAllow;
    }

    public void setNumberProductsSelectAllow(int NumberProductsSelectAllow) {
        this.NumberProductsSelectAllow = NumberProductsSelectAllow;
    }
    

    @Override
    public String toString() {
        return "Beneficiary{" + "NumberProductSelect=" + NumberProductSelect + ", QuantityAllow=" + QuantityAllow + ", NumberProductsSelectAllow=" + NumberProductsSelectAllow + '}';
    }
 
    
    
}
