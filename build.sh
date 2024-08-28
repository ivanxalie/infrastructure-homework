#!/bin/bash
set -e
./gradlew :avatarsDicebear:spotlessApply :businessPeople:spotlessApply :persistence:spotlessApply :presentation:spotlessApply :quoteGarden:spotlessApply :useCasePeople:spotlessApply
./gradlew build