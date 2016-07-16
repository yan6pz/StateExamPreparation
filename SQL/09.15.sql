

SELECT *
FROM (SELECT name, address
FROM MovieStar
WHERE gender = 'F'
UNION
SELECT name, address
FROM Studio) T
WHERE T.address LIKE '%Sofia%'
ORDER BY T.address

SELECT DISTINCT name, address
FROM MovieStar
FULL JOIN Studio ON address LIKE
'%Sofia%'
WHERE gender LIKE 'F'
ORDER BY address

SELECT name, address
FROM MovieStar MS
WHERE gender = 'F'
ORDER BY address
UNION ALL
SELECT name, address
FROM Studio
WHERE address LIKE '%Sofia%'
ORDER BY address

--прави inner join по адрес и взима само съвпадащи 
SELECT MS.name, MS.address
FROM MovieStar AS MS
JOIN Studio S ON MS.address =
S.address
WHERE MS.address LIKE '%Sofia%'
AND gender = 'F'
ORDER BY MS.address

SELECT DISTINCT name, address
FROM MovieStar INTERSECT Studio
WHERE address IS NOT NULL
AND gender LIKE 'F'
GROUP BY address
HAVING address LIKE '%Sofia%'


--second
SELECT name, address, AVG(length) AS avgLength
FROM Studio
LEFT JOIN Movie ON name = studioName
WHERE NAME NOT IN (SELECT studioName
FROM Movie
WHERE inColor = 'n'
GROUP BY studioName
HAVING COUNT(*) > 3)
GROUP BY name, address

--in the heaving selects from all the movies and if there are more than 3 n it is always false
SELECT Studio.name, Studio.address, AVG(Movie.length) AS avgLength
FROM Movie
RIGHT JOIN Studio ON studioName = name
GROUP BY name, address
HAVING (SELECT COUNT(*) FROM Movie WHERE inColor = 'n') <= 3

--does not group the studio and there are many rows
SELECT DISTINCT name, address, avgLength
FROM Studio, (SELECT studioName, AVG(length) AS avgLength
FROM Movie
GROUP BY studioName) Averages
WHERE NAME = ANY (SELECT studioName
FROM Movie
WHERE inColor = 'N'
GROUP BY studioName
HAVING COUNT(title) <= 3)

--incorrect query
SELECT name, address, AVG(length) AS avgLength
FROM Studio
LEFT JOIN Movie ON name = studioName
GROUP BY studioName, address
HAVING COUNT(inColor = 'y') <= 3