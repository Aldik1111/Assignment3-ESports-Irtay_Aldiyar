package controller;

import model.Tournament;
import service.TournamentService;
import exception.*;


public class TournamentController {

    private final TournamentService service = new TournamentService();

    public void create(Tournament tournament) {
        try {
            service.create(tournament);
            System.out.println("<=======================>");
            System.out.println("Tournament " + tournament.getName() + " created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
