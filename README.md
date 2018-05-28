*Installing and Running the Match Engine to list jobs to workers* 
***************************************************************

--> Should have Java Runtime Environment JDK1.8
--> have JAVA Home and Path Variable set in Environment Variables
--> have Maven Home and Path Variable set (Maven Version 3.5.0) in Environment Variables
--> Make sure Java and Maven installed properly by referring below

C:\Users\pavveera>java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)

C:\Users\pavveera>mvn -version
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T05:39:06+10:00)
Maven home: C:\apache-maven-3.5.0\bin\..
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_131\jre
Default locale: en_AU, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"

--> Download the project from https://github.com/veerankipavan/SwipeJobsTechAssignment.git 

--> Load the pom.xml as a project in IDE and apply maven settings, resolve maven dependencies if there are any 
--> After making sure there are no compilation errors run the command as --> mvn clean spring-boot:run
--> Should be able to access the rest endpoint on the port 8080 either in browser or postman --> http://localhost:8080/matches/workerId/{id}
--> Swagger is also configured with this RestAPI to get elegant documentation and same can be accessed via --> http://localhost:8080/swagger-ui.html




