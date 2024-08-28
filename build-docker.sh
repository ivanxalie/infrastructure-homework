#!/bin/bash
set -e
./build.sh
docker build -t stringconcat/people .