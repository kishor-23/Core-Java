package model;
public class Habit {
    private int habitID;
    private int userID;
    private String habitName;

    public Habit() {
        // Default constructor
    }

    public Habit( int userID, String habitName) {
        this.userID = userID;
        this.habitName = habitName;
    }

    // Getters and setters
    public int getHabitID() {
        return habitID;
    }

    public void setHabitID(int habitID) {
        this.habitID = habitID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    // toString method
    @Override
    public String toString() {
        return "Habit{" +
                "habitID=" + habitID +
                ", userID=" + userID +
                ", habitName='" + habitName + '\'' +
                '}';
    }
}
