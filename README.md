Project : DailyStatus tracker

Local setup:

1. Requires MySQL DB
2. create a db with name "dailystandup_db"
3. Update spring/shared.xml with MySQL url, username, and password

Run:
mvn clean install
mvn tomcat:run

Playing with REST API's

You may need this chrome extension
https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US

1. Create a account
   http://localhost:8080/DailyStandup/api/standup/
   Method: POST


2. Get all my statuses
   http://localhost:8080/DailyStandup/api/standup/<hashtag>
   Method : GET

3. Add status
   http://localhost:8080/DailyStandup/api/standup/status
   Method : POST
   body : hashtag=486d80f1-b13e-4a96-8741-4a72dea5ddce&statuses=test3&statusDay=Sun Feb 24 2013 23:18:09 GMT-0800 (PST)

   Run the 2 endpoint multiple times by chaning statusDay & statuses values
