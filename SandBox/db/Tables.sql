create table public.brand
(
    brand_id   integer not null
        primary key,
    brand_name varchar(255)
);

alter table public.brand
    owner to postgres;

create table public.model
(
    model_id   integer not null
        primary key,
    model_name varchar(255)
);

alter table public.model
    owner to postgres;


create table public.generation
(
    generation_id   integer not null
        primary key,
    generation_name varchar(255)
);

alter table public.generation
    owner to postgres;


create table public.brand_models
(
    brand_brand_id  integer not null
        constraint fkjb3b2y2a7q2vvrk77shfvydal
            references public.brand,
    models_model_id integer not null
        constraint uk_7o4jybe36w0pmgtv9rw87ehti
            unique
        constraint fk9nea5knrfo2h7qyxxtooafcp7
            references public.model,
    primary key (brand_brand_id, models_model_id)
);

alter table public.brand_models
    owner to postgres;

create table public.model_generations
(
    model_model_id            integer not null
        constraint fke0alyvvf6h9flunntug5xksc7
            references public.model,
    generations_generation_id integer not null
        constraint uk_hk7nbskhyal3c3mjo6f65hd8a
            unique
        constraint fks3596n5tbt3ohuflgjoac0s4l
            references public.generation,
    primary key (model_model_id, generations_generation_id)
);

alter table public.model_generations
    owner to postgres;
