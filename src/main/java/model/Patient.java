package model;

import java.time.Instant;
import java.util.Date;

public class Patient {
    private String name;
    private String priority;
    private int id;
    private Instant date;

<<<<<<< Updated upstream
    public Patient(String name, String priority, int id, Instant time) {
        this.name = name;
        this.priority = priority;
        this.id = id;
        this.time = time;
    }

    public Patient() {
=======
    public Patient(String name, int priority, int id, Instant date) {
        this.name = name;
        this.priority = priority;
        this.id = id;
        this.date = date;
>>>>>>> Stashed changes
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", id=" + id +
                ", time=" + time +
                '}';
    }
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}
