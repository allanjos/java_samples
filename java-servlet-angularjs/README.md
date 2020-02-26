# Java Samples

## Servlet, AngularJS

### Build

    mvn clean install

### Deploy

    sh ../scripts/tomcat-deploy-app-restart.sh TOMCAT_DIR java-servlet target/java-servlet.war

Where **TOMCAT_DIR** is the directory of Tomcat installation.
