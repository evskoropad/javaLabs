package org.university.model;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUnit baseUnit = (BaseUnit) o;
        return name.equals(baseUnit.name) &&
                head.equals(baseUnit.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }
}