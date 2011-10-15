@echo off
cd ../src
echo Compiling com.iClarity.player
"C:\Program Files\Java\jdk1.6.0_27\bin\javac.exe" -cp . -d ../bin/ ./com/iClarity/player/*.java
pause