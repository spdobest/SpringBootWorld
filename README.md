# How to set up Security in MYSQL using JPA
In this , we are going to implement security in MySql Database
## First Install and Setup MySql Database
- Download MySql from below link
    - https://dev.mysql.com/downloads/file/?id=492745
- Install the downloaded mysql file from above link
- Setup the MySql Path in .bash profile
- https://phoenixnap.com/kb/mysql-command-not-found-error
    - To edit .bash_profile
        -  nano .bash_profile
        or
        - open -t .bash_profile
    - export PATH=${PATH}:/user/local/mysql/bin/
    - To start MySql from command line
        - /usr/local/mysql/support-files/mysql.server
    - Set the user and password for mysql
        - mysql --user=root --password=D0best42o

    - After setting the path in .bash_profile
        - enter the below command in command prompt
        - mysql -u root -p
        - enter the password now
        - to change the password
        - ALTER USER 'root'@'localhost' IDENTIFIED BY 'myNewPassword';
        - To see the databases - show databases;
        - to create database - create database databaseName;
        - use databasename; // to change the database



