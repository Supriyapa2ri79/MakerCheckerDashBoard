CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  product_code VARCHAR(50),
  product_name VARCHAR(50) NOT NULL,
  rate_of_intrest DECIMAL(5,2)
  effective_from_date DATE,
  effective_to_date DATE,
  is_active BOOLEAN,
  user_id VARCHAR(50),
  user_role VARCHAR(50)
);

CREATE TABLE approval (
  id SERIAL PRIMARY KEY,
  product_id INTEGER REFERENCES product(id),
  user_id VARCHAR(50),
  user_role VARCHAR(50),
  status VARCHAR(20),
  comments TEXT
);

CREATE TABLE user(
  user_id VARCHAR(50) NOT NULL PRIMARY KEY,
  user_name VARCHAR(50) NOT NULL,
  user_pwd VARCHAR(50) NOT NULL,
  user_role VARCHAR(50) NOT NULL
);
