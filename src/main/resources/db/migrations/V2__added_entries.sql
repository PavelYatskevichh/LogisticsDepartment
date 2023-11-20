insert into application_status(status_name)
values
    ('PROCESSING'),
    ('WAITING_FOR_LOADING'),
    ('ON_THE_WAY'),
    ('DELIVERED');

insert into role(role_name)
values
    ('CUSTOMER'),
    ('MANAGER'),
    ('DRIVER');

insert into category(category_name)
values
    ('AM'),
    ('B'),
    ('BE'),
    ('C'),
    ('CE');
