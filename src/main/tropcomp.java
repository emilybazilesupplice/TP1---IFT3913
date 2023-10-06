<<<<<<< HEAD
=======
package main;

>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
import java.io.*;
import java.util.*;

public class tropcomp {
    public static void main(String[] args) {
        // Vérification des arguments en entrée
        if (args.length < 2) {
            System.out.println("Veuillez fournir le chemin du projet et le seuil.");
            return;
        }
<<<<<<< HEAD
        String cheminSortie = null;
        String cheminDuProjet;
        double seuil;

        if (args[0].equals("-o")) {// Choix d'écrire dans un fichier CSV ou générer une sortie de format tls.java
            cheminSortie = args[1];
            cheminDuProjet = args[2];
            seuil = Double.parseDouble(args[3]);
        } else {
            cheminDuProjet = args[0];
            seuil = Double.parseDouble(args[1]);
        }
=======
        String cheminDuProjet = args[0];
        double seuil = Double.parseDouble(args[1]);
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f

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
<<<<<<< HEAD

        if (cheminSortie != null) {
            try (PrintWriter writer = new PrintWriter(new File(cheminSortie))) {
                for (int i = 0; i < nombreClassesASuggerer; i++) {
                    ClasseTest classe = classes.get(i);
                    writer.printf("%s, %s, %s, %d, %d, %.2f%n",
                            classe.cheminFichier, classe.nomPaquet, classe.nomClasse,
                            classe.tloc, classe.tassert, classe.tcmp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            for (int i = 0; i < nombreClassesASuggerer; i++) {
                ClasseTest classe = classes.get(i);
                System.out.printf("%s, %s, %s, %d, %d, %.2f%n",
                        classe.cheminFichier, classe.nomPaquet, classe.nomClasse,
                        classe.tloc, classe.tassert, classe.tcmp);
            }
=======
        for (int i = 0; i < nombreClassesASuggerer; i++) {// Affichage des classes
            ClasseTest classe = classes.get(i);
            System.out.printf("%s, %s, %s, %d, %d, %.2f%n", classe.cheminFichier, classe.nomPaquet, classe.nomClasse,
                    classe.tloc, classe.tassert, classe.tcmp);
>>>>>>> bfb4ad49316995858e957fb5d4a3b2cf4dbc9f2f
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
