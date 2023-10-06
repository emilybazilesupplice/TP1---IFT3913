import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tloc {
<<<<<<< HEAD
    /*
     * Cette fonction va compter le nombre de ligne qui ne sont ni des lignes vides,
     * ni des commentaires
     */
=======
    /* Cette fonction va compter le nombre de ligne qui ne sont ni des lignes vides, ni des commentaires */
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f

    public static void main(String[] args) throws IOException {
        // aller chercher le fichier à lire
        String file = args[0];
        BufferedReader read = new BufferedReader(new FileReader(file));
<<<<<<< HEAD

        String ligne;
        int n = 0;
        boolean commentBlock = false;
        while ((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // Vérifie si la ligne est vice
            if (ligne.isEmpty()) {
                continue;
            }

            // Vérifie si la ligne est un commentaire
            if (ligne.startsWith("//")) {
=======
        
        String ligne;
        int n = 0;
        boolean commentBlock = false;
        while((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // Vérifie si la ligne est vice
            if (ligne.isEmpty()){
                continue;
            }
            
            // Vérifie si la ligne est un commentaire
            if (ligne.startsWith("//")){
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
                continue;
            }

            // Vérifie si la ligne est un bloc de commentaire
            if (commentBlock) {
                if (ligne.contains("*/")) {
                    commentBlock = false;
                }
                continue;
            }
            if (ligne.startsWith("/*")) {
<<<<<<< HEAD
                if (ligne.contains("*/")) {
=======
                if (ligne.contains("*/")){
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
                    continue;
                }
                commentBlock = true;
                continue;
            }

            // On augmente le compte
            n = n + 1;
        }

        read.close();
        System.out.println(n);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
