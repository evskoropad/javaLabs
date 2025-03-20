package org.university.controller;

import org.university.model.Department;
import org.university.model.Human;

public class DepartmentCreator implements Creator<Department> {
    private String name;
    private Human head;
    private GroupCreator[] groupCreators;

    public DepartmentCreator(String name, Human head, GroupCreator[] groupCreators) {
        this.name = name;
        this.head = head;
        this.groupCreators = groupCreators;
    }

    @Override
    public Department create() {
        Department department = new Department(name, head);
        for (GroupCreator creator : groupCreators) {
            department.addGroup(creator.create());
        }
        return department;
    }
}