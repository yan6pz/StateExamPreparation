
create table Teams(
tname varchar(20) primary key,
tccountry char(3) not null,
numtf int check(numtf>0 ),
numstf int check(numstf>0),
numyj int check(numyj>0)

)
create table Stages(
snumber /*unsigned*/ int check(snumber>0) primary key,
sdate date not null,
km decimal check(km>0) not null,
scity varchar(30) not null,
ecity varchar(30) not null
)
create table Riders(
rname varchar(50) primary key,
rnum int check(rnum>0) not null,
birthdate date not null,
height int check(height>0) not null,
weidth float check(weidth>0) not null,
rcountry character(3) not null,
rcity varchar(20) not null,
tname varchar(20) foreign key references Teams(tname) not null
)

create table Tour(
id int check(id>0) primary key,
snumber int check(snumber>0) foreign key references Stages(snumber) not null,
rname varchar(50) foreign key references Riders(rname) not null,
place int check(place>0) not null,
points int not null ,
ttime time not null,
white bit not null,
yellow bit not null,
green bit not null
)
