package model;

public class Player {
    private int id;
    private String nickname;
    private int age;
    private int rank;

    public Player(int id, String nickname, int age, int rank) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.rank = rank;
    }

    public String getNickname() { return nickname; }
    public int getAge() { return age; }
    public int getRank() { return rank; }

    @Override
    public String toString() {
        return '\n' + nickname + ", " + age + ", " + rank;
    }


}

