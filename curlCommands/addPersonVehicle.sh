curl -X POST 'localhost:8080/persons/addVehicle/'$1 -H 'Authorization: Bearer '$(cat ./token.txt) -H 'Content-Type: application/json' -d @./vehicle.json | python -m json.tool
