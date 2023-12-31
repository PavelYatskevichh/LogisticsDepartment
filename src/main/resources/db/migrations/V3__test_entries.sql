insert into user(role_id, first_name, last_name, email_address, phone_number, password)
values
    (2, 'Куприянов', 'Алексей', 'ka@velogist.com', "+375291234561", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (2, 'Джон', 'Доу', 'jd@velogist.com', "+375291234562", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (3, 'Вин', 'Дизель', 'vd@velogist.com', "+375291234563", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (3, 'Фрэнк', 'Мартин', 'fm@velogist.com', "+375291234564", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (3, 'Иван', 'Иванов', 'ii@velogist.com', "+375291234565", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Горбачев', 'Олег', 'gorb1990@mail.ru', "+375441231231", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Караник', 'Ибрагим', 'karaniki@inbox.com', "+375292222222", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Касперович', 'Руслан', 'kra@gmail.com', "+375291211162", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Каландаров', 'Вадим', 'vadikkal@yandex.ru', "+375296904562", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Бабарико', 'Алексей', '3354561@outlook.com', "+375293354561", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Забело', 'Алексей', 'alex_1981@rambler.com', "+375293321261", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Петрожицкий', 'Егор', 'a.petrojitskii@slux.com', "+375333354161", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse'),
    (1, 'Павел', 'Гук', 'guk12345@outlook.com', "+375291164561", '$2a$12$fYTVF6sS/p1riX83GeReBupz49dPyiBwkeWksowYuvVp5lDDP8Cse');

insert into drivers_category(driver_id, category_id)
values
    (3, 1),
    (3, 2),
    (3, 3),
    (3, 4),
    (3, 5),
    (4, 2),
    (4, 4),
    (5, 1),
    (5, 2);

insert into vehicle(vehicle_name, max_load_capacity, max_trip_distance, dim_X_restriction, dim_Y_restriction,
    dim_Z_restriction, required_category_id)
values
    ('Volkswagen Crafter', 2000, 800, 4800, 1800, 2000, 4),
    ('Volkswagen Caddy', 600, 1000, 2000, 1300, 1200, 2),
    ('Scania R460', 19000, 3000, 13600, 2450, 2600, 5),
    ('ГАЗ Next', 1700, 800, 4200, 1800, 1900, 4);

insert into address(city, street, building)
values
    ('Минск', 'пр. Независимости', '177'),
    ('Логойск', 'ш. Гайненское', '1'),
    ('Минск', 'пр. Независимости', '116'),
    ('Копище', 'ул. Небесная', '10'),
    ('Минск', 'ул. Аэродромная', '36'),
    ('Минск', 'пр. Партизанский', '174'),
    ('Минск', 'ул. Селицкого', '21А'),
    ('Минск', 'пр. Независимости', '95'),
    ('Минск', 'ул. Уманская', '54'),
    ('Минск', 'ул. Брестская', '51'),
    ('Минск', 'ул. Некрасова', '73'),
    ('Минск', 'Логойский тр.', '35'),
    ('Плещеницы', 'ул. Профинтерна', '24'),
    ('Новополоцк', 'ул. Василевцы', '15'),
    ('Минск', 'ул. Монтажников', '9'),
    ('Фаниполь', 'ул. Зеленая', '2В'),
    ('Гродно', 'ул. Буденого', '37'),
    ('Минск', 'ул. Одинцова', '11'),
    ('Минск', 'ул. Програмистов', '3');

insert into route(driver_id, vehicle_id, manager_id)
values
    (5, 2, 1),
    (4, 1, 1),
    (3, 3, 2);

insert into application(route_id, loading_address_id, unloading_address_id, status_id, customer_id)
values
    (2, 1, 2, 2, 6),
    (2, 3, 4, 2, 8),
    (2, 11, 13, 2, 9),
    (2, 12, 14, 2, 10),
    (1, 8, 5, 2, 11),
    (1, 9, 10, 2, 12),
    (1, 15, 18, 3, 13),
    (1, 19, 18, 4, 13),
    (3, 6, 17, 2, 7),
    (3, 7, 17, 2, 7),
    (3, 16, 17, 2, 7);

insert into item(application_id, item_name, weight, dim_X, dim_Y, dim_Z)
values
    (1, "Sports mat", 3, 500, 100, 100),
    (3, "Postmodern painting", 1, 600, 30, 400),
    (3, "Armchair Rococo", 30, 800, 700, 800),
    (9, "Reinforcement", 13000, 12000, 1200, 600),
    (10, "Wardrobe Monblan", 80, 2400, 1000, 2000),
    (11, "Cement", 500, 1100, 1000, 1200),
    (7, "Nike SB Low", 2, 400, 250, 100),
    (8, "AirJordan 36", 3, 380, 220, 100);

insert into item(application_id, weight, dim_X, dim_Y, dim_Z)
values
    (2, 20, 600, 400, 200),
    (4, 3, 200, 150, 150),
    (5, 2, 300, 300, 100),
    (6, 5, 500, 600, 200);