package service;

import exception.*;
import model.Tournament;
import repository.TournamentRepository;

import java.util.List;

public class TournamentService {
    private final TournamentRepository repository = new TournamentRepository();

    public void create(Tournament tournament) {
        if( tournament.getName().isEmpty()) {
            throw new ValidationException("Tournament name cannot be empty");
        }
        repository.create(tournament);
    }
}
