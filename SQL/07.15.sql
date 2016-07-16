--пресичане на тези с цветни и не на а с тези с нецветни
SELECT starName
FROM StarsIn
JOIN Movie ON movieTitle =
title AND movieYear = year
WHERE starName NOT LIKE '%a' AND inColor = 'y'
INTERSECT
SELECT starName
FROM StarsIn
JOIN Movie ON movieTitle = title AND movieYear = year
WHERE inColor = 'n';

--подзаявката връща няколко стойности и не може да сравняваме с = а с in
SELECT DISTINCT starName
FROM StarsIn
INNER JOIN Movie ON movieTitle = title AND movieYear = year
WHERE starName NOT LIKE '%a' AND inColor = 'y'
AND starName = (SELECT starName 
FROM StarsIn, Movie
WHERE inColor = 'n')


--second

SELECT name, YEAR(birthdate), COUNT(DISTINCT studioName)
FROM MovieStar
LEFT OUTER JOIN StarsIn ON name = starname
LEFT JOIN Movie ON movieTitle = title AND movieYear = year
GROUP BY name,birthdate
HAVING COUNT(title) <= 5

--името се взима от старсин а може да нямаме записи там и да върне нъл
SELECT             StarsIn.starname,             YEAR(birthdate), 
COUNT(DISTINCT studioName)
FROM Movie
JOIN StarsIn ON movieTitle = title AND movieYear = year
RIGHT OUTER JOIN MovieStar ON MovieStar.name = StarsIn.starname
GROUP BY StarsIn.starname,birthdate
HAVING COUNT(DISTINCT title) <= 5;


SELECT DISTINCT name, birthdate.year, COUNT(studioName)
FROM MovieStar, StarsIn, Movie
WHERE name = starname AND 
((movieTitle  =  title  AND  movieYear  =  year)  OR  title  IS 
NULL)
GROUP BY name, birthdate.year
HAVING COUNT(title) <
= 5;

SELECT name, year(birthdate), COUNT(SELECT DISTINCT studioName
FROM Movie
JOIN StarsIn ON title = movieTitle AND year = movieYear
WHERE starname = name)
FROM MovieStar
HAVING COUNT(SELECT * FROM StarsIn WHERE starname = name) <=5
ORDER BY name, year(birthdate);


