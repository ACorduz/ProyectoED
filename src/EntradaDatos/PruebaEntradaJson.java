package EntradaDatos;

// librerias para la entrada de datos
import java.io.File;


public class PruebaEntradaJson {

    private String yourComputer_pathToCarpet_fileJson = null; 
    /*
    RUTA de carpeta de archivo Json
    si lo siguiente  es la ruta completa del archivo "(ruta/a/tu/carpetaJson)/nameArchivo.json", 
    entonces ingresar esto "ruta/a/tu/carpetaJson/"; OJO CON / al final*/
    
    private String name_fileJson = null;  // para crear nombre del archivoJson
    
    private String finalPath_fileJson = null; // para crear la ruta del archivo final
    
    private int NumberRowsRead; // numero de filas a leer
    
    private int TypeOfFileRead; // 
    /* este va desde 0 a 1, siendo :
    0 leer datos del json de usuarios, 
    1 leer datos del json de Productos_comida*/
    
    // Rutas de los integrantes del projecto
    public String PathJhoanComputer = "C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/";
    

    // CONSTRUCTOR
    public PruebaEntradaJson(String pathYourComputerCarpetArchivoJson, int NumberRowsRead, int TypeOfFileRead) {
        this.yourComputer_pathToCarpet_fileJson = pathYourComputerCarpetArchivoJson;
        this.NumberRowsRead = NumberRowsRead;
        this.TypeOfFileRead = TypeOfFileRead;
        
    }

    public PruebaEntradaJson( int NumberRowsRead, int TypeOfFileRead) {
        this.NumberRowsRead = NumberRowsRead;
        this.TypeOfFileRead = TypeOfFileRead;
    }
    
   
    // METODOS
    
    // colocar y construit el nombre del archivo JSON
    public void setNameOfFileJson(){
        
        String genericNameUser = "jsonFakeDataUsers_";
        String genericNameFood = "jsonFakeDataFood_";
        switch (TypeOfFileRead) {
            case 0:
                name_fileJson = genericNameUser + NumberRowsRead +".json";
                break;
            case 1:
                name_fileJson = genericNameFood + NumberRowsRead +".json";
                break;
            default:
                throw new RuntimeException("ERROR: type Of Field doesn't exist, the values are 0, 1");
        }
     }
    
    // colocar y construir la ruta final del archivo
    public void setFinalPathFile(){
        setNameOfFileJson();
        finalPath_fileJson = yourComputer_pathToCarpet_fileJson + name_fileJson;
    }
    
    
    // metodo para cambiar de tipo de archivo que se quiere leer 
    public void change_TypeOfFileRead(int i){
        TypeOfFileRead = i;
        name_fileJson = null; 
        finalPath_fileJson = null;  
    }
    
    
    /*metodo para ver si el archivoExiste, 
      A su vez se revisa si ya hay una ruta colocada al archivo o finalPath_fileJson ! null 
    */
    public boolean FileExist(){
        String filePath;
        // ver si en el cosntructor se ingreso un path
        if(finalPath_fileJson == null){
            // entonces
            setFinalPathFile();
        }
        
        filePath =  finalPath_fileJson;
        File file = new File(filePath);
        boolean exists = file.exists();
        
        if(exists){
            System.out.println("The file exists.");
            return(true);
        }else{
            System.out.println("The file does not exist.");
            return(false);
        }
    }
    

    // SETTERS Y GETTERS
    public String getYourComputer_pathToCarpet_fileJson() {
        return yourComputer_pathToCarpet_fileJson;
    }

    public void setYourComputer_pathToCarpet_fileJson(String yourComputer_pathToCarpet_fileJson) {
        this.yourComputer_pathToCarpet_fileJson = yourComputer_pathToCarpet_fileJson;
    }

    public String getName_fileJson() {
        return name_fileJson;
    }

    public void setName_fileJson(String name_fileJson) {
        this.name_fileJson = name_fileJson;
    }

    public String getFinalPath_fileJson() {
        return finalPath_fileJson;
    }

    public void setFinalPath_fileJson(String finalPath_fileJson) {
        this.finalPath_fileJson = finalPath_fileJson;
    }

    public int getNumberRowsRead() {
        return NumberRowsRead;
    }

    public void setNumberRowsRead(int NumberRowsRead) {
        this.NumberRowsRead = NumberRowsRead;
    }

    public int getTypeOfFileRead() {
        return TypeOfFileRead;
    }

    public void setTypeOfFileRead(int TypeOfFileRead) {
        this.TypeOfFileRead = TypeOfFileRead;
    }

    public String getPathJhoanComputer() {
        return PathJhoanComputer;
    }

    public void setPathJhoanComputer(String PathJhoanComputer) {
        this.PathJhoanComputer = PathJhoanComputer;
    }
    
    
        
    
}
