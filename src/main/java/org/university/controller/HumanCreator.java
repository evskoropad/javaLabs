package org.university.controller;

import org.university.model.Human;
import org.university.model.Sex;

public class HumanCreator implements Creator<Human> {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Sex sex;

    public HumanCreator(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    @Override
    public Human create() {
        return new Human(firstName, lastName, patronymic, sex);
    }
}