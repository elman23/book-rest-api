-- Drop user first if they exist
DROP USER if exists 'bookreader'@'%' ;

-- Now create user with prop privileges
CREATE USER 'bookreader'@'%' IDENTIFIED BY 'bookreader';

GRANT ALL PRIVILEGES ON * . * TO 'bookreader'@'%';