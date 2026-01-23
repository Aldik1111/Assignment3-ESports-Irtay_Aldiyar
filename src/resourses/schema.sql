create table games (
    id int primary key,
    name varchar(100) not null,
    genre varchar(20) not null,
    team_size int not null
);

create table teams(
    id int primary key,
    name varchar(100) not null unique
);

create table players(
    id int primary key,
    nickname varchar(100) not null,
    rank int,
    team_id int,
    foreign key (team_id) references teams(id)
);

create table tournaments (
    id int primary key,
    name varchar(100) not null,
    game_id int not null,
    foreign key (game_id) references games(id)
);

create table matches(
    id int primary key,
    tournament_id int not null,
    team1_id int not null,
    team2_id int not null,
    score1 int default(0),
    score2 int default( 0),
    foreign key (tournament_id) references tournaments(id),
    foreign key (team1_id, team2_id) references teams(id),
    check ( team1_id <> team2_id )
);

