#!/bin/bash

elasticsearch -f -Des.node.name=node-1 &

elasticsearch -f -Des.node.name=node-2 &

echo 'Elastic search is running'