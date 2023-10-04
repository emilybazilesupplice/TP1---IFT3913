import java.io.*;
import java.util.*;

public class tropcomp {
    public static void main(String[] args) {
        // Vérification des arguments en entrée
        if (args.length < 2) {
            System.out.println("Veuillez fournir le chemin du projet et le seuil.");
            return;
        }
        String cheminDuProjet = args[0];
        double seuil = Double.parseDouble(args[1]);

        File dossier = new File(cheminDuProjet);
        if (!dossier.isDirectory()) {
            System.out.println("Le chemin fourni n'est pas un dossier.");
            return;
        }

        // Extraction des classes et de leurs métrique
        List<ClasseTest> classes = extraireClasses(dossier, dossier.getAbsolutePath());

        // On trie les classes par leur valeur TCMP en ordre décroissant
        Collections.sort(classes, Comparator.comparingDouble(ClasseTest::getTcmp).reversed());

        int nombreClassesASuggerer = (int) Math.ceil(classes.size() * seuil / 100); // Calcul du nombre de classes à
                                                                                    // suggérer basé sur le seuil. on le
                                                                                    // veut en pourcentage
        for (int i = 0; i < nombreClassesASuggerer; i++) {// Affichage des classes
            ClasseTest classe = classes.get(i);
            System.out.printf("%s, %s, %s, %d, %d, %.2f%n", classe.cheminFichier, classe.nomPaquet, classe.nomClasse,
                    classe.tloc, classe.tassert, classe.tcmp);
        }
    }

    // Extraction des informations des classes dans le dossier
    private static List<ClasseTest> extraireClasses(File dossier, String cheminRacine) {
        List<ClasseTest> classes = new ArrayList<>();
        for (File fichier : dossier.listFiles()) {
            /// Si c'est un sous-dossiert
            if (fichier.isDirectory()) {
                classes.addAll(extraireClasses(fichier, cheminRacine));

                // Si c'est un fichier Java, on extrait ses métriques
            } else if (fichier.getName().endsWith(".java")) {
                try {
                    ClasseTest classe = new ClasseTest();
                    classe.cheminFichier = "./" + fichier.getAbsolutePath().substring(cheminRacine.length())
                            .replace(File.separatorChar, '/');
                    classe.nomPaquet = tls.extraireNomPaquet(fichier);
                    classe.nomClasse = fichier.getName().replace(".java", "");
                    classe.tloc = tls.tloc(fichier);
                    classe.tassert = tls.tassert(fichier);
                    if (classe.tassert != 0) { // On veut exclure les classes dont l'analyse n'en vaut pas la peine
                                               // (tassert =0)
                        classe.tcmp = (double) classe.tloc / classe.tassert;
                        classes.add(classe);
                    }
                } catch (Exception e) {
                    System.out.println("Erreur lors de la lecture du fichier: " + fichier.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }

    /// Classe test avec ses métriques
    private static class ClasseTest {
        String cheminFichier;
        String nomPaquet;
        String nomClasse;
        int tloc;
        int tassert;
        double tcmp;

        double getTcmp() {
            return tcmp;
        }
    }
}
