INSERT INTO address (id, street, city, country) VALUES
  (4001, '1380 Hammond Street', 'Bangor, ME 04401', 'USA'),
  (4002, '1745 Broadway', 'New York, NY 10019', 'USA'),
  (4003, '1230 Avenue of the Americas, 10th F', 'New York, NY 10020', 'USA');

INSERT INTO editor (id, name, address_id) VALUES
  (3001, 'Doubleday', 4002),
  (3002, 'Scribner', 4003);

INSERT INTO book (id, title, language, isbn, date, editor_id) VALUES
  (1001, 'Carrie', 'en', '0385086954', {ts '1974-04-05 00:00:00.00'}, 3001),
  (1002, 'Pet Sematary', 'en', '978-0-385-18244-7', {ts '1983-11-14 00:00:00.00'}, 3001),
  (1003, 'Dreamcatcher', 'en', '978-0-743-21138-3', {ts '2001-02-20 00:00:00.00'}, 3002),
  (1004, 'Under the Dome', 'en', '978-1-439-14850-1', {ts '2009-11-10 00:00:00.00'}, 3002);

INSERT INTO author (id, first_name, last_name, address_id) VALUES
  (2001, 'Stephen', 'King', 4001);

INSERT INTO author_books (authors_id, books_id) VALUES
  (2001, 1001),
  (2001, 1002),
  (2001, 1003),
  (2001, 1004);
