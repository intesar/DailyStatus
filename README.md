Project : DailyStatus tracker

Local setup:

1. Requires MySQL DB
2. create a db with name "dailystandup_db"
3. Update spring/shared.xml with MySQL url, username, and password

Run:
mvn clean install
mvn tomcat:run

Playing with REST API's

1. Create a account
http://localhost:8080/DailyStandup/api/standup/
POST

response : 

2. Get all my statuses
  http://localhost:8080/DailyStandup/api/standup/<hashtag>
  GET

3. Add status
   http://localhost:8080/DailyStandup/api/standup/status
   POST
   body : hashtag=486d80f1-b13e-4a96-8741-4a72dea5ddce&statuses=test3&statusDay=Sun Feb 24 2013 23:18:09 GMT-0800 (PST)

   Run this api multiple times by chaning statusDay & statuses values
