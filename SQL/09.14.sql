select distinct ships.name
from battles,ships
where launched=year(date)

select name 
from ships
where launched=any(
select year(date) 
from battles
where count(*)>=1)


select distinct name
from battles
join ships
on launched=year(date)


select name
from battles
where exists(select distinct *
from ships
where year(date)=launched)


--second

select country, count(result)
from classes c
left join ships s
on c.class=s.class
left join outcomes o
on s.name=o.ship
where o.result='sunk'
group by country
having count(ship)<=3

select distinct classes.country,
sunk
from classes
right join (select country,count(*) as sunk
from classes c
join ships s
on c.class=s.class
join outcomes o
on s.name=o.ship
where result='sunk'
group by country) sunkk
on classes.country=sunkk.country
where sunk<=3

select country,
count(result) as sunk
from ships s
join outcomes o on s.name=o.SHIP
right join classes c
on s.class=c.class
where count(*)<=3
group by country,count(result)


select country,
count(result is 'sunk')
from ships,classes,outcomes
where count(ship)<=3
or ship is null

