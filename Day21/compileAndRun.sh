#!/usr/bin/env bash
#
# compileAndRun.sh -- one-button compile, run, and Javadoc cycle for
# the Day 21 Bookstore Lab.
#
# Usage:
#   chmod +x compileAndRun.sh
#   ./compileAndRun.sh

set -e

echo "===> cleaning"
rm -f *.class
rm -rf docs

echo "===> compiling"
javac *.java

echo "===> running"
java BookstoreDriver

echo "===> generating Javadoc"
mkdir -p docs
javadoc -d docs -quiet *.java || true

echo "done."
