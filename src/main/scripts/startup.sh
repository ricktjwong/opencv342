#!/bin/sh

# Simple UNIX-ish script to start the job;
# author : Rick Wong
# date   : 18 Aug 2018
#
JVM_OPTS=""
java -Djava.library.path=/usr/local/Cellar/opencv/3.4.2/share/OpenCV/java -jar ../../../target/pHash-1.0.0.jar 
