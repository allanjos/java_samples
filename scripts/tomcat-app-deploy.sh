#!/bin/bash

echo ""
echo "Deploy application in running Apache Tomcat"
echo "-------------------------------------------"
echo ""

help()
{
    echo ""
    echo "Usage:"
    echo "$0 <WAR FILE PATH> <CONTEXT PATH> <TOMCAT USER> <TOMCAT PASSWORD>"
    echo ""
    echo "<WAR FILE PATH>: Path to WAR application file."
    echo "<CONTEXT PATH>: Context path of application. Generally the folder name "
    echo "               of the application inside webapps directory."
    echo "<TOMCAT USER>: User with manager script access."
    echo "<TOMCAT PASSWORD>: Password of the user with manager script access."
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

if [ "$4" = "" ] || [ "$4" = "--help" ]; then
    help
    exit 0
fi

APP_WAR_FILE=$1
CONTEXT_PATH=/$2
TOMCAT_USER=$3
TOMCAT_PASSWORD=$4
TOMCAT_URL=http://localhost:8080

echo "APP_WAR_FILE: $APP_WAR_FILE"
echo "CONTEXT_PATH: $CONTEXT_PATH"
echo "TOMCAT_USER: $TOMCAT_USER"
echo "TOMCAT_PASSWORD: $TOMCAT_PASSWORD"

curl -v -u $TOMCAT_USER:$TOMCAT_PASSWORD -X PUT -T $APP_WAR_FILE "$TOMCAT_URL/manager/text/deploy?path=$CONTEXT_PATH&update=true"
