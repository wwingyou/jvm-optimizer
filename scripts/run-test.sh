#!/bin/bash

profile=$1
testfile=test.yml

if [ -n "$profile" ]; then
  testfile="test-$profile.yml"
fi

artillery run "$testfile" \
  --key "$ARTILLERY_KEY" \
  --tags project:jvmoptimizer \
  -o report.json
