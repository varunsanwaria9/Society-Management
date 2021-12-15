resp=$(curl -X GET 'localhost:8080/persons/allUsers' -H 'Authorization: Bearer '$(cat ./token.txt))
echo $resp | python -m json.tool
