FROM maven:3.3.9-jdk-8

COPY java-libs/* /tmp/
 
COPY dina-classifications-api /usr/src/mymaven

WORKDIR /usr/src/mymaven

RUN mvn install:install-file -Dfile=java-libs/trove-2.1.0.jar -DgroupId=gnu.trove \
        		-DartifactId=trove -Dversion=2.1.0 -Dpackaging=jar \


CMD ["mvn", "clean", "package"]