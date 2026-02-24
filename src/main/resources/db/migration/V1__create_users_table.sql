create table users (
                       id uuid primary key,
                       name varchar(120) not null,
                       email varchar(180) not null unique,
                       password_hash varchar(255) not null,
                       role varchar(30) not null,
                       created_at timestamp not null default now()
);