# Java Samples

## Spring Web

### Build

    mvn clean install

### Execution

Deploy app in Tomcat:

    sh ../scripts/tomcat-deploy-app-restart.sh TOMCAT_DIR springweb target/springweb.war

Where **TOMCAT_DIR** is the path to Tomcat installation directory.