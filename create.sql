 DROP TABLE IF EXISTS addresses;
    CREATE TABLE addresses ( id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number INT,
    location VARCHAR(255) NOT NULL,
    province VARCHAR(255) NOT NULL);

    DROP TABLE IF EXISTS PATIENTS;
       CREATE TABLE PATIENTS( ID INT AUTO_INCREMENT PRIMARY KEY,
       NAME VARCHAR(255) NOT NULL,
       LASTNAME VARCHAR(255) NOT NULL,
       CARD_IDENTITY INT NOT NULL,
       ADMISSION_OF_DATE DATE NOT NULL,
       ADDRESS_ID INT NOT NULL, "+
       EMAIL VARCHAR(200) NOT NULL);

   DROP TABLE IF EXISTS DENTISTS;
     CREATE TABLE DENTISTS("+
     ID INT AUTO_INCREMENT PRIMARY KEY,
     REGISTRATION INT NOT NULL,
     NAME VARCHAR(255) NOT NULL,
     LASTNAME VARCHAR(255) NOT NULL);

   INSERT INTO addresses (street, number, location, province) VALUES
         ('Main St', 123, 'New York', 'NY'),
         ('Oak Ave', 456, 'Los Angeles', 'CA'),
         ('Pine Rd', 789, 'Chicago', 'IL'),
         ('Maple Dr', 101, 'Houston', 'TX'),
         ('Elm St', 202, 'Phoenix', 'AZ');

   INSERT INTO patients (name, lastname, card_identity, admission_of_date, address_id, email) VALUES " +
       ('John', 'Doe', 12345, '2023-01-01', 1, 'john.doe@example.com'),
       ('Jane', 'Smith', 23456, '2023-02-15', 2, 'jane.smith@example.com'),
       ('Michael', 'Johnson', 34567, '2023-03-10', 3, 'michael.johnson@example.com'),
       ('Emily', 'Davis', 45678, '2023-04-20', 4, 'emily.davis@example.com'),
       ('David', 'Brown', 56789, '2023-05-30', 5, 'david.brown@example.com');

   INSERT INTO dentists (registration, name, lastname) VALUES " +
       (1001, 'Alice', 'Williams'),
       (1002, 'Robert', 'Miller'),
       (1003, 'William', 'Wilson'),
       (1004, 'Linda', 'Moore'),
       (1005, 'Elizabeth', 'Taylor');