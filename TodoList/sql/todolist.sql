create database test_db_1;
use test_db_1;

create table user(
 int id primary key AUTO_INCREMENT,
 mailId varchar(30) unique,
 name varchar(30) not null,
 password varchar(30) not null
);

CREATE TABLE task (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) not null,
    status VARCHAR(50),
    priority VARCHAR(50) check  (priority in ('high','medium','low')),
    task_date datetime, 
    user_id int
);


ALTER TABLE task
ADD CONSTRAINT fk_user_mail
FOREIGN KEY (user_id)
REFERENCES user(id)
ON DELETE CASCADE;

-- query to check if a user account already exists
-- if exists, return user information, else return no record
SELECT mailId, password, name FROM user WHERE mailId ='user@mail.com';

-- query to check login
-- if the select returns no record, the login is incorrect; else, it's correct
SELECT mailId, password, name FROM user WHERE mailId ='user@mail.com' AND password = '#Password123';

-- Select tasks related to a specific user
SELECT name, status, task_date FROM todo_task WHERE user_id = 1;

select * from user;

-- sort task based on priority
SELECT id, name, status,priority, task_date  FROM task
WHERE user_id = 1 and CAST(task_date AS DATE)="2024-05-08"
ORDER BY CASE 
     WHEN  priority = "high" THEN 1
     WHEN priority = "medium" THEN 2
     WHEN priority = "low" THEN 3
     END ASC,task_date asc  ;
 
     
 CREATE TABLE events (
    eventid INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL
);
