resp=$(curl -X GET 'localhost:8080/admin/helper/id/'$1 -H 'Authorization: Bearer '$(cat ../token.txt))
echo $resp | python -m json.tool
