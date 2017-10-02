#!/bin/bash

set -e

gradle installDist

while IFS= read -r serverEntry
do
    serverName=$(echo $serverEntry | awk '{print $1}')
    serverIp=$(echo $serverEntry | awk '{print $2}')
    serviceName=$(echo $serverEntry | awk '{print $3}')

    echo "Deploying monitoring agent on service $serviceName@$serverName"
    scp -q -r build/install/monitoring-service/lib $serverName:/home/centos/
    scp -q -r build/install/monitoring-service/bin $serverName:/home/centos/
    scp -q -r startDeamon.sh $serverName:.
    echo "Instanciating"
    ssh -n $serverName ./startDeamon.sh

done <"../acmeair-openstack/serverlist"

