package service;

import exception.*;
import model.Match;
import repository.MatchRepository;

import java.util.List;

public class MatchService {
    private final MatchRepository repository = new MatchRepository();

    public void create(Match match) {
        if(match.getTeam1Id() == match.getTeam2Id()) {
            throw new ValidationException("Teams must be different");
        }
        repository.create(match);
    }
    public List<Match> getAll() {
        return repository.getAll();
    }

    public Match getById(int id) {
        return repository.getById(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
