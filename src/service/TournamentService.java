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

    public List<Tournament> getAll() {
        return repository.getAll();
    }

    public Tournament getbyId(int id) {
        return repository.getById(id);
    }

    public void update(int id, Tournament tournament) {
        repository.update(id, tournament);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
