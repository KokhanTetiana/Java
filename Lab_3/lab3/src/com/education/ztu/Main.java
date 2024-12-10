package com.education.ztu;

import com.education.ztu.game.*;

public class Main {

    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Olivia", 23);
        Schoolar schoolar2 = new Schoolar("Inna", 14);

        Team<Schoolar> schoolarTeam = new Team<>("Star");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);


        Team<Schoolar> clonedTeam = schoolarTeam.cloneTeam();
        System.out.println("Original team: " + schoolarTeam);
        System.out.println("Cloned team: " + clonedTeam);

        System.out.println("Schoolar1 equals schoolar2: " + schoolar1.equals(schoolar2));
        System.out.println("Schoolar1 hashCode: " + schoolar1.hashCode());
        System.out.println("Schoolar2 hashCode: " + schoolar2.hashCode());
    }
}
