FROM tomcat:9.0
COPY /var/lib/jenkins/workspace/DockerTomcatPipeline/pet-clinic-web/target/pet-clinic-web-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]