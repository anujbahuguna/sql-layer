SELECT sku FROM customers 
 INNER JOIN orders ON customers.cid = orders.cid
 INNER JOIN items ON orders.oid = items.oid
  WHERE name = 'Smith'
  ORDER BY sku