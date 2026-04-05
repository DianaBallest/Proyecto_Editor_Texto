package mis_propiedades;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


//@author diana

public class ClassArchivoPropiedades {
    public Properties LeerPropiedades() {
        Properties config = new Properties();
        InputStream configInput;
        try {
            // Busca el archivo en la raíz del proyecto
            configInput = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            config.load(configInput);
            configInput.close();
            return (config);
        } catch (Exception e) {
            return (null);
        }
    }

    public boolean EscribirPropiedades(Properties propiedades) {
        OutputStream configOutput;
        try {
            configOutput = new FileOutputStream(System.getProperty("user.dir") + "/config.properties");
            // El segundo parámetro es un comentario que aparece al inicio del archivo
            propiedades.store(configOutput, "<------ Archivo de Configuraciones ------>");
            configOutput.close();
            return (true);
        } catch (Exception e) {
            return (false);
        }
    }
}
