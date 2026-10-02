# Write your MySQL query statement below
SELECT DISTINCT r1.num AS ConsecutiveNums
FROM Logs r1
JOIN Logs r2
   ON r1.id=r2.id-1
JOIN Logs r3
   ON r2.id=r3.id-1
WHERE r1.num=r2.num
  AND r2.num=r3.num;