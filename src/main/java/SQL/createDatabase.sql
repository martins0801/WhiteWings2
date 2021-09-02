DROP database if exists Pasticceria;
CREATE Database Pasticceria;
use Pasticceria;


create table Utente(
                       email char(40) primary key,
                       Username char (16) not null,
                       Psword  char (16) not null,
                       IfAdmin boolean not null,
                       Nome char(20) not null,
                       Via char(30) not null,
                       Cap char(7) not null,
                       Citta char(20) not null,
                       telefono char (13) not null
);

create table Tipologia(
                          id int (10)  primary key,
                          tipologia char(20) not null
);

create table Dolci(
                      Cod int(6) primary key,
                      Descrizione Text(500) not null,
                      Nome char (50) not null,
                      Tcottura char(4),
                      Tconservazione char(4),
                      Prezzokg  DEC(5,2) not null,
                      Peso DEC(5,2) not null,
                      idTipologia int(10) not null,
                      foreign key (idTipologia) references tipologia(id)
                          on delete cascade
                          on update cascade
);



create table Ordine(
                       idOrdine int not null,
                       quantita int not null, /* num tot di articoli */
                       email char(40) not null,
                       dataOrdine date not null,
                       primary key(idOrdine),
                       foreign key (email) references Utente(email)
                           on delete cascade
                           on update cascade
);

create table OrdineDolci(
                            idOrdine int not null,
                            codice int(6) not null,
                            quantita int not null,
                            primary key (idOrdine,codice),
                            foreign key (idOrdine) references Ordine(idOrdine)
                                on delete cascade
                                on update cascade,
                            foreign key (codice) references Dolci(cod)
                                on delete cascade
                                on update cascade
);


