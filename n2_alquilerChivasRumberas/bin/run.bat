@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de Ibague (Ibagu� - Colombia)
REM Programa de Ingenier�a de Sistemas 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_alquilerChivasRumberas
REM Autor: Andr�s Mauricio Arciniegas - Agosto de 2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion del programa
REM ---------------------------------------------------------

cd..
java -ea -classpath ./lib/alquilerChivasRumberas.jar unibague.cupi2.alquilerChivasRumberas.interfaz.InterfazAlquilerChivasRumberas
cd bin