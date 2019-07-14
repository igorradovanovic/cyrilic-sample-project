# cyrilic-sample-project
DATA BASE INSTRUCTIONS
To access Remotable mySql DB follow this instructions:

url:https://remotemysql.com/phpmyadmin/
username:m0MuZEzscT
password:1Jhcz4x279


INSTALLATION INSTRUCTIONS
1. Download ZIP or clone this project
2. Run "mvn clean install"
3. Run project as Spring Boot App
4. Test this Project via Postman using Basig Auth

USER ROLES

username: admin

password: 2910 

user_role: "ROLE_ADMIN"

- can access all users
- can access only access-granted farms --> for purpose of this test all farms are available for "ROLE_ADMIN"
- can access only access-granted customers --> for purpose of this test all customers are available for "ROLE_ADMIN"
- can access only access-granted accounts granted by customers --> for purpose of this test all accounts are available for "ROLE_ADMIN"


username: igor.radovanovic 

password: 2910 

user_role: "ROLE_USER"

- access-denied for Controller /users
- can access only access-granted customers --> for purpose of this test this user can access only cst_id 2 and 3
- can access only access-granted accounts granted by customers --> for purpose of this test this user can access only accounts related to customer with cst_id 2 and 3 
- can access only access-granted farms --> for purpose of this test this user can access only farms mapped to access-granted customers


username: milos.koscica 
password: 2910 

user_role: "ROLE_USER"

- access-denied for Controller /users
- can access only access-granted customers --> for purpose of this test this user can access only cst_id 4 and 5
- can access only access-granted accounts granted by customers --> for purpose of this test this user can access only accounts related to customer with cst_id 4 and 5 
- can access only access-granted farms --> for purpose of this test this user can access only farms mapped to access-granted customers


username: guest

password: 2910

user_role: "ROLE_ANONYMOUS"

-access-denied for everything. Gets message = "ACCESS_IS_DENIED_CHECK_YOUR_ACCOUNT_PRIVIELGE

