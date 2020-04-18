-- drop user
DROP TABLE IF EXISTS `user`;

-- create user
create table IF not exists `user`
(
 `id`               INT AUTO_INCREMENT PRIMARY KEY,
 `email`            VARCHAR(255) NOT NULL,
 `password`         VARCHAR(255) NOT NULL, 
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- drop user_profile
DROP TABLE IF EXISTS `user_profile`;

-- create user_profile
create table IF not exists `user_profile`
(
 `user_id`          INT NOT NULL UNIQUE,
 `username`         VARCHAR(30),
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- drop user_coach
DROP TABLE IF EXISTS `user_coach`;

-- create user_coach
create table IF not exists `user_coach`
(
 `user_id`          INT NOT NULL UNIQUE,
 `category`         VARCHAR(255),
 `profile`          VARCHAR(255),
 `RATING`           INT,
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop product
DROP TABLE IF EXISTS `product`;

-- create product
create table IF not exists `product`
(
 `id`               INT AUTO_INCREMENT PRIMARY KEY,
 `user_id`          INT NOT NULL,
 `title`            VARCHAR(50) NOT NULL,
 `price`            INT,
 `category`         VARCHAR(255),
 `description`      VARCHAR(255),
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- drop apply
DROP TABLE IF EXISTS `apply`;

-- create apply
create table IF not exists `apply`
(
 `product_id`       INT NOT NULL,
 `student_id`       INT NOT NULL,
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id)
      REFERENCES product(id) ON DELETE CASCADE,
  FOREIGN KEY (student_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop favaorite
DROP TABLE IF EXISTS `favaorite`;

-- create favorite
create table IF not exists `favorite`
(
 `product_id`       INT NOT NULL,
 `student_id`       INT NOT NULL,
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id)
      REFERENCES product(id) ON DELETE CASCADE,
  FOREIGN KEY (student_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop favaorite
DROP TABLE IF EXISTS `category`;

-- create favorite
create table IF not exists `category`
(
 `id`       INT AUTO_INCREMENT PRIMARY KEY,
 `category_name`       VARCHAR(30) NOT NULL,
 `category_image`      VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert data
INSERT INTO `category` 
(`id`, `category_name`, `category_image`) 
VALUES 
('1', 'HTML/CSS', 'images/logo/programing/html-css-logo.png'),
('2', 'javascript','images/logo/programing/js-logo.png'),
('3', 'Java','images/logo/programing/java-logo.png'),
('4', 'Python','images/logo/programing/python-logo.png'),
('5', 'AI','images/logo/programing/ai-logo.jpg'),
('6', 'Ruby','images/logo/programing/ruby-logo.png'),
('7', 'PHP','images/logo/programing/php-logo.png'),
('8', 'Swift','images/logo/programing/swift-logo.png'),
('9', 'Kotlin','images/logo/programing/kotlin-logo.png'),
('10', 'Go','images/logo/programing/go-logo.png'),
('11', 'C#','images/logo/programing/c-logo.png'),
('12', 'Scala','images/logo/programing/scala-logo.png')