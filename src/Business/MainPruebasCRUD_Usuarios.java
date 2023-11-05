
package Business;
import PruebasCRUD.PruebasCRUD_Usuario;

public class MainPruebasCRUD_Usuarios {

    
    public static void main(String[] args) {
        // ORDUZ CAMBIE  pathDataJson a SU RUTA
        String pathDataJson = "C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/";
        PruebasCRUD_Usuario PC = new PruebasCRUD_Usuario(10000, 0,pathDataJson );
        
        PC.ShowJson_User();
    }
    
    
}
