<<<<<<< HEAD
=======
package main.tassert;
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class tassert {
<<<<<<< HEAD
    /*
     * Cette fonction va calculer le nombre des assertions JUnit dans une classe de
     * test Java
     */

=======
    /* Cette fonction va calculer le nombre des assertions JUnit dans une classe de test Java */
    
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
    public static void main(String[] args) throws IOException {

        // Liste de tous les types d'assert
        ArrayList<String> typeAssert = new ArrayList<String>();
        typeAssert.add("assertTrue(");
        typeAssert.add("assertFalse(");
        typeAssert.add("fail(");
        typeAssert.add("assertEquals(");
        typeAssert.add("assertNotEquals(");
        typeAssert.add("assertArrayEquals(");
        typeAssert.add("assertNotNull(");
        typeAssert.add("assertNull(");
        typeAssert.add("assertSame(");
        typeAssert.add("assertNotSame(");
        typeAssert.add("assertThat(");
        typeAssert.add("assertThrows(");

        // aller chercher le fichier à lire
        String file = args[0];
        BufferedReader read = new BufferedReader(new FileReader(file));
<<<<<<< HEAD

=======
        
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
        String ligne;
        int n = 0;
        boolean commentBlock = false;

<<<<<<< HEAD
        while ((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // Vérifie si la ligne est un commentaire
            if (ligne.startsWith("//")) {
=======
        while((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

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

            // vérifie pour chaque instruction si un assert est présent
            String[] instructions = ligne.split(";");
            for (String instruction : instructions) {
                for (String assert_check : typeAssert) {
<<<<<<< HEAD
                    if (instruction.contains(assert_check)) {
=======
                    if (instruction.contains(assert_check)){
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
                        n++;
                    }
                }
            }
        }

        read.close();
        System.out.println(n);

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
