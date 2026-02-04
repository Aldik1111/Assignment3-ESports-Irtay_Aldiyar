package controller;

import model.Player;
import service.PlayerService;
import exception.ApplicationException;

import java.util.List;

public class PlayerController {

    private final PlayerService service = new PlayerService();

    public void create(Player player) {
        try {
            service.create(player);
            System.out.println("Player created: " + player.getNickname());
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void getAll() {
        List<Player> players = service.getAll();
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        players.forEach(System.out::println);
    }

    public void getByTeam(int teamId) {
        List<Player> players = service.getByTeam(teamId);
        if (players.isEmpty()) {
            System.out.println("No players in team " + teamId);
            return;
        }
        players.forEach(System.out::println);
    }
}
