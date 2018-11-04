@ECHO OFF

SET TOMCAT_DIR=C:\Allann\packages\devel\java\apache-tomcat-9.0.7

javac -cp %TOMCAT_DIR%\lib\servlet-api.jar WEB-INF\classes\br\com\olivum\servlet\TestServlet.java