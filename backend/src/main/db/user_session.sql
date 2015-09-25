DROP TABLE IF EXISTS user_session;

CREATE TABLE user_session (
  id bigserial PRIMARY KEY,
  user_id bigint NOT NULL REFERENCES users(user_id),
  session_id bigint NOT NULL REFERENCES sessions(session_id)
);