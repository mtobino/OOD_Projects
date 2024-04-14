docker ps -aq | xargs docker stop
docker rmi rmi/gumballservice
docker rmi rmi/gumballclient

