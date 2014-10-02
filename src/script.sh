#!/bin/sh
# Yann Gayral & Tristan Le Labousse
# FIP 2A	UV SIT 213
# Pour fonctionner correctement, le script doit être lancé depuis le répertoire src
javac -encoding ISO-8859-1 *.java
java Simulateur $*


