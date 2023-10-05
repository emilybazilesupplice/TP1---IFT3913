Équipe:
    1. Emily Bazile-Supplice ()
    2. Eed Flory Jean-Baptiste (20168335)

Lien du repositioire ->

Instruction pour compiler:

Compilez avant chaque utilisation :

1- Compiler : javac tassert.java
Execution --> java tassert chemin/du/fichier/de/test

2- Compiler: javac tloc.java
Execution-->java tloc chemin/du/fichier/de/test

3- Compiler: javac tls.java
--->remplacer "java -jar chemin\\menant\\au\\fichier.jar" par les chemins respectifs des fichiers.jar dans les methodes tloc et tassert :
String command = "java -jar chemin\\menant\\au\\tloc.jar" 
String command = "java -jar chemin\\menant\\au\\tassert.jar"

Execution->java tls chemin/du/dossier/contenant/les/fichiers/de/test

4- Compiler: javac tropcomp.java
Execution--> java tropcomp chemin/du/dossier/contenant/les/fichiers/de/test seuil

