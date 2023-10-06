import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tloc {
    /*
     * Cette fonction va compter le nombre de ligne qui ne sont ni des lignes vides,
     * ni des commentaires
     */

    public static void main(String[] args) throws IOException {
        // aller chercher le fichier à lire
        String file = args[0];
        BufferedReader read = new BufferedReader(new FileReader(file));

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
                if (ligne.contains("*/")) {
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
}