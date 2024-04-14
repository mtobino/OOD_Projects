#! /bin/bash

NETWORK="rminet"

if [ "$(docker network ls | grep $NETWORK)" == "" ]; then
	echo "Creating docker network $NETWORK ..."
	docker network create -d bridge $NETWORK >/dev/null 2>&1
	echo "Done."
fi

docker build -q -t rmi/gumballservice -f Dockerfile.gumballservice . >/dev/null
docker build -q -t rmi/gumballclient -f Dockerfile.gumballclient . >/dev/null

echo "Setup is complete"