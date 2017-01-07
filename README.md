# org-uhc-pharma
Sample Pharma Project
#Run the application by following the below steps 
	#navigate to project source where pom.xml is present using command prompt
	#use mvn spring-boot:run to run the application
#uhc-pharma is a spring boot application uses embeded tomcat server to run #the application.
#Hsqldb is used to store the data
#actuator end points are secured
#The list of feautures implemented are 
	#Spring Rest
	#Spring Transaction
	#Spring security using UserDetailsService
	#Cacheing using ConcurrentMapCacheManager for local environment and 		#GuavaCacheManager for production environment
	#In memory data base
	#Spring repositrory using JpaRepository
#Refer files 	Pom.xml,Application.java,application-<>.properties,data.sql,sechma.sql 	files 	to unserstand the application.
	