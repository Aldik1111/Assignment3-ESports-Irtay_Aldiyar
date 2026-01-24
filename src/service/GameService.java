package service;

import model.Game;
import repository.GameRepository;

public class GameService {

    private final GameRepository repository = new GameRepository();

    public void createGame(Game game) {
        if (!game.getGenre().equalsIgnoreCase("MOBA") &&
                !game.getGenre().equalsIgnoreCase("FPS")) {
            throw new IllegalArgumentException("Game genre must be MOBA or FPS");
        }
        repository.create(game);
    }
}
