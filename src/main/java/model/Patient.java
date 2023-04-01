package model;

import java.time.Instant;

public class Patient {
    private String name;
    private String priority;
    private String id;
    private Instant time;

    public Patient(String name, String priority, String id, Instant time) {
        this.name = name;
        this.priority = priority;
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", id='" + id + '\'' +
                ", time=" + time +
                '}';
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
