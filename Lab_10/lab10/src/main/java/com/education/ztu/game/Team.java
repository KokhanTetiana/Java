package com.education.ztu.game;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> implements Cloneable, Serializable {
    @Serial
    private static final long serialVersionUID = -5917625402739212672L;
    private String name;
    private transient List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());

    }

    public void playWith(Team<T> team) {
        System.out.println("Team " + this.name + " is playing with team " + team.name);
        String winnerName;
        Random random = new Random();
        winnerName = random.nextInt(2) == 0 ? this.name : team.name;
        System.out.println("The team " + winnerName + " is winner!");
    }

    public Team<T> cloneTeam() {
        Team<T> clonedTeam = new Team<>(this.name);
        for (T participant : participants) {
            clonedTeam.addNewParticipant(participant);
        }
        return clonedTeam;
    }

    @Override
    public String toString() {
        return "Team{name='" + name + "', participants=" + participants + '}';
    }

}
