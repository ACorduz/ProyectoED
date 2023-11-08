
package Data;

import java.io.Serializable;


public class Usuario implements Serializable{
    // la clase usuario es una superclase de las empresas donadores, y beneficiarios
    //Primero los atributos
    private String firs_name;
    private String last_name;
    protected String email;
    private String document;
    private String numberDocument; 
    private String password;
    private String adress;
    private String locality;
    
    public Usuario(String name,String lastName, String email,  String typeDocument, String document, String password, String adress, String locality) {
        this.firs_name = name; 
        this.last_name = lastName;
        this.email = email;
        this.document = typeDocument;
        this.numberDocument = document;
        this.document = document;
        this.password = password;
        this.adress = adress;
        this.locality = locality;
    }

    
    // metodos setter y getters
    public String getName() {
        return firs_name;
    }

    public void setName(String name) {
        this.firs_name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeDocument() {
        return document;
    }

    public void setTypeDocument(String typeDocument) {
        this.document = typeDocument;
    }
    
    public String getDocument() {
        return numberDocument;
    }

    public void setDocument(String document) {
        this.numberDocument = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    

    @Override
    public String toString() {
        return "User{" + "name=" + firs_name+ ", email=" + email + ", document=" + numberDocument +", " + "typeDocument"+ document + ", password=" + password + "}";
    }
    
    
}
