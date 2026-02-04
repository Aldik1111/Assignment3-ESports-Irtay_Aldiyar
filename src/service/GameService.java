package service;

import model.Game;
import repository.GameRepository;

import java.util.List;
import java.util.Optional;

public class GameService {

    private final GameRepository gameRepository = new GameRepository();

    public void createGame(Game game) {
        gameRepository.save(game);
    }

    public Optional<Game> getGameById(int id) {
        return gameRepository.findById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        gameRepository.save(game); // для простоты save обновляет, можно добавить check
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }
}
