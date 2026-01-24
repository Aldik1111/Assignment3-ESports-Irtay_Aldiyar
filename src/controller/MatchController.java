package controller;

import model.Match;
import model.Team;
import model.Tournament;
import service.MatchService;
import service.TeamService;
import service.TournamentService;
import exception.ApplicationException;

import java.util.List;

public class MatchController {
    private final MatchService service = new MatchService();
    private final TeamService teamService = new TeamService();
    private final TournamentService tournamentService = new TournamentService();

    // Create a match
    public void create(Match match) {
        try {
            service.create(match);
            System.out.println("<=======================>");
            System.out.println("Match " + match.getId() + " created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Get all matches
    public void getAll() {
        List<Match> matches = service.getAll();
        if (matches.isEmpty()) {
            System.out.println("No matches found.");
            return;
        }

        for (Match m : matches) {
            Team team1 = teamService.getById(m.getTeam1Id());
            Team team2 = teamService.getById(m.getTeam2Id());
            Tournament tournament = tournamentService.getbyId(m.getTournamentId());

            System.out.println(
                    "Match " + m.getId() + ": " +
                            (team1 != null ? team1.getName() : "Unknown Team1") + " vs " +
                            (team2 != null ? team2.getName() : "Unknown Team2") +
                            " | Tournament: " +
                            (tournament != null ? tournament.getName() : "Unknown Tournament")
            );
        }
    }

    // Get match by ID
    public void getById(int id) {
        Match m = service.getById(id);
        if (m == null) {
            System.out.println("Match not found.");
            return;
        }

        Team team1 = teamService.getById(m.getTeam1Id());
        Team team2 = teamService.getById(m.getTeam2Id());

        System.out.println(
                "Match " + m.getId() + ": " +
                        (team1 != null ? team1.getName() : "Unknown Team1") + " vs " +
                        (team2 != null ? team2.getName() : "Unknown Team2")
        );
    }

    // Delete match
    public void delete(int id) {
        try {
            service.delete(id);
            System.out.println("Match deleted.");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
