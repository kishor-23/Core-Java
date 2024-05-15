package model;


public class HabitRecords {
    private int recordId;
    private int userId;
    private int habitId;
    private String recordDate;
    private String status;

    public HabitRecords() {
        // Default constructor
    }

    public HabitRecords(int recordId, int userId, int habitId, String recordDate, String status) {
        this.recordId = recordId;
        this.userId = userId;
        this.habitId = habitId;
        this.recordDate = recordDate;
        this.status = status;
    }
    public HabitRecords( int userId, int habitId, String recordDate, String status) {
       
        this.userId = userId;
        this.habitId = habitId;
        this.recordDate = recordDate;
        this.status = status;
    }


    // Getters and setters
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", userId=" + userId +
                ", habitId=" + habitId +
                ", recordDate=" + recordDate +
                ", status='" + status + '\'' +
                '}';
    }
}
