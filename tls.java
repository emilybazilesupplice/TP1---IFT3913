import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tls {// on peut utiliser Process et Runtime.getRuntime. Source:
                  // https://stackoverflow.com/questions/1320476/execute-another-jar-in-a-java-program/40544510#40544510
                  // et Manifest: https://www.developer.com/java/java-jar-manifest-file/
    public static void main(String[] args) {
        // test pour verifier si on a un fichier et un chemin d'acces comme arguments
        // if (args.length > 0) {// verification qu'un dossier a bien été entré
        // String chemin = args[0];
        // System.out.println("Chemin d'accès du dossier: " + chemin);
        // } else {
        // System.out.println("Veuillez fournir un chemin d'accès en tant
        // qu'argument.");
        // }

        // }
        // Vérifie si un chemin a été fourni en argument.
        if (args.length != 1) {
            System.out.println("Veuillez fournir le chemin d'accès du dossier comme argument.");
            return;
        }

        File dossier = new File(args[0]);
        // Vérifie si le chemin fourni est un dossier.
        if (!dossier.isDirectory()) {
            System.out.println("Le chemin fourni n'est pas un dossier.");
            return;
        }

        // Traite le dossier en entrée.
        processDossier(dossier, dossier.getAbsolutePath());
    }

    /**
     * Traitement d'un dossier, en appelant récursivement cette méthode pour
     * chaque sous-dossier et en traitant chaque fichier.
     * 
     * @param dossier      Le dossier à traiter.
     * @param cheminRacine Le chemin d'accès du dossier racine (initial).
     */
    public static void processDossier(File dossier, String cheminRacine) {
        for (File fichier : dossier.listFiles()) {
            // Si c'est un sous-dossier, on le traite récursivement.
            if (fichier.isDirectory()) {
                processDossier(fichier, cheminRacine);
            }
            // Si c'est un fichier ( par exemple : TitleTest.java ), on le traite
            else if (fichier.getName().endsWith(".java")) {
                processFile(fichier, cheminRacine);
            }
        }
    }

    /**
     * Traitement d'un fichier et imprime les résultats.
     * 
     * @param fichier      Le fichier à traiter.
     * @param cheminRacine Le chemin d'accès du dossier racine (initial).
     */
    public static void processFile(File fichier, String cheminRacine) {
        try {
            // Calcule les différentes métriques demandées en faisant le process de tloc et
            // tassert.
            int loc = tloc(fichier);
            int compteurAssert = tassert(fichier);
            double tcmp = (double) loc / compteurAssert; // retourne Infinity qu'on peut considerer comme 0

            // Récupère les informations sur le fichier et le paquet.
            String cheminFichier = "./"
                    + fichier.getAbsolutePath().substring(cheminRacine.length()).replace(File.separatorChar, '/');
            String nomPaquet = extraireNomPaquet(fichier);
            String nomClasse = fichier.getName().replace(".java", "");

            // Affiche les résultats.
            System.out.printf("%s, %s, %s, %d, %d, %.2f%n", cheminFichier, nomPaquet, nomClasse, loc, compteurAssert,
                    tcmp);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erreur lors de la lecture du fichier: " + fichier.getAbsolutePath());
            e.printStackTrace();
        }
    }

    // Extraction du nom de paquet si présent
    static String extraireNomPaquet(File fichier) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("package ")) {
                    return line.split(" ")[1].replace(";", "").trim();
                }
            }
        }
        return ""; // Retourne une chaîne vide si aucun package n'est trouvé.
    }

    // Compte le nombre total de lignes dans un fichier.
    public static int tloc(File fichier) throws IOException, InterruptedException {
        String command = "java -jar chemin\\menant\\au\\tloc.jar "
                + fichier.getAbsolutePath();
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = reader.readLine();
            if (line != null) {
                // return Integer.parseInt(line.trim());
                String[] parts = line.split(":");
                if (parts.length > 1) {
                    return Integer.parseInt(parts[1].trim());
                }
            }
        }

        return 0;
    }

    // Compte le nombre d'assertions dans un fichier de test.
    public static int tassert(File fichier) throws IOException, InterruptedException {
        String command = "java -jar chemin\\\\menant\\\\au\\tassert.jar "
                + fichier.getAbsolutePath();
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        }

        return 0;
    }
}