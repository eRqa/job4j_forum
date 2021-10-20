create table posts (
                       id serial primary key,
                       name varchar(2000),
                       desc text,
                       created timestamp without time zone not null default now()
);