@echo off
title BlazeScape
java -cp bin;deps/poi.jar;deps/mysql.jar;deps/mina.jar;deps/slf4j.jar;deps/slf4j-nop.jar;deps/jython.jar;log4j-1.2.15.jar;-server -XX:+AggressiveHeap -XX:MaxHeapFreeRatio=90 -XX:MinHeapFreeRatio=90 -XX:+DisableExplicitGC -XX:+RelaxAccessControlCheck -XX:+UseParallelGC -XX:CompileThreshold=1 -XX:ThreadStackSize=128 server.Server
pause