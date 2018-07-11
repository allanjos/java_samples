wget -c https://download.microsoft.com/download/F/0/F/F0FF3F95-D42A-46AF-B0F9-8887987A2C4B/sqljdbc_4.2.8112.200_enu.tar.gz

tar xvf sqljdbc_4.2.8112.200_enu.tar.gz

mvn install:install-file -Dfile=sqljdbc_4.2/enu/jre8/sqljdbc42.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.2 -Dpackaging=jar
