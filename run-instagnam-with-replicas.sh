#!/bin/bash
#4
docker-compose up --scale ricette=4 --scale connessioni=4 --scale ricette-seguite=4

echo Started with replicas