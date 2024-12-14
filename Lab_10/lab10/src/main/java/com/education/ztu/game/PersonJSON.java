package com.education.ztu.game;

import com.google.gson.Gson;

public class PersonJSON {
    private String name;
    private int age;

    public PersonJSON(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        PersonJSON person = new PersonJSON("Tetiana", 18);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("Java to JSON: " + json);
        PersonJSON newPerson = gson.fromJson(json, PersonJSON.class);
        System.out.println("JSON to Java: " + newPerson);
    }
}
