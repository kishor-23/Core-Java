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

#### Select tasks and order them by priority

```sql
SELECT id, name, status,priority, task_date  FROM task
WHERE user_id = 1 and CAST(task_date AS DATE)="2024-05-08"
ORDER BY CASE 
     WHEN  priority = "high" THEN 1
     WHEN priority = "medium" THEN 2
     WHEN priority = "low" THEN 3
     END ASC,task_date asc  ;
```



####   Result


   | ID       |    NAME                     | status    | task-date   | priority |
   |----------|-----------------------------|-----------|-------------|----------|
   | 2        | net practice for batting    | done      | 2024-05-02  | high     |
   | 3        | practice for wicket-keeping | Not done  | 2024-05-02  | medium   |


