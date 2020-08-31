#!/bin/bash

echo "gradle build\n"

gradle clean build

echo -e "\nstarting minikube\n"

minikube start
minikube addons enable ingress
