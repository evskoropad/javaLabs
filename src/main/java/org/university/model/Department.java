package org.university.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends BaseUnit {
    private List<Group> groups;

    public Department(String name, Human head) {
        super(name, head);
        this.groups = new ArrayList<>();
    }

    public List<Group> getGroups() { return groups; }
    public void addGroup(Group group) { groups.add(group); }
}