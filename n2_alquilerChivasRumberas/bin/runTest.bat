@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de Ibague (Ibagué - Colombia)
REM Programa de Ingeniería de Sistemas 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_alquilerChivasRumberas
REM Autor: Andrés Mauricio Arciniegas - Agosto de 2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

java -ea -classpath ../lib/alquilerChivasRumberas.jar;../test/lib/alquilerChivasRumberasTest.jar;../test/lib/junit.jar junit.swingui.TestRunner unibague.cupi2.alquilerChivasRumberas.test.EmpresaTest

java -ea -classpath ../lib/alquilerChivasRumberas.jar;../test/lib/alquilerChivasRumberasTest.jar;../test/lib/junit.jar junit.swingui.TestRunner unibague.cupi2.alquilerChivasRumberas.test.ChivaRumberaTest