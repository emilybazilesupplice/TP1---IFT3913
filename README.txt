Équipe:
    1. Emily Bazile-Supplice ()
    2. Eed Flory Jean-Baptiste (20168335)

Lien du repositioire ->

Instruction pour compiler et executer:

Compilez avant chaque execution :

1- Compiler : javac tassert.java
Executer --> java tassert <chemin-au-fichier-de-test>

2- Compiler: javac tloc.java
Executer-->java tloc <chemin-au-fichier-de-test>

3- Compiler: javac tls.java
--->remplacer "java -jar <chemin-au-fichier.jar>" par les chemins respectifs des fichiers.jar dans les methodes tloc et tassert :
String command = "java -jar <chemin-à-tloc.jar>" 
String command = "java -jar <chemin-à-tassert.jar>"

Executer->java tls <chemin-au-dossier-contenant-les-fichiers-de-test>

4- Compiler: javac tropcomp.java
Executer--> java tropcomp <chemin-au-dossier-contenant-les-fichiers-de-test seuil>
Si on veut generer des fichiers 
Executer--> java tropcomp -o <chemin-à-la-sortie.csv> <chemin-de-l'entrée> <seuil>.
