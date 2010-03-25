/home/remi/dev/apache-tomcat-6.0.20/bin/shutdown.sh
rm -R ~/dev/apache-tomcat-6.0.20/webapps/media-0.0.1-SNAPSHOT*
cp target/media-0.0.1-SNAPSHOT.war ~/dev/apache-tomcat-6.0.20/webapps/
/home/remi/dev/apache-tomcat-6.0.20/bin/startup.sh
