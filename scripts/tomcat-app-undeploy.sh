#!/bin/bash

echo ""
echo "Undeploy application from running Apache Tomcat"
echo "-----------------------------------------------"
echo ""

help()
{
    echo ""
    echo "Usage:"
    echo "$0 <WAR CONTEXT> <TOMCAT USER> <TOMCAT PASSWORD>"
    echo ""
    echo "<TOMCAT USER>: User with manager script access."
    echo "<TOMCAT PASSWORD>: Password of the user with manager script access."
    echo "<WAR CONTEXT>: Context path of application. Generally the folder name "
    echo "<WAR CONTEXT>: Context path of application. Generally the folder name "
    echo "               of the application inside webapps directory."
    echo ""
}

if [ "$1" = "" ] || [ "$1" = "--help" ]; then
    help
    exit 0
fi

if [ "$2" = "" ] || [ "$2" = "--help" ]; then
    help
    exit 0
fi

if [ "$3" = "" ] || [ "$3" = "--help" ]; then
    help
    exit 0
fi

TOMCAT_USER=tomcat
TOMCAT_PASSWORD=s3cret
TOMCAT_URL=http://localhost:8080
CONTEXT_PATH=/$1

echo "CONTEXT_PATH: $CONTEXT_PATH"

 curl -v -u $TOMCAT_USER:$TOMCAT_PASSWORD "$TOMCAT_URL/manager/text/undeploy?path=$CONTEXT_PATH&update=true"
