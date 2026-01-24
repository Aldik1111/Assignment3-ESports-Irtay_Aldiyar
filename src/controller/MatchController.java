package controller;

import model.Match;
import service.MatchService;
import exception.*;

public class MatchController {
    private final MatchService service = new MatchService();

    public void create(Match match) {
        try {
            service.create(match);
            System.out.println("<=======================>");
            System.out.println("Match "+ match.getId() + " created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
