package org.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department extends BaseUnit {
    private List<Group> groups;

    public Department(String name, Human head) {
        super(name, head);
        this.groups = new ArrayList<>();
    }

    public List<Group> getGroups() { return groups; }
    public void addGroup(Group group) { groups.add(group); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return groups.equals(that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groups);
    }
}