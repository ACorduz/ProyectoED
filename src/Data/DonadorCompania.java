
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import java.io.Serializable;


public class DonadorCompania implements Serializable{
    private String typeCompany; // las compañias pueden ser de ropa, comida
    private String name;
    private String NIT;
    private String adress;
    private String locality;
    private String password;
    private String email;
    
    // esta clase esta por si se quiere poner mas funciones al Donador de la compañia;

    public DonadorCompania(String name,String NIT ,String adress,String locality,String typeCompany, String email, String password ) {
        this.name=name;
        this.NIT=NIT;
        this.adress=adress;
        this.locality=locality;
        this.typeCompany = typeCompany;
        this.password=password;
        this.email=email;
        
    }

    public String getTypeCompany() {
        return typeCompany;
    }

    public void setTypeCompany(String typeCompany) {
        this.typeCompany = typeCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
}
