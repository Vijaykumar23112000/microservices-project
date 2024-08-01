INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Beverages', 'Drinks and other beverages');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Snacks', 'Quick bites and snacks');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Desserts', 'Sweet dishes and desserts');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Main Course', 'Main course dishes');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Salads', 'Fresh and healthy salads');

INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Coca Cola', 'Carbonated soft drink', 100, 1.50, (SELECT id FROM category WHERE name = 'Beverages'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Pepsi', 'Carbonated soft drink', 100, 1.50, (SELECT id FROM category WHERE name = 'Beverages'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Lays', 'Potato chips', 200, 0.99, (SELECT id FROM category WHERE name = 'Snacks'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'KitKat', 'Chocolate wafer bar', 150, 0.75, (SELECT id FROM category WHERE name = 'Snacks'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Ice Cream', 'Vanilla flavored ice cream', 50, 2.50, (SELECT id FROM category WHERE name = 'Desserts'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Brownie', 'Chocolate brownie', 75, 1.99, (SELECT id FROM category WHERE name = 'Desserts'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Grilled Chicken', 'Grilled chicken with spices', 30, 8.99, (SELECT id FROM category WHERE name = 'Main Course'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Beef Steak', 'Juicy beef steak', 20, 15.99, (SELECT id FROM category WHERE name = 'Main Course'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Caesar Salad', 'Fresh Caesar salad with dressing', 50, 5.50, (SELECT id FROM category WHERE name = 'Salads'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Greek Salad', 'Healthy Greek salad', 50, 4.99, (SELECT id FROM category WHERE name = 'Salads'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Orange Juice', 'Freshly squeezed orange juice', 100, 3.00, (SELECT id FROM category WHERE name = 'Beverages'));
INSERT INTO product (id, name, description, availableQuantity, price, category_id) VALUES (nextval('product_seq'), 'Apple Juice', 'Freshly squeezed apple juice', 100, 3.00, (SELECT id FROM category WHERE name = 'Beverages'));