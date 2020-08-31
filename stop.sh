#!/bin/bash

kubectl delete all --all -n instagnam
kubectl delete namespace instagnam

echo Stopped
