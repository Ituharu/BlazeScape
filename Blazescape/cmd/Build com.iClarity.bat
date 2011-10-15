@echo off
cd ../src
echo Compiling com.iClarity
"C:\Program Files\Java\jdk1.6.0_27\bin\javac.exe" -cp . -d ../bin/ ./com/iClarity/*.java
pause