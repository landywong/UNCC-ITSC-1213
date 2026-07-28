#!/usr/bin/env bash
#
# compileAndRun.sh -- one-button compile, run, and Javadoc cycle for
# the Day 20 Coffee Shop project.
#
# Usage:
#   chmod +x compileAndRun.sh
#   ./compileAndRun.sh
#
# Standard pattern from earlier labs in this course: stop on the first
# error, clean any stale artefacts, recompile, run, and emit Javadoc.

set -e

echo "===> cleaning"
rm -f *.class
rm -rf docs

echo "===> compiling"
javac *.java

echo "===> running"
java CoffeeShop

echo "===> generating Javadoc"
mkdir -p docs
javadoc -d docs -quiet *.java || true

echo "done."
