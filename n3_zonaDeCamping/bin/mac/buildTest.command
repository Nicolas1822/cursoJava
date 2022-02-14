# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# $Id$
# Universidad de los Andes (Bogota� - Colombia)
# Departamento de Ingenieri�a de Sistemas y Computacio�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2
# Ejercicio: n3_zonaDeCamping
# Autor: Vanessa P�rez Romanello - 16-oct-2012
# Creacion de Script: Juan Sebasti�an Urrego
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# ---------------------------------------------------------
# Asegura la creaci�n de los directorios classes y lib
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd ../../test
mkdir classes
mkdir lib
# ---------------------------------------------------------
# Compila las clases del directorio test/source
# ---------------------------------------------------------
cd source
pwd
javac -classpath ../../lib/zonaDeCamping.jar:../lib/junit.jar -d ../classes/ uniandes/cupi2/zonaDeCamping/test/*.java
# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------
cd ../classes
jar cf ../lib/zonaDeCampingTest.jar uniandes/* -C ../data .
cd ../../bin