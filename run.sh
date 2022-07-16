#!/bin/sh

./gradlew \
# Delete old jars
clean \
# Run tests for utility module
:utility:test \
# Create executable .jar file
:utility:fatJar

cd utility

# Run the application passing in requiredProgramArguments
java -jar build/libs/event-publishing-utility-1.0-SNAPSHOT.jar \
eventFile=src/main/resources/batchstart.txt \
preferencesFile=/tmp/prefs \
pubFlag=YES

cd - > /dev/null