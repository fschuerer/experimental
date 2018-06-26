#!/bin/sh
mvn clean package && docker build -t de.fs/microprofile .
docker rm -f microprofile || true && docker run -d -p 8080:8080 -p 4848:4848 --name microprofile de.fs/microprofile 
