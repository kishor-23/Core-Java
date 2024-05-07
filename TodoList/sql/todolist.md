# TodoList- personal reminder app



####   Table : User


  | Mail Id            | Name      | Password   |
  |--------------------|-----------|------------|
  | kishor@gmail.com   | kishor    | #Hello23   |
  | msd@gmail.com      | dhoni     | #Msd07     |
  | messi@gmail.com    | messi     | #Messi10   |




####   Table : todo_task


  | ID       |    NAME                     | STATUS    | TASK_DATE   | USER_MAIL         |
  |----------|-----------------------------|-----------|-------------|-------------------|
  | 1        | workout                     | Not done  | 2024-05-07  | kishor@gmail.com  |
  | 2        | net practice for batting    | done      | 2024-05-02  | msd@gmail.com     |
  | 3        | practice for wicket-keeping | Not done  | 2024-05-02  | msd@gmail.com     |
  | 4        | 10km  running               | Not done  | 2024-05-03  | messi@gmail.com   |


#### Select tasks related to a specific user

```sql
SELECT id,name,status,task_date FROM todo_task WHERE user_mail ="msd@gmail.com";

```

####   Result


   | ID       |    NAME                     | status    | task-date   | 
   |----------|-----------------------------|-----------|-------------|
   | 2        | net practice for batting    | done      | 2024-05-02  | 
   | 3        | practice for wicket-keeping | Not done  | 2024-05-02  | 


