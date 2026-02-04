package controller;

import exception.ApplicationException;
import model.Game;
import service.GameService;

import java.util.List;

public class GameController {

    private final GameService service = new GameService();

    public void create(Game game) {
        try {
            service.create(game);
            System.out.println("<=======================>");
            System.out.println("Game " + game.getName() + " created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void getAll() {
        List<Game> games = service.getAll();
        if (games.isEmpty()) {
            System.out.println("No games found.");
            return;
        }
        games.forEach(g ->
                System.out.println(g.getId() + " | " + g.getName() + " | " + g.getGenre())
        );
    }

    public void getById(int id) {
        Game game = service.getById(id);
        if (game == null) {
            System.out.println("Game not found.");
            return;
        }
        System.out.println(game.getId() + " | " + game.getName() + " | " + game.getGenre());
    }

    public void update(int id, Game game) {
        service.updateGame(id, game);
        System.out.println("<=======================>");
        System.out.println("Game updated.");
    }

    public void delete(int id) {
        try {
            service.deleteGame(id);
            System.out.println("<=======================>");
            System.out.println("Game deleted.");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
