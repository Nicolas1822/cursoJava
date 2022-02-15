@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de Ibagu� (Ibagu� - Colombia)
REM Programa de Ingenier�a de Sistemas 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_alquilerChivasRumberas
REM Autor: Andr�s Mauricio Arciniegas - Agosto de 2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Asegura la creaci�n de los directorios classes y lib
REM ---------------------------------------------------------

cd ..
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directorio source
REM ---------------------------------------------------------
cd source
javac -source 1.5 -d ../classes/ unibague/cupi2/alquilerChivasRumberas/mundo/*.java
javac -source 1.5 -d ../classes/ unibague/cupi2/alquilerChivasRumberas/interfaz/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ../classes
jar cf ../lib/alquilerChivasRumberas.jar unibague/*

cd ../bin

pause
