

select distinct maker 
from product
where product.type='PC'
and maker in (select maker from product
join laptop on product.model=laptop.model)

select distinct maker
from product
where type='PC'
or type='Laptop'

select maker
from product 
where type='PC'
union
select maker
from product
where type='Laptop'


select maker 
from product p1
cross join product p2
where p1.maker=p2.maker
and p1.type='PC'
and p2.type='Laptop'
group by maker

--second
select l.code,l.model,l.screen,maker
from laptop l
join product p
on l.model=p.model
where maker  not in (select maker
from product where type='Printer'
group by maker
having count(*)>3)

select l.code,l.model,l.screen,maker
from laptop l
join product p
on l.model=p.model
where maker in (select maker
from product where type='Printer'
group by maker
having count(*)<=3)



