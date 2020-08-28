#!/bin/bash

docker-compose up --scale ricette-service=2 --scale connessioni-service=2 --scale ricette-seguite-service=2 -d 

echo Started with replicas
