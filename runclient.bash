#! /bin/bash

NETWORK="rminet"

if [ "$(docker network ls | grep $NETWORK)" == "" ]; then
	echo "Service not installed. Run setup, then run runservice"
	exit
fi

echo; echo; echo "Client starting ... "
winpty docker run -it --rm  --network $NETWORK rmi/gumballclient