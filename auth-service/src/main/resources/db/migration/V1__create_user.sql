CREATE TABLE public.app_user
(
    name varchar(100) PRIMARY KEY,
    password varchar(100) NOT NULL,
    role varchar(100) NOT NULL
);