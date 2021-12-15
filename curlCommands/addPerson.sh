curl -X POST 'localhost:8080/api/addPerson' -H 'Authorization: Bearer '$(cat ./token.txt) -H 'Content-Type: application/json' -d @./addPerson.json | python -m json.tool
