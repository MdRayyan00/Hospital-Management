package model;

public class Patient {
    private String name;
    private int priority;
    private int id;

    public Patient(String name, int priority, int id) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient() {
    }
}
