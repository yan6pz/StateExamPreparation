Create table Groups(
gname char(1) primary key,
fplace varchar(20) ,
 splace varchar(20) 
 );


 Create table Teams(
country varchar(20) primary key,
gname char(1) foreign key references Groups(gname),
num_wc int check(num_wc>0)
 )

 ALTER TABLE Groups
ADD FOREIGN KEY (fplace)
REFERENCES Teams(country)

ALTER TABLE Groups
ADD FOREIGN KEY (splace)
REFERENCES Teams(country)

 Create table Players(
pname varchar(50) primary key,
team varchar(20) foreign key references Teams(country),
 num_player int check(num_player>1 and num_player<22),
 num_goals int check(num_goals>0)
 )

 Create table Matches(
mnumber int check(mnumber>0) primary key,
tstage varchar(8),
 stage CHARACTER(3) null,
 team_host varchar(20) foreign key REFERENCES Teams(country),
 team_guest varchar(20) foreign key REFERENCES Teams(country),
 result char(1),
 scores CHARACTER(5),
 [date] date,
 [time] time
 )

 ALTER TABLE GROUPS ADD FOREIGN KEY(splace) references Teams(country)