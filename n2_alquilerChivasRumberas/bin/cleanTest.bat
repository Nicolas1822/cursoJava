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

cd ../test
del classes\* /s /q 
del lib\alquilerChivasRumberasTest.jar /s /q 

cd ../bin
