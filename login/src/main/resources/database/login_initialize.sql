CREATE
    TABLE
        IF NOT EXISTS USER(
            user_id INT PRIMARY KEY AUTO_INCREMENT,
            user_name VARCHAR(255),
            password VARCHAR(255),
            authority INT
        );
