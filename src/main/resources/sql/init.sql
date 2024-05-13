--INSERT INTO products (id, name, brand, product_price) values (1, 'Худи из хлопкового футера c карманом-кенгуру', 'HUGO', '15900') ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (2, 'Шорты с карманами', 'Blend', 4490) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (3, 'Футболка хлопковая с логотипом', 'Calvin Klein', 4190) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (4, 'Футболка хлопковая с принтом', 'Desigual', 2900) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (5, 'Бейсболка хлопковая', 'Superdry', 1900) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (6, 'Футболка хлопковая', 'Gloria Jeans', 2700) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (7, 'Сумка через плечо', 'BOSS', 11900) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (8, 'Брюки на кулиске с защипами', 'MARCO DI RADI', 6700) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (9, 'Худи из смесового хлопка', 'Champion', 8900) ON CONFLICT (id) DO NOTHING;
--INSERT INTO products (id, name, brand, product_price) values (10, 'Хлопковая футболка с принтом', 'REEBOK', 2390);


-- ALTER TABLE user_roles ADD COLUMN id serial NOT NULL;
-- ALTER TABLE user_roles ADD CONSTRAINT prima_key PRIMARY KEY (id);

-- INSERT INTO roles (id, role) VALUES (0, 'ROLE_USER') ON CONFLICT DO NOTHING;
-- INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;

--INSERT INTO users (id, name, password, sur_name, user_name, account_non_locked) VALUES (0, '-', '$2a$12$UxaX6oq8qWJoSA2qMX9LWeLT0dtaKiS7NcXXDnFFl1wxFNustGxIK', '-', 'admin', true) ON CONFLICT DO NOTHING;
-- INSERT INTO user_roles(user_id, role_id) VALUES (0, 1) ON CONFLICT DO NOTHING;