#! /bin/bash

NETWORK="rminet"

docker stop gumballservice >/dev/null 2>&1
echo "Gumball Service Operational"

winpty docker run -it --rm --name gumballservice --network $NETWORK rmi/gumballservice


