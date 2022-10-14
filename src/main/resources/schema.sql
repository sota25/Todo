CREATE TABLE IF NOT EXISTS todo_details(
    id INT PRIMARY KEY auto_increment,
    title VARCHAR(40) UNIQUE,
    is_done BOOLEAN,
    time_limit DATE
);