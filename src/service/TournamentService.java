package service;

import model.Tournament;
import repository.TournamentRepository;

import java.util.List;
import java.util.Optional;

public class TournamentService {

    private final TournamentRepository tournamentRepository = new TournamentRepository();

    public void createTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public Optional<Tournament> getTournamentById(int id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public void updateTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public void deleteTournament(int id) {
        tournamentRepository.deleteById(id);
    }
}
