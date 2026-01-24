package model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private int id;
    private String name;
    private Game game;
    private List<Team> teams;

    public Tournament(int id, String name, Game game) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.teams = new ArrayList<>();
    }

    public int getId(){ return id; }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        if(teams.size() < 16) { // допустим максимум 16 команд
            teams.add(team);
        } else {
            System.out.println("Tournament is full!");
        }
    }

    public void registerTeam(Team team){
        if (team.playerCount() == game.getTeamSize()) {
            System.out.println("Team " + team.getName() + " registrated!");
            team.register(true);
            teams.add(team);
        }
        else {
            System.out.println("Not enough participants.");
            team.register(false);
        }
    }

    public void startTournament(){
        if(teams.size() < 2) {
            throw new IllegalStateException(
                    "Cannot start tournament. At least 2 teams required. "
            );
        }
        for(Team team: teams){
            if(!team.isRegistered()){
                throw new IllegalStateException(
                        "Team " + team.getName() + " is not registered."
                );
            }
        }
        System.out.println("Tournament started with " + teams.size() + " teams!");
    }

    @Override
    public String toString() {
        return "Tournament name=" + name +  '\n' +
                "Game=" + game.getName() + '\n' +
                "Teams: " + teams.getFirst().getName() + ", " + teams.getLast().getName();
    }
}
