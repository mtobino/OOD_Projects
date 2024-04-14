#! /bin/bash

NETWORK="rminet"

docker stop gumballservice >/dev/null 2>&1
docker run -itd --rm --name gumballservice --network $NETWORK rmi/gumballservice >/dev/null

echo "Gumball Service Operational"
