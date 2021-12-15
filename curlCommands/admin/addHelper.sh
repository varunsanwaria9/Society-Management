curl -X POST 'localhost:8080/admin/helperAdd' -H 'Authorization: Bearer '$(cat ../token.txt) -H 'Content-Type: application/json' -d @./addHelper.json | python -m json.tool
