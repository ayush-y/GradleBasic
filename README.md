📌 Gradle CLI Setup and JAR Execution
✅ 1. Setup a Basic Gradle Project
To initialize a Gradle Java application using the command line, run:

sh
Copy code
gradle init --use-defaults --type java-application
🔹 This will create a basic Gradle project with a standard directory structure.

✅ 2. Build the Project
To build the project using Gradle Wrapper:

sh
Copy code
./gradlew build  # (Linux/macOS)
gradlew build    # (Windows CMD)
🔹 This compiles the source code and packages it into a JAR file inside build/libs/.

✅ 3. Make the JAR Executable
To run the JAR, Gradle needs to know the main class. Add this to build.gradle:

gradle
Copy code
jar {
    manifest {
        attributes(
            'Main-Class': 'org.example.Main'  // Replace with your actual main class
        )
    }
}
🔹 This sets up the manifest file so the JAR can be executed directly.

✅ 4. Create the JAR File
Run the following command to generate the JAR:

sh
Copy code
./gradlew jar  # (Linux/macOS)
gradlew jar    # (Windows CMD)
🔹 This will produce a JAR file inside build/libs/.

✅ 5. Run the JAR File
Execute the generated JAR using:

sh
Copy code
java -jar build/libs/filename.jar
🔹 Replace filename.jar with the actual JAR file name.

🏠 Homework
Task:

Build and run the JAR directly from the CLI.

Check if the OkHttp HTTP request code works correctly.

Instead of OkHttp, integrate the Retrofit library to perform the same HTTP call.

Would you like a sample Retrofit implementation for this? 🚀
