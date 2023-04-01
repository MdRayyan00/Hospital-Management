package model;

import java.time.Instant;

public class Patient {
    private String name;
    private String priority;
    private int id;
    private Instant time;

    public Patient(String name, String priority, int id, Instant time) {
        this.name = name;
        this.priority = priority;
        this.id = id;
        this.time = time;
    }

    public Patient() {
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
}
