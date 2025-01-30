-- Table 1: Users
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    bio TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
insert into users (user_name, email, password_hash, first_name, last_name, bio)
values('tinaaa', 'john@example.com','hashedpassword','John', 'Doe', 'hello'),
('janeee', 'jane@example.com','hashedpassword','jane', 'white', 'hello'),
('bobbb', 'bob@example.com','hashedpassword','bob', 'Smith', 'hello'),
('saraaaa', 'sara@example.com','hashedpassword','sara', 'Jones', 'hello'),
('aliceee', 'alice@example.com','hashedpassword','alice', 'Williams', 'hello');

-- Table 2: Posts
CREATE TABLE Posts (
    post_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES Users(user_id),
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);
insert into posts (user_id, content)
values
(1, 'Just started learning SQL! Excited to build my first database.'),
(1, 'Loving the new project'),
(2, 'Attending a data science conference this week. So many cool insights!'),
(3, 'ust finished a photoshoot for a local event! '),
(4, 'Excited to launch my new marketing campaign tomorrow.');


-- Table 3: Likes (Many-to-Many relationship between users and posts)
CREATE TABLE Likes (
    user_id INT REFERENCES Users(user_id),
    post_id INT REFERENCES Posts(post_id),
    PRIMARY KEY (user_id, post_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
insert into likes (user_id, post_id)
values
(1, 1),
(1, 2),
(1, 3),
(3, 1),
(4, 1)
