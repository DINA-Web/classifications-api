FROM openjdk:8

#COPY classifications-swarm.jar /opt/classifications-swarm.jar

COPY dina-classifications-api/target/classifications-swarm.jar /opt/classifications-swarm.jar 

EXPOSE 8080

ENTRYPOINT ["java", "-Djboss.bind.address=0.0.0.0", "-jar", "/opt/classifications-swarm.jar"]


 



 