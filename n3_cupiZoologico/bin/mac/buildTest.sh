#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot? - Colombia)
# Departamento de Ingenier?a de Sistemas y Computaci?n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_parqueEmpresarial
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
stty -echo

# ---------------------------------------------------------
# Asegura la creaci?n de los directorios classes y lib en test
# ---------------------------------------------------------

cd ../../test
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directorio test/source
# ---------------------------------------------------------

cd source
javac -nowarn -classpath ../../lib/cupiZoologico.jar;../lib/junit.jar -d ../classes/ uniandes/cupi2/cupiZoologico/test/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes

jar cf ../lib/cupiZoologicoTest.jar uniandes/* -C ../data .

cd ../../bin

stty echo