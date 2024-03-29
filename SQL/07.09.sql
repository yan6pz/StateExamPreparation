/****** Script for SelectTopNRows command from SSMS  ******/
select country
from classes
where numguns>10
Union
select country
from classes
where numguns<6


--second

Select distinct country, count(o.battle) as Num
from classes c
left join ships s on c.class=s.class
left join outcomes o on s.name=o.ship
group by country
having count(o.battle)<3

Select country, count(o.battle) as Num
from classes c
inner join ships s on c.class=s.class
left join outcomes o on s.name=o.ship
where count(o.battle)<=2

select country,count(distinct battle) num
from outcomes 
join ships on name=ship
right join classes on classes.class=ships.class
group by country
having count(distinct battle)<=2


Select country, count( distinct o.battle) as Num
from classes c,ships s,outcomes o
where c.class=s.class
and s.name=o.ship
group by country
having count(distinct o.battle)<3