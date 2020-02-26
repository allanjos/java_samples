#!/bin/bash

echo ""
echo "Deploy application in running Apache Tomcat with full Tomcat restart"
echo "--------------------------------------------------------------------"
echo ""

help()
{
    echo ""
    echo "Usage:"
    echo "$0 <APACHE TOMCAT DIRECTORY> <CONTEXT_PATH> <WAR FILE PATH>"
    echo ""
    echo "<APACHE TOMCAT DIRECTORY>: Directory of Apache Tomcat distribution."
    echo "<CONTEXT PATH>: Path to WAR file path to be deployed on Apache Tomcat."
    echo "<WAR FILE PATH>: Path to WAR file path to be deployed on Apache Tomcat."
    echo ""
}

if [ "$1" = "" ] || [ "$1" = "--help" ]; then
    help
    exit 0
fi

if [ "$2" = "" ]; then
    help
    exit 0
fi

if [ "$3" = "" ]; then
    help
    exit 0
fi

TOMCAT_DIR=$1
CONTEXT_PATH=$2
APP_WAR_FILE=$3

echo "Path to Apache Tomcat: $TOMCAT_DIR"
echo "Path to WAR file: $APP_WAR_FILE"
echo "Context path: $CONTEXT_PATH"

echo "Stopping Apache Tomcat..."

sh $TOMCAT_DIR/bin/shutdown.sh

echo "Removing old app directory..."

rm -rf $TOMCAT_DIR/webapps/$CONTEXT_PATH

echo "Copying application..."

cp $APP_WAR_FILE $TOMCAT_DIR/webapps/

echo "Starting Apache Tomcat..."

sh $TOMCAT_DIR/bin/startup.sh

echo "[DONE]"
