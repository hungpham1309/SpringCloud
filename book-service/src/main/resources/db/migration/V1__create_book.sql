CREATE TABLE public.book
(
    id SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(100) NOT NULL
);