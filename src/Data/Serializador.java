
package Data;

/**
 *
 * @author die_a
 */
import java.io.*;
import Estructure_LinkedList.LinkedList;

public class Serializador {
    public static <T> void serializarObjeto(T objeto, String nombreArchivo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objeto);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserializarObjeto(String nombreArchivo) {
        T objeto=null;
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objeto = (T) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
    }
}

