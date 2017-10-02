#/bin/bash



pid=$(ps aux | grep java | grep monitoring-service | awk '{print $2}')

if [ ! -z "$pid" -a "$pid" != " " ]; then
    echo "Killing existing process $pid"
    kill $pid
fi

screen -d -m /home/centos/bin/monitoring-service
echo "Started"
