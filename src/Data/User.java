
package Data;


public class User {
    // la clase usuario es una superclase de las empresas donadores, y beneficiarios
    //Primero los atributos
    private String names; 
    private String lastNames;
    private String email;
    private String document;
    private String password;
    private String TypeUser;

    public User(String names, String lastNames, String email, String document, String password, String TypeUser) {
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
        this.document = document;
        this.password = password;
        this.TypeUser = TypeUser;
    }

    
    
    // metodos setter y getters
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
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
        return "User{" + "names=" + names + ", lastNames=" + lastNames + ", email=" + email + ", document=" + document + ", password=" + password + ", TypeUser=" + TypeUser + '}';
    }
    
    
}
