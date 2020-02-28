CREATE DATABASE xa_order DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use xa_order;
create table if not exists xa_order.t_order
(
    id          bigint auto_increment
        primary key,
    total_amout decimal(10, 2) null,
    status      int            null,
    user_id     bigint         null
);

CREATE DATABASE xa_user DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use xa_user;
create table if not exists xa_user.t_user
(
    id       bigint unsigned auto_increment
        primary key,
    username varchar(50) null,
    constraint id
        unique (id)
);


