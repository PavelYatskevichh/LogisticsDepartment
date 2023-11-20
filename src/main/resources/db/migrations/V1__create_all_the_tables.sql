create table address(
	id integer auto_increment not null,
    city varchar(64) not null,
    street varchar(64) not null,
    building varchar(64) not null,
    primary key (id)
);

create table application_status(
	id integer auto_increment not null,
    status_name varchar(64) not null,
    primary key (id),
    unique (status_name)
);

create table category(
	id integer auto_increment not null,
    category_name varchar(2) not null,
    primary key (id),
    unique (category_name)
);

create table role(
    id integer auto_increment not null,
    role_name varchar(64) not null,
    primary key (id),
    unique (role_name)
);

create table user(
	id integer auto_increment not null,
	role_id integer not null,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    email_address varchar(255) not null,
    phone_number varchar(15) not null,
    password varchar(255) not null,
    primary key (id),
    foreign key (role_id) references role(id)
);

create table drivers_category(
	id integer auto_increment not null,
    driver_id integer not null,
    category_id integer not null,
    primary key (id),
    foreign key (driver_id) references user(id),
    foreign key (category_id) references category(id)
);

create table vehicle(
	id integer auto_increment not null,
	vehicle_name varchar(64) not null,
    max_load_capacity integer not null,
    max_trip_distance integer not null,
    dim_X_restriction integer not null,
    dim_Y_restriction integer not null,
    dim_Z_restriction integer not null,
    required_category_id integer not null,
    primary key (id),
    foreign key (required_category_id) references category(id)
);

create table route(
	id integer auto_increment not null,
    driver_id integer not null,
    vehicle_id integer not null,
    manager_id integer not null,
    primary key (id),
    foreign key (driver_id) references user(id),
    foreign key (vehicle_id) references vehicle(id),
    foreign key (manager_id) references user(id)
);

create table application(
	id integer auto_increment not null,
    route_id integer not null,
    loading_address_id integer not null,
    unloading_address_id integer not null,
    customer_id integer not null,
    status_id integer not null,
    primary key (id),
    foreign key (route_id) references route(id),
    foreign key (loading_address_id) references address(id),
    foreign key (unloading_address_id) references address(id),
    foreign key (customer_id) references user(id),
    foreign key (status_id) references application_status(id)
);

create table item(
	id integer auto_increment not null,
	application_id integer not null,
    weight integer not null,
    dim_X integer not null,
    dim_Y integer not null,
    dim_Z integer not null,
    primary key (id),
    foreign key (application_id) references application(id)
);