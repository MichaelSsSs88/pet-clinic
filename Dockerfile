FROM tomcat:9.0
COPY **/*.war /opt/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]