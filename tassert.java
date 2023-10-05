import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class tassert {
    /* Cette fonction va calculer le nombre des assertions JUnit dans une classe de test Java */
    
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
        
        String ligne;
        int n = 0;
        boolean commentBlock = false;

        while((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // Vérifie si la ligne est un commentaire
            if (ligne.startsWith("//")){
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
                if (ligne.contains("*/")){
                    continue;
                }
                commentBlock = true;
                continue;
            }

            // vérifie pour chaque instruction si un assert est présent
            String[] instructions = ligne.split(";");
            for (String instruction : instructions) {
                for (String assert_check : typeAssert) {
                    if (instruction.contains(assert_check)){
                        n++;
                    }
                }
            }
        }

        read.close();
        System.out.println(n);

    }
}
