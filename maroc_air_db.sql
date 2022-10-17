create table admin
(
    id       serial
        constraint admin_key
            primary key,
    username varchar(100) not null,
    password varchar(100) not null
);

alter table admin
    owner to postgres;

create table clients
(
    id         serial
        constraint client_key
            primary key,
    "fullName" varchar(50) not null,
    email      varchar(50) not null,
    phone      varchar(50) not null
);

alter table clients
    owner to postgres;

create table reservations
(
    id           serial
        constraint reservation_key
            primary key,
    reference    varchar(20) not null,
    "departDate" date        not null,
    client_id    integer     not null
        constraint client_and_reservation
            references clients
            on update cascade on delete cascade
);

alter table reservations
    owner to postgres;

create table round_trip_reservations
(
    id        serial
        constraint key_name
            primary key,
    aller_id  integer not null
        constraint round_trip
            references reservations
            on update cascade on delete cascade,
    return_id integer not null
        constraint round_trip_two
            references reservations
);

alter table round_trip_reservations
    owner to postgres;

create table cities
(
    id   serial
        constraint cities_pk
            primary key,
    name varchar(50)
);

alter table cities
    owner to postgres;

create table routes
(
    id           serial
        constraint route_pk
            primary key,
    start_city   integer       not null,
    arrival_city integer       not null,
    price        numeric(7, 2) not null,
    duration     integer       not null
);

alter table routes
    owner to postgres;


create table res_routes
(
    id             serial
        constraint key_res_routes
            primary key,
    reservation_id integer not null
        constraint reservation_fk
            references reservations
            on update cascade on delete cascade,
    route_id       integer
        constraint routes_fk
            references routes
            on update cascade on delete cascade
);

alter table res_routes
    owner to postgres;


INSERT INTO public.admin (id, username, password) VALUES (DEFAULT, 'admin'::varchar(100), 'admin123'::varchar(100))