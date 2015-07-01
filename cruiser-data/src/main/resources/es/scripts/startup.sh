#!/bin/bash

elasticsearch -Des.cluster.name=eddy-es-cluster1 -Des.node.name=node-1 &

elasticsearch -Des.cluster.name=eddy-es-cluster1 -Des.node.name=node-2 &

echo 'Elastic search is running'