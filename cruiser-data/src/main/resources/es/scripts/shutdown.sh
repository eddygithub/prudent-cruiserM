#!/bin/bash

curl -XPOST 'http://localhost:9200/_shutdown'

echo ""
echo "Elastic Search node is downed"