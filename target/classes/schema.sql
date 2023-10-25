CREATE TABLE prices (
  id INT,
  product_id INT,
  brand_id INT,
  start_date VARCHAR(25),
  end_date VARCHAR(25),
  price_list INT,
  priority INT,
  price decimal(4,2),
  curr VARCHAR(3)
);