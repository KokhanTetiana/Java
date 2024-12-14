package com.education.ztu.game;



import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public abstract class Participant implements Serializable, Cloneable, Comparable<Participant> {
    @Serial
    private static final long serialVersionUID = -4657878580900366796L;
    private String name;
    private int age;

    public Participant(String name, int age) {
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
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }

    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

}
