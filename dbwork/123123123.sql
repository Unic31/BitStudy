create table user (
	unum smallint primary key,
    uname varchar(10),
    age smallint,
    gender varchar(10),
    eamail varchar(10),
    pass varchar(10),
    hp smallint,
    city1 varchar(10),
    city2 varchar(10),
    mnum smallint,
    joinday datetime,
    jjim smallint,
    uphoto varchar(50)
);

create table moim (
	mnum smallint primary key,
    mname varchar(10),
    jang varchar(10),
    unum smallint,
    mphoto varchar(50),
    city1 varchar(10),
    city2 varchar(10),
    category varchar(10),
    mcontent varchar(500),
    createday datetime,
    jjim smallint,
    private varchar(10)  
);
create table city_board (
	cbnum smallint primary key,
    subject varchar(10),
    uname smallint,
    cbcontent varchar(500),
    cbphoto varchar(10),
    readcount smallint,
    cbwriteday smallint,
    city1 varchar(10),
    city2 varchar(10),
    cblike smallint
);
create table cb_reboard (
	renum smallint primary key,
    unum smallint,
    recontent varchar(500),
    cbwriteday datetime,
    ref smallint,
    step smallint,
    depth smallint
);
