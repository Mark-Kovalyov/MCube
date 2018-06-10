#!/bin/bash

# mvn groupId:artifactId:goal -P profile-1,profile-2

mvn clean package -P benchmark

java -jar target/bencmark.jar
