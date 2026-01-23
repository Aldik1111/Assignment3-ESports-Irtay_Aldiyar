package model;

import model.interfaces.IScorable;

public class Match implements IScorable {
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;
    private Team winner;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void playMatch() {
        setScore((int)(Math.random()*10), (int)(Math.random()*10));
    } // give random score

    public void setScore(int score1, int score2){ // set score
        this.score1 = score1;
        this.score2 = score2;
    }

    public Team getWinner() { // Get winner
        if(score1>score2){winner=team1;}
        else if (score1<score1){winner=team2;}
        else{winner = null;}
        return winner;
    }

    public String getResult() {
        getWinner();
        return team1.getName() + " " + score1 + " : " + score2 + " " + team2.getName();
    }

    @Override
    public String toString() {
        return team1.getName() + " VS " + team2.getName() +
                ". Winner: " + (winner != null ? winner.getName() : "Draw");
    }
}
