INSERT INTO address (id, street, city, country) VALUES
  (4001, '1745 Broadway', 'New York, NY 10019', 'USA'),
  (4002, '1230 Avenue of the Americas', 'New York, NY 10020', 'USA'),
  (4003, '33 Avenue du Maine', '75015 Paris', 'France'),
  (5001, '1380 Hammond Street', 'Bangor, ME 04401', 'USA');

INSERT INTO editor (id, name, address_id) VALUES
  (3001, 'Doubleday', 4001),
  (3002, 'Scribner', 4002),
  (3003, 'XO', 4003);

INSERT INTO book (id, title, language, isbn, date, editor_id) VALUES
  (1001, 'Carrie', 'EN', '0385086954', {ts '1974-04-05 00:00:00.00'}, 3001),
  (1002, 'Pet Sematary', 'EN', '978-0-385-18244-7', {ts '1983-11-14 00:00:00.00'}, 3001),
  (1003, 'Dreamcatcher', 'EN', '978-0-743-21138-3', {ts '2001-02-20 00:00:00.00'}, 3002),
  (1004, 'Under the Dome', 'EN', '978-1-439-14850-1', {ts '2009-11-10 00:00:00.00'}, 3002),
  (1005, 'Central Park', 'FR', '978-2-84563-676-7', {ts '2014-03-27 00:00:00.00'}, 3003),
  (1006, 'Un appartement à Paris', 'FR', '978-2-266-28502-5', {ts '2017-03-30 00:00:00.00'}, 3003);

INSERT INTO author (id, first_name, last_name, address_id) VALUES
  (2001, 'Stephen', 'King', 5001),
  (2002, 'Guillaume', 'Musso', NULL);

INSERT INTO author_books (authors_id, books_id) VALUES
  (2001, 1001),
  (2001, 1002),
  (2001, 1003),
  (2001, 1004),
  (2002, 1005),
  (2002, 1006);
