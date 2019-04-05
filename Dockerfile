FROM java:8

# Application JAR file as a variable
ARG JAR_FILE=target/codeninja-fruit-basket.jar

# Copy JAR file into the container image
ADD ${JAR_FILE} /codeninja-fruit-basket.jar
ADD fruitbasket.sh /fruitbasket.sh

# Expose Tomcat default port
EXPOSE 8080

# Run the jar file 
ENTRYPOINT exec "./fruitbasket.sh"