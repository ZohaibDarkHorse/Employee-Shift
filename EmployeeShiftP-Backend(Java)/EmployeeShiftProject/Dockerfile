# Use the OpenJDK 17 base image from the official Docker repository
# This image includes the OpenJDK 17 runtime environment
FROM openjdk:17

# Set the maintainer label for the image
# This is just metadata and not used by Docker itself
LABEL maintainer="Zohaib Ahmad"

# Add the JAR file from the target directory on the host machine
# to the root directory of the Docker image
# The first parameter is the source path on the host, and the second parameter is the destination path in the container
ADD target/EmployeeShiftProject-0.0.1-SNAPSHOT.jar employeeshift-docker-image-v2.jar

# Expose port 8080
EXPOSE 8080

# Set the command to run when the container starts
# This runs the JAR file using the java -jar command
# ENTRYPOINT is used to set the main command, so additional parameters can be appended when running the container
ENTRYPOINT ["java", "-jar", "employeeshift-docker-image-v2.jar"]
