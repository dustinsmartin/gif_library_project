drop table user;
create table UserDB
(
userName varchar(25) primary key not null,
emailAddress  varchar(40) not null,
password varchar(12) not null
);

insert into UserDB values('bobstar', 'bobstar12@gmail.com', 'google123');
insert into UserDB values('halecode', 'halecode24@gmail.com', 'hell1234');
insert into UserDB values('yikecar', 'yikecar54@gmail.com', 'infosys45');
insert into UserDB values('pdiddy', 'pdiddy87@gmail.com', 'openroad23');

select * from UserDB;

Create table GIFLibrary 
(
GIFUrl varchar(255) primary key not null,
tag varchar(255) not null,
userName varchar(25) not null references UserDB(userName)
);

Insert into GIFLibrary values('https://media.giphy.com/media/l0IyayMlfXiWKTJCM/giphy.gif', '#Dog : #Person : #McDonalds : #Fries : #Awesome : #Funny', 'bobstar');
Insert into GIFLibrary values('https://i.giphy.com/media/26gYQxhqVfR2zYuYM/source.gif', '#workaholics : #funny : #lol', 'halecode');
Insert into GIFLibrary values('https://media1.tenor.com/images/b5a9f1e9bf32dcb5d338c3fadead5e3e/tenor.gif', '#dancing : #kid : #weird', 'yikecar');
Insert into GIFLibrary values('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCRnkpFudEsAmOHnLpfSKFafUhVRXOL_UK8ZbepxD4hDqtpVL-Ng', '#michaeljordan : #cat : #humancat : #ballercat', 'pdiddy');

select * from GIFLibrary;