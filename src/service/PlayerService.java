package service;

import model.Player;
import repository.PlayerRepository;
import exception.ValidationException;

import java.util.List;

public class PlayerService {

    private final PlayerRepository repository = new PlayerRepository();

    public void create(Player player) {
        if (player.getNickname().isEmpty()) {
            throw new ValidationException("Nickname cannot be empty");
        }
        repository.create(player);
    }

    public List<Player> getAll() {
        return repository.getAll();
    }

    public List<Player> getByTeam(int teamId) {
        return repository.getByTeamId(teamId);
    }
}
