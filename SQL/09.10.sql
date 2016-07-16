select name 
from moviestar 
where name not in 
(select distinct starname
from starsin
where movieyear >1970)

select distinct name
from moviestar
left join starsin
on name=starname
where movieyear<=1970

select distinct name
from moviestar
join starsin
on name=starname
where movieyear>1970
group by name
having count(*)=0

select m.name
from moviestar m
where exists
(select 1
from starsin s
where s.starname=m.name and s.movieyear<=1970)

--second

select name,min(movieyear-year(birthdate)) as debut
from starsin
 join moviestar on starname=name
group by name

select name,min(movieyear)-year(birthdate) as debut
from moviestar
 join starsin on name=starname
group by name

select name,movieyear-year(birthdate) as debut
from moviestar
left join starsin on name=starname
where movieyear is not null
group by name
having min(movieyear)


select distinct ms.name,movieyear-year(birthdate) as debut
from moviestar ms,starsin
having ms.name=starname
and movieyear<=all(select movieyear from starsin si where si.starname=ms.name)



