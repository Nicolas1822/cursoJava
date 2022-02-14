@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n3_zonaDeCamping
REM Autor: Vanessa P�rez Romanello - 16-oct-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/zonaDeCamping.jar;test/lib/junit.jar;test/lib/zonaDeCampingTest.jar junit.swingui.TestRunner uniandes.cupi2.zonaDeCamping.test.ZonaDeCampingTest
	
java -ea -classpath lib/zonaDeCamping.jar;test/lib/junit.jar;test/lib/zonaDeCampingTest.jar junit.swingui.TestRunner uniandes.cupi2.zonaDeCamping.test.CarpaTest
	
java -ea -classpath lib/zonaDeCamping.jar;test/lib/junit.jar;test/lib/zonaDeCampingTest.jar junit.swingui.TestRunner uniandes.cupi2.zonaDeCamping.test.CampistaTest
cd bin/win