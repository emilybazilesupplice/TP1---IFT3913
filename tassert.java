import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class tassert {
    /* Cette fonction va calculer le nombre des assertions JUnit dans une classe de test Java */
    
    public static void main(String[] args) throws IOException {

        // Liste de toutes les types d'assert 
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
        while((ligne = read.readLine()) != null) {
            ligne = ligne.trim();

            // vérifie si la ligne contient un assert
            for (String assert_check : typeAssert) {
                if (ligne.contains(assert_check)){
                    n++;
                }
            }
        }

        read.close();
        System.out.println(n);

    }
}
