
package Data;

import java.io.Serializable;


public class User implements Serializable{
    // la clase usuario es una superclase de las empresas donadores, y beneficiarios
    //Primero los atributos
    private String name;
    private String lastName;
    public String email;
    private String document;
    private String password;
    private String TypeUser;
    // los tipos de usuarios podrian ser los siguientes; 
    // "Donador", "Beneficiario"
    
    
    public User(String name,String lastName, String email, String document, String password, String TypeUser) {
        this.name = name; 
        this.email = email;
        this.lastName = lastName; 
        this.document = document;
        this.password = password;
        this.TypeUser = TypeUser;
    }

    
    // metodos setter y getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name+ ", email=" + email + ", document=" + document + ", password=" + password + ", TypeUser=" + TypeUser + '}';
    }
    
    
}
