# TodoList- personal reminder app



####   Table : User


  |id  |    Mail Id         | Name      | Password   |
  |----|--------------------|-----------|------------|
  | 1  |   kishor@gmail.com | kishor    | #Hello23   |
  | 2  |   msd@gmail.com    | dhoni     | #Msd07     |
  | 3  |   messi@gmail.com  | messi     | #Messi10   |




####   Table : todo_task


  | ID       |    NAME                     | STATUS    |  priority   | TASK_DATE   | USER_id  |
  |----------|-----------------------------|-----------|-------------|-------------|----------|
  | 1        | workout                     | Not done  |    low      | 2024-05-07  |     1    |
  | 2        | net practice for batting    | done      |    high     | 2024-05-02  |     2    |
  | 3        | practice for wicket-keeping | Not done  |   medium    | 2024-05-02  |     2    |
  | 4        | 10km  running               | Not done  |    low      | 2024-05-03  |     3    |


#### Select tasks related to a specific user

```sql
SELECT id,name,status,task_date FROM todo_task WHERE user_id =2;

```


####   Result


   | ID       |    NAME                     | status    | task-date   | 
   |----------|-----------------------------|-----------|-------------|
   | 2        | net practice for batting    | done      | 2024-05-02  | 
   | 3        | practice for wicket-keeping | Not done  | 2024-05-02  | 


