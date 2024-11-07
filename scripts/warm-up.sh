#!/bin/bash

host=$1
port="8080"

if [ -z "$host" ]; then
  host="192.168.0.12"
  echo "No host provided. '192.168.0.12' is used"
fi

echo "Send 10 get request to '$host:$port/employee'"

for i in {0..9}; do
  curl -s "$host:$port/employee?page=$i" > /dev/null
done

echo "Warming up done."
