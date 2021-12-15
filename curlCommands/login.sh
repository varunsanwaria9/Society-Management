email=''
passwd='1234'
if [ $1 ] 
then
	email=$1
else 
	email="user1@mail.com"
fi
x=$(curl -X POST 'localhost:8080/api/login' -H 'Content-Type: application/x-www-form-urlencoded' -d 'email='$email'&password='$passwd) 
echo $x
echo $x | python -c 'import sys, json; print json.load(sys.stdin)["access_token"]' > ./token.txt

