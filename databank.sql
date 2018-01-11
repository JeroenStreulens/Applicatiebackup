/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Wouter Mauriën & Jeroen Streulens
 * Created: 21-nov-2017
 */


drop table AP_Groepen;
drop table AP_Voorkeur;
drop table AP_Rollen;
drop table AP_Users;

create table AP_Users(
        unr             integer not null,
        unaam           varchar(30) not null,
        upwoord         varchar(30) not null,
        bevestigd       char,
	primary key(unr)
);

create table AP_Rollen(
        rol             varchar(20),
        unr             int references AP_Users(unr),
        primary key(unr)
);

create table AP_Voorkeur(
	vsnr             int references AP_Users(unr),
	osnr             int references AP_Users(unr),
        voorkeur         char,
        primary key(vsnr,osnr)
        
);

create table AP_Groepen(
	gnr             integer not null,
        gsnr            int references AP_Users(unr),
        primary key(gnr, gsnr)
);


insert into AP_Users VALUES(0,'Wouter Maurien', '0', 'n');
insert into AP_Users VALUES(1,'Jeroen Streulens', '1', 'n');
insert into AP_Users VALUES(2, 'Matthias Wens', '2', 'n');
insert into AP_Users VALUES(3, 'Kristof De Ridder', '3', 'n');
insert into AP_Users VALUES(4,'Jari Rooman', '4', 'n');
insert into AP_Users VALUES(5,'Nick Todts', '5', 'n');
insert into AP_Users VALUES(6, 'Kevin Todts', '6', 'n');
insert into AP_Users VALUES(7, 'Wouter Raes', '7', 'n');
insert into AP_Users VALUES(8,'Jente Heremans', '8', 'n');
insert into AP_Users VALUES(9,'Toon Blommaerts', '9', 'n');
insert into AP_Users VALUES(10, 'Pieterjan Peetermans', '10', 'n');
insert into AP_Users VALUES(11, 'Jelle Meeus', '11', 'n');
insert into AP_Users VALUES (20,'Herman Crauwels','20', 'n');
insert into AP_Users VALUES (21,'Joost Vennekens','21', 'n');
insert into AP_Users VALUES (22,'An Van Haperen','22', 'n');
insert into AP_Users VALUES (23,'Ann Philips','23', 'n');
insert into AP_Rollen VALUES('student', 0);
insert into AP_Rollen VALUES('student', 1);
insert into AP_Rollen VALUES('student', 2);
insert into AP_Rollen VALUES('student', 3);
insert into AP_Rollen VALUES('student', 4);
insert into AP_Rollen VALUES('student', 5);
insert into AP_Rollen VALUES('student', 6);
insert into AP_Rollen VALUES('student', 7);
insert into AP_Rollen VALUES('student', 8);
insert into AP_Rollen VALUES('student', 9);
insert into AP_Rollen VALUES('student', 10);
insert into AP_Rollen VALUES('student', 11);
insert into AP_Rollen VALUES('docent', 20);
insert into AP_Rollen VALUES('docent', 21);
insert into AP_Rollen VALUES('docent', 22);
insert into AP_Rollen VALUES('docent', 23);



