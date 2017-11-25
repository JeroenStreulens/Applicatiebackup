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
        suaam           varchar(30) not null,
        upwoord         varchar(30) not null,
        bevestigd       char,
	primary key(unr)
);

create table AP_Rollen(
        rol             varchar(20),
        rnr             int references AP_Users(unr),
        primary key(rnr)
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


insert into AP_Users VALUES(0,'Wouter Mauriën', 'qwerty', 'n');
insert into AP_Users VALUES(1,'Jeroen Streulens', 'azerty', 'n');
insert into AP_Users VALUES(2, 'Mathias Wens', 'ikkomuitdekast', 'n');
insert into AP_Users VALUES (3,'Den Herman','unix', null);
insert into AP_Users VALUES (4,'Dessie','sponzenridder', null);