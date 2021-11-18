call cd .\..
call cd .\customcsv
call mvn clean install
call cd .\..
call cd .\hw_7_ionio
call mvn clean install
call java -jar target\hw_7_ionio.jar