package service;

import exception.*;
import model.Match;
import repository.MatchRepository;

public class MatchService {
    private final MatchRepository repository = new MatchRepository();

    public void create(Match match) {
        if(match.getTeam1Id() == match.getTeam2Id()) {
            throw new ValidationException("Teams must be different");
        }
        repository.create(match);
    }
}
