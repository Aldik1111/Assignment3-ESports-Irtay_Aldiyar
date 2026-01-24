package service;

import model.Game;
import repository.GameRepository;

import java.util.List;

public class GameService {

    private final GameRepository repository = new GameRepository();

    public void create(Game game) {
        if (!game.getGenre().equalsIgnoreCase("MOBA") &&
                !game.getGenre().equalsIgnoreCase("FPS")) {
            throw new IllegalArgumentException("Game genre must be MOBA or FPS");
        }
        repository.create(game);
    }
    public List<Game> getAll() {
        return repository.getAll();
    }

    public Game getById(int id) {
        return repository.getById(id);
    }

    public void updateGame(int id, Game game) {
        repository.update(id, game);
    }

    public void deleteGame(int id) {
        repository.delete(id);
    }
}
