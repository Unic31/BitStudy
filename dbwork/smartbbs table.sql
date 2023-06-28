create table smartbbs (
	num smallint auto_increment primary key,
    writer varchar(20),
    subject varchar(300),
    content varchar(4000),
    readcount smallint default 0,
    likes int default 0,
    writeday datetime default now()
);