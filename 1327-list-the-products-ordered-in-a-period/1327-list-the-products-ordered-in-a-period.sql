# Write your MySQL query statement below
SELECT product_name, SUM(unit) unit
FROM Products p JOIN Orders o
                ON p.product_id = o.product_id
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
GROUP BY p.product_name
HAVING SUM(unit) >= 100