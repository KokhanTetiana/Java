package com.education.ztu.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * Клас Game відповідає за логіку гри.
 */
public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);


    /**
     * Головний метод, який виконує основну логіку гри:
     * 1. Створює учасників і команди.
     * 2. Серіалізує і десеріалізує команди.
     * 3. Логує важливі події гри.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);

        Team<Schoolar> scollarTeam = new Team<>("Dragon");
        scollarTeam.addNewParticipant(schoolar1);
        scollarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> scollarTeam2 = new Team<>("Rozumnyky");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        scollarTeam2.addNewParticipant(schoolar3);
        scollarTeam2.addNewParticipant(schoolar4);

        logger.info("Teams created successfully!");

        logger.info("Teams are going to play against each other");
        scollarTeam.playWith(scollarTeam2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teams.ser"))) {
            oos.writeObject(scollarTeam);
            oos.writeObject(studentTeam);
            oos.writeObject(employeeTeam);
            logger.info("Teams serialized successfully!");
        } catch (IOException e) {
            logger.error("Error serializing teams", e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teams.ser"))) {
            Team<Schoolar> scollarTeamDeserialized = (Team<Schoolar>) ois.readObject();
            Team<Student> studentTeamDeserialized = (Team<Student>) ois.readObject();
            Team<Employee> employeeTeamDeserialized = (Team<Employee>) ois.readObject();

            logger.info("Deserialized teams:");
            logger.info(scollarTeamDeserialized.toString());
            logger.info(studentTeamDeserialized.toString());
            logger.info(employeeTeamDeserialized.toString());
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Error deserializing teams", e);
        }
    }
}
