CREATE TABLE IF NOT EXISTS role (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Role_type varchar(20)
);

CREATE TABLE IF NOT EXISTS user (
    Passport_No varchar(14) PRIMARY KEY NOT NULL,
    Name varchar(100),
    Surname varchar(100),
    Birth_date date,
    Role_Id int NOT NULL,
    Phone varchar(20),
    Email varchar(100),
    Password varchar(30),
    FOREIGN KEY (Role_Id) REFERENCES role (ID) ON DELETE cascade
);

CREATE TABLE IF NOT EXISTS fine (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Amount decimal,
    Paid boolean
);

CREATE TABLE IF NOT EXISTS book (
    ISBN varchar(13) PRIMARY KEY NOT NULL,
    Name varchar(1024),
    Publishing_date date,
    Price decimal,
    In_stock boolean
);

CREATE TABLE IF NOT EXISTS author (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name varchar(50),
    Surname varchar(50),
    Place_of_birth varchar(50),
    Birth_date date
);

CREATE TABLE IF NOT EXISTS book_author (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Book_ISBN varchar(13),
    Author_Id int,
    FOREIGN KEY (Author_Id) REFERENCES author (ID) ON DELETE cascade,
    FOREIGN KEY (Book_ISBN) REFERENCES book (ISBN) ON DELETE cascade
);
CREATE TABLE IF NOT EXISTS bin (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Floor int,
    Room int,
    Bin_No int
);

CREATE TABLE IF NOT EXISTS book_movement (
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    User_Id varchar(14),
    Book_ISBN varchar(13),
    Bin_Id int,
    Quantity int,
    Issue_date date,
    Returned_date date,
    Real_returned_date date,
    Returned boolean,
    Expired boolean,
    Fine_Id integer UNIQUE,
    FOREIGN KEY (User_Id) REFERENCES user (Passport_No),
    FOREIGN KEY (Book_ISBN) REFERENCES book (ISBN),
    FOREIGN KEY (Bin_Id) REFERENCES bin (ID),
    FOREIGN KEY (Fine_Id) REFERENCES fine (ID)
);
insert into author (id, Name, Surname, Place_of_birth, Birth_date)
values
#     'Inferno'
#     'The Divine Comedy'
(1, 'Dan', 'Brown', 'Exeter', {d '1964-06-22'}),
(2,'Dante','Alighieri','Florence',{d '1265-05-21'});

insert into book (ISBN, Name, Publishing_date, Price, In_stock)
values
#     'Inferno'
#     'The Divine Comedy'
('978-140007915', 'Inferno', {d '2013-05-14'}, 10, true),
('978-045120863','The Divine Comedy',{d '2003-05-27'}, 14, true);

insert into role (id, Role_type)
values
#     'Inferno'
#     'The Divine Comedy'
(1, 'admin'),
(2,'user');

insert into user (Passport_No, Name, Surname, Birth_date, Role_Id, Phone, Email, Password)
values
#     'Inferno'
#     'The Divine Comedy'
('MP2316484', 'Ivan', 'Ivanov', {d '1964-06-22'}, 1, 375291237694, 'abc@mail.ru', '123Cr'),
('MP6546484','Pavel','Petrov',{d '1999-05-21'}, 2, 375447691242, 'abcd@mail.ru', '987Cr');

insert into fine (ID, Amount, Paid)
values
(1, 20, true),
(2, 15, false);

insert into bin(ID, Floor, Room, Bin_No)
VALUES
(1, 4, 2, 4585),
(2, 5, 3, 6543);

insert into book_movement (ID, User_Id, Book_ISBN, Bin_Id, Quantity, Issue_date, Returned_date, Real_returned_date, Returned, Expired, Fine_Id)
VALUES
(1, 'MP2316484', '978-140007915', 1, 1, {d '2021-06-22'}, {d '2021-06-30'}, {d '2021-07-02'}, true, true, 2),
(2, 'MP6546484', '978-045120863', 2, 3, {d '2021-06-15'}, {d '2021-06-25'}, {d '2021-07-24'}, true, false, 1);

insert into book_author(ID, Book_ISBN, Author_Id)
VALUES
(1, '978-140007915', 1),
(2, '978-045120863', 2);