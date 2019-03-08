INSERT INTO address (id, street, city, country) VALUES
  (1001, '1380 Hammond Street', 'Bangor, ME 04401', 'USA'),
  (1002, '1745 Broadway', 'New York, NY 10019', 'USA'),
  (1003, '1230 Avenue of the Americas, 10th F', 'New York, NY 10020', 'USA');

INSERT INTO author (id, first_name, last_name, address_id) VALUES
  (2001, 'Stephen', 'King', 1001);

INSERT INTO book (id, title, language) VALUES
  (3001, 'Carrie', 'en'),
  (3002, 'Dreamcatcher', 'en');

INSERT INTO author_books (authors_id, books_id) VALUES
  (2001, 3001),
  (2001, 3002);

INSERT INTO editor (id, name, address_id) VALUES
  (4001, 'Doubleday', 1002),
  (4002, 'Scribner', 1003);

INSERT INTO edition (id, date, isbn, book_id, editor_id) VALUES
  (5001, {ts '1974-04-05 00:00:00.00'}, '0385086954', 3001, 4001),
  (5002, {ts '2001-02-20 00:00:00.00'}, '978-0-743-21138-3', 3002, 4002);
