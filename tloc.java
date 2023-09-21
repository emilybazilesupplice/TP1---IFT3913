import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tloc {

    public static void main(String[] args) throws IOException {
        // aller chercher le fichier à lire
        String file = args[0];
        BufferedReader read = new BufferedReader(new FileReader(file));
        
        String ligne;
        int n = 0;
        while((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // Vérifier que la ligne n'est pas vide
            if (ligne.isEmpty()){
                continue;
            }
            
            // Vérifie qu'il n'y a pas de commentaire
            if (ligne.startsWith("//")){
                continue;
            }

            // On augmente le compte
            n = n + 1;
        }
        
        read.close();

    }
}
