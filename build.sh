#!/bin/bash

echo gradle build
echo

gradle clean build

echo docker build
echo

docker-compose -f docker-compose.yml build

echo docker push
echo

docker-compose -f docker-compose.yml push
