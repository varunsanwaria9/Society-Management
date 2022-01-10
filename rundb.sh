x=$(sudo docker run --name society-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD="Jack@5652" -e MYSQL_DATABASE="datas" -d mysql:8.0.26)
echo $x
docker logs -f society-db
