
# users_organizations-microservice

Microservice that contains organizations user management for Athenea project. Build on top of:

 - CXF (JAX-WS)
 - Spring
 - MyBatis
 - MySql
 
 In order to start you must:
 
  1. Run sql script located in /sql
  2. Change username and password at jdbc.properties files (src/main/resources) to whatever you're using with your MySql server
  3. run "mvn tomcat:run-war"

* Notice that you must have tomcat7/8 installed and configured for maven, more at:
https://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/

Now you can access the microservices at: http://localhost:8080/users_organizations-microservice/





--------------------------- @authors

unaizuzu@opendeusto.es
g.virum@opendeusto.es
ruben.sancor@opendeusto.es
aritz.badiola@opendeusto.es

