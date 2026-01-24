package controller;

import model.Tournament;
import service.TournamentService;

import java.util.List;

public class TournamentController {

    private final TournamentService service = new TournamentService();

    public void create(Tournament tournament) {
        service.create(tournament);
        System.out.println("Tournament created: " + tournament.getName());
    }

    public void getAll() {
        List<Tournament> tournaments = service.getAll();
        if (tournaments.isEmpty()) {
            System.out.println("No tournaments found.");
            return;
        }
        tournaments.forEach(t ->
                System.out.println(
                        t.getId() + " | " +
                                t.getName() + " | Game: " +
                                t.getGame().getName()
                )
        );
    }

    public void getById(int id) {
        Tournament t = service.getbyId(id);
        if (t == null) {
            System.out.println("Tournament not found.");
            return;
        }
        System.out.println(
                t.getId() + " | " +
                        t.getName() + " | Game: " +
                        t.getGame().getName()
        );
    }

    public void update(int id, Tournament tournament) {
        service.update(id, tournament);
        System.out.println("Tournament updated.");
    }

    public void delete(int id) {
        service.delete(id);
        System.out.println("Tournament deleted.");
    }
}
