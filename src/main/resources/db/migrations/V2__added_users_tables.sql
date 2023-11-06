create table user_role (
    id integer auto_increment not null,
    role_name varchar(64) not null,
    primary key (id),
    unique (role_name)
);

create table user(
	id integer auto_increment not null,
	user_role_id integer not null,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    email_address varchar(255) not null,
    phone_number varchar(15) not null,
    primary key (id),
    foreign key (user_role_id) references user_role(id)
);

alter table route
drop foreign key route_ibfk_1,
add foreign key (driver_id) references user(id),
add manager_id integer not null,
add foreign key (manager_id) references user(id);

alter table drivers_category
drop foreign key drivers_category_ibfk_1,
add foreign key (driver_id) references user(id);

alter table application
add customer_id integer not null,
add foreign key (customer_id) references user(id);

drop table driver;

