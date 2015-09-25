DROP TABLE IF EXISTS users;

CREATE TABLE users(
  user_id bigserial PRIMARY KEY,
  login text,
  password text,
  email text
);