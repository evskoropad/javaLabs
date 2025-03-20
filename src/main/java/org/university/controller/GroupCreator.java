package org.university.controller;

import org.university.model.Group;
import org.university.model.Human;

public class GroupCreator implements Creator<Group> {
    private String name;
    private Human head;
    private StudentCreator[] students;

    public GroupCreator(String name, Human head, StudentCreator[] students) {
        this.name = name;
        this.head = head;
        this.students = students;
    }

    @Override
    public Group create() {
        Group group = new Group(name, head);
        for (StudentCreator creator : students) {
            group.addStudent(creator.create());
        }
        return group;
    }
}