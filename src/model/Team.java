package model;

import model.interfaces.IRegisterable;

import java.util.ArrayList;
import java.util.List;

public class Team implements IRegisterable {
    private int id;
    private String name;
    private List<Player> players;
    private Game game;
    private boolean registered = false;

    public Team(int id, String name, Game game) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
        this.game = game;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) { // add new player
        if(players.size() < 5) {
            players.add(player);
        } else {
            System.out.println("Team is full!");
        }
    }

    public int playerCount(){
        return players.size();
    } // how many players

    public void register(boolean registered){
        this.registered = registered;
    } // register

    public boolean isRegistered() {
        return registered;
    } // check register

    @Override
    public String toString() {
        return "Team" +
                "name=" + name + " | players=" + getPlayers();
    }
}
