Équipe:
    1. Emily Bazile-Supplice ()
    2. Eed Flory Jean-Baptiste (20168335)

Lien du repositioire -> https://github.com/emilybazilesupplice/TP1---IFT3913


Instruction pour compiler et executer:
Assurez-vous d'avoir Java JDK 17.0.5 ou plus installé sur votre ordinateur ( l'utilisation de javac)
Tous les chemins doivent utiliser les fichiers du dossier "src" et non le dossier "out".

Compilez avant chaque execution via le terminal :

1- Compiler : javac tassert.java
Executer --> java tassert <chemin-au-fichier-de-test> ou
--> java -jar <chemin-à-tassert.jar> <chemin-du-fichier-de-test->

2- Compiler: javac tloc.java
Executer-->java tloc <chemin-au-fichier-de-test> ou 
-->java -jar <chemin-à-tloc.jar> <chemin-du-fichier-de-test->

3- Compiler: javac tls.java
--->remplacer "java -jar <chemin-au-fichier.jar>" par les chemins respectifs des fichiers.jar dans les methodes tloc et tassert :
String command = "java -jar <chemin-à-tloc.jar>" 
String command = "java -jar <chemin-à-tassert.jar>"

Executer->java tls <chemin-au-dossier-contenant-les-fichiers-de-test>
ou ---> java -jar <chemin-à-tls.jar> <chemin-du-dossier-de-fichier-de-test->

4- Compiler: javac tropcomp.java
Si on veut visionner les resultats dans le terminal
Executer--> java tropcomp <chemin-au-dossier-contenant-les-fichiers-de-test seuil>
ou --> java -jar <chemin-à-tropcomp.jar> <chemin-du-dossier-de-fichier-de-test->
Si on veut generer des fichiers csv
Executer--> java tropcomp -o <chemin-à-la-sortie.csv> <chemin-de-l'entrée> <seuil>.
