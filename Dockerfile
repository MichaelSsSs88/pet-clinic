FROM tomcat:9.0
ADD /var/lib/jenkins/workspace/DockerTomcat Pipeline/**/*.war /opt/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]