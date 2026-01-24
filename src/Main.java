import model.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        TeamController teamController = new TeamController();
        TournamentController tournamentController = new TournamentController();
        GameController gameController = new GameController();
        MatchController matchController = new MatchController();

        System.out.println("<=======================>");
        System.out.println("Starting Esports Application");
        System.out.println("<=======================>");

        // ---- CREATE GAMES ----
        Game dota = new Moba(1, "Dota 2");
        Game cs2 = new Fps(2, "CS2");

        gameController.create(dota);
        gameController.create(cs2);

        System.out.println("\nAll games in the system:");
        gameController.getAll();

        // ---- CREATE TEAMS ----
        Team alpha = new Team(1, "Team Alpha");
        Team beta = new Team(2, "Team Beta");
        Team gamma = new Team(3, "Team Gamma");

        teamController.createTeam(alpha);
        teamController.createTeam(beta);
        teamController.createTeam(gamma);

        System.out.println("\nAll teams in the system:");
        teamController.listTeams(null);

        // ---- CREATE TOURNAMENTS ----
        Tournament spring_2026_dota = new Tournament(1, "Spring Esports Cup", dota);
        Tournament summer_2026_cs2 = new Tournament(2, "Summer Showdown", cs2);

        tournamentController.create(spring_2026_dota);
        tournamentController.create(summer_2026_cs2);

        System.out.println("\nAll tournaments in the system:");
        tournamentController.getAll();

        // ---- CREATE MATCHES ----
        Match match1 = new Match(1, alpha, beta, spring_2026_dota, 0, 0);
        Match match2 = new Match(2, beta, gamma, summer_2026_cs2, 0, 0);

        matchController.create(match1);
        matchController.create(match2);

        System.out.println("\nAll matches in the system:");
        matchController.getAll();

        // ---- GET SPECIFIC TEAM AND GAME ----
        System.out.println("\nGet team by ID 2:");
        teamController.teamById(2);

        System.out.println("\nGet game by ID 1:");
        gameController.getById(1);

        System.out.println("\nGet tournament by ID 2:");
        tournamentController.getById(2);

        System.out.println("\nGet match by ID 1:");
        matchController.getById(1);

        // ---- UPDATE EXAMPLE ----
        System.out.println("\nUpdating team 3 name to 'Team Delta'...");
        gamma.setName("Team Delta");
        teamController.createTeam(gamma);
        teamController.listTeams(null);

        // ---- DELETE EXAMPLE ----
        System.out.println("\nDeleting match 2...");
        matchController.delete(2);
        System.out.println("Matches after deletion:");
        matchController.getAll();

        System.out.println("<=======================>");
        System.out.println("Application finished successfully.");
        System.out.println("<=======================>");
    }
}
