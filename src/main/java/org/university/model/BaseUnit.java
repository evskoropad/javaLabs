package org.university.model;

public abstract class BaseUnit {
    protected String name;
    protected Human head;

    public BaseUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Human getHead() { return head; }
    public void setHead(Human head) { this.head = head; }
}