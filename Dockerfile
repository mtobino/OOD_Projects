# Tell Docker to use Java 21
FROM openjdk:21

# Copy all of the files in the specified directory to the container directory
COPY src/rowan/ood/protectionproxy /rowan/ood/protectionproxy

# compile all java files and store the compiled files in the "app" directory
RUN javac -d /app /rowan/ood/protectionproxy/*.java

# The working directory of the program, not to be confused with the directory
# the code is in
WORKDIR /app

# Run the Driver
ENTRYPOINT ["java", "rowan.ood.protectionproxy.Driver"]
