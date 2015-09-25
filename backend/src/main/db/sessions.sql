DROP TABLE IF EXISTS sessions;

CREATE TABLE sessions(
  session_id bigserial PRIMARY KEY,
  date date,
  user_is_win bigint REFERENCES users(user_id)
);