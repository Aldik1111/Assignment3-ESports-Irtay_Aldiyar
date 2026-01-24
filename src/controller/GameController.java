package controller;

import model.Game;
import service.GameService;

public class GameController {

    private final GameService service = new GameService();

    public void createGame(Game game) {
        service.createGame(game);
        System.out.println("<=======================>");
        System.out.println("Game " + game.getName() +" created");
    }
}
