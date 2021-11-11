call cd .\..
call cd .\collection
call mvn clean install
call cd .\..
call cd .\hw_5_collection
call mvn clean install
call java -jar target\hw_5_collection.jar