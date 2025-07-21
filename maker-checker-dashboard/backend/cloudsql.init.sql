CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  product_code VARCHAR(50),
  rate_of_intrest DECIMAL(5,2)
  effective_from_date DATE,
  effective_to_date DATE,
  is_active BOOLEAN
);

CREATE TABLE approval (
  id SERIAL PRIMARY KEY,
  product_id INTEGER REFERENCES product(id),
  user_id INTEGER,
  checker_id INTEGER,
  status VARCHAR(20),
  comments TEXT
);
