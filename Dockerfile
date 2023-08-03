FROM tomcat:9.0
ADD pet-clinic-web/target/*.war /usr/local/tomcat/webapps
ADD pet-clinic-data/target/*.jar /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]