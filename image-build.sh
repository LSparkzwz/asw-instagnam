echo "build\n"

gradle clean build

docker rmi --force 'lspark/ricette-service'
docker rmi --force 'lspark/ricette-seguite-service'
docker rmi --force 'lspark/connessioni-service'
docker rmi --force 'lspark/apigateway'

docker build -t lspark/ricette-service ricette
docker build -t lspark/ricette-seguite-service ricette-seguite
docker build -t lspark/connessioni-service connessioni
docker build -t lspark/apigateway api-gateway

docker push lspark/ricette-service
docker push lspark/ricette-seguite-service
docker push lspark/connessioni-service
docker push lspark/apigateway

