package service;

import model.Player;
import repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

public class PlayerService {

    private final PlayerRepository playerRepository = new PlayerRepository();

    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    public Optional<Player> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
