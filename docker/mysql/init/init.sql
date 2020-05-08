-- FOREIGN KEY 
SET FOREIGN_KEY_CHECKS = 0;

-- drop user
DROP TABLE IF EXISTS `user`;

-- create user
create table IF not exists `user`
(
 `id`               INT AUTO_INCREMENT PRIMARY KEY,
 `username`         VARCHAR(30),
 `email`            VARCHAR(255) NOT NULL UNIQUE,
 `password`         VARCHAR(255) NOT NULL, 
 `profile_text`     VARCHAR(255),
 `teaching_category` VARCHAR(255),
 `rating`           INT,
 `is_admin`         tinyint(1) NOT NULL DEFAULT '0', 
 `last_login`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop product
DROP TABLE IF EXISTS `product`;

-- create product
create table IF not exists `product`
(
 `id`               INT AUTO_INCREMENT PRIMARY KEY,
 `user_id`          INT NOT NULL,
 `title`            VARCHAR(50) NOT NULL,
 `price`            INT NOT NULL,
 `contact_tools`    VARCHAR(255) NOT NULL,
 `time`             VARCHAR(255) NOT NULL,
 `category`         VARCHAR(255) NOT NULL,
 `description`      VARCHAR(255) NOT NULL,
 `is_published`     tinyint(1) NOT NULL DEFAULT '1', 
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
 `id`       INT AUTO_INCREMENT PRIMARY KEY,
 `product_id`       INT NOT NULL,
 `student_id`       INT NOT NULL,
 `status`      tinyint(1) NOT NULL DEFAULT '0',
 `message`          VARCHAR(255),
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id)
      REFERENCES product(id) ON DELETE CASCADE,
  FOREIGN KEY (student_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop favorite
DROP TABLE IF EXISTS `favorite`;

-- create favorite
create table IF not exists `favorite`
(
 `product_id`       INT NOT NULL PRIMARY KEY,
 `student_id`       INT NOT NULL PRIMARY KEY,
 `created_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 `updated_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id)
      REFERENCES product(id) ON DELETE CASCADE,
  FOREIGN KEY (student_id)
      REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop category
DROP TABLE IF EXISTS `category`;

-- create category
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

-- insert data
INSERT INTO `user` 
(`id`, `username`, `email`, `password`, `profile_text`, `is_admin`) 
VALUES 
(1, 'テスト1 太郎', 'test1taro@rebelapp.com', 'rebelapp', 'Hello world!!! ', 1 ),
(2, 'テスト2 太郎', 'test2taro@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(3, 'テスト3 太郎', 'test3taro@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(4, 'テスト4 太郎', 'test4taro@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(5, 'テスト5 太郎', 'test5taro@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(6, 'テスト1 花子', 'test1hanako@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(7, 'テスト2 花子', 'test2hanako@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(8, 'テスト3 花子', 'test3hanako@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(9, 'テスト4 花子', 'test4hanako@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 ),
(10, 'テスト5 花子', 'test5hanako0@rebelapp.com', 'rebelapp', 'Hello world!!! ', 0 )

-- insert data
INSERT INTO `product` 
(`id`, `user_id`, `title`, `price`, `contact_tools`, `time`, `category`, `description`, `is_published`) 
VALUES 
(1, 1, 'Java Basic Leacture1', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(2, 1, 'Java Basic Leacture2', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(3, 1, 'Java Basic Leacture3', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(4, 1, 'Java Basic Leacture4', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(5, 1, 'Java Basic Leacture5', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(6, 1, 'Java Basic Leacture6', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(7, 1, 'Java Basic Leacture7', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(8, 1, 'Java Basic Leacture8', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(9, 1, 'Java Basic Leacture9', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(10, 1, 'Java Basic Leacture10', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(11, 1, 'Java Basic Leacture11', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(12, 1, 'Java Basic Leacture12', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(13, 1, 'Java Basic Leacture13', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(14, 1, 'Java Basic Leacture14', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(15, 1, 'Java Basic Leacture15', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(16, 1, 'Java Basic Leacture16', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(17, 1, 'Java Basic Leacture17', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(18, 1, 'Java Basic Leacture18', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(19, 1, 'Java Basic Leacture19', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(20, 1, 'Java Basic Leacture20', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(21, 1, 'Java Basic Leacture21', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(22, 1, 'Java Basic Leacture22', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(23, 1, 'Java Basic Leacture23', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(24, 1, 'Java Basic Leacture24', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(25, 1, 'Java Basic Leacture25', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(26, 1, 'Java Basic Leacture26', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(27, 1, 'Java Basic Leacture27', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(28, 1, 'Java Basic Leacture28 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 0 ),
(29, 1, 'Java Basic Leacture29', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(30, 1, 'Java Basic Leacture30 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 0 ),
(31, 1, 'Java Basic Leacture31', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(32, 1, 'Java Basic Leacture32 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 0 ),
(33, 1, 'Java Basic Leacture33', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(34, 1, 'Java Basic Leacture34 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 0 ),
(35, 1, 'Java Basic Leacture35', 3000, 'Google Hangout/slack', '平日夜,休日', 'Java' , 'This is Java Basic lecture', 1 ),
(36, 2, 'Python Basic Leacture1', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(37, 2, 'Python Basic Leacture2', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(38, 2, 'Python Basic Leacture3', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(39, 2, 'Python Basic Leacture4', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(40, 2, 'Python Basic Leacture5', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(41, 2, 'Python Basic Leacture6', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(42, 2, 'Python Basic Leacture7', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(43, 2, 'Python Basic Leacture8', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(44, 2, 'Python Basic Leacture9', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(45, 2, 'Python Basic Leacture10', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(46, 2, 'Python Basic Leacture11', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(47, 2, 'Python Basic Leacture12', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 1 ),
(48, 2, 'Python Basic Leacture13 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 0 ),
(49, 2, 'Python Basic Leacture14 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 0 ),
(50, 2, 'Python Basic Leacture15 not published', 3000, 'Google Hangout/slack', '平日夜,休日', 'Python' , 'This is Python Basic lecture', 0 )

-- insert data
INSERT INTO `apply` 
(`id`, `product_id`, `student_id`, `status`, `message`) 
VALUES 
(1, 1, 6, 0, 'よろしくお願いします。'),
(2, 1, 7, 0, 'よろしくお願いします。'),
(3, 1, 8, 1, 'よろしくお願いします。'),
(4, 1, 9, 1, 'よろしくお願いします。'),
(5, 1, 10, 2, 'よろしくお願いします。'),
(6, 2, 6, 0, 'よろしくお願いします。'),
(7, 3, 6, 0, 'よろしくお願いします。'),
(8, 4, 6, 0, 'よろしくお願いします。'),
(9, 5, 6, 0, 'よろしくお願いします。'),
(10, 6, 6, 0, 'よろしくお願いします。')

-- insert data
INSERT INTO `favorite` 
(`product_id`, `student_id`) 
VALUES 
(2, 6,),
(2, 7),
(2, 8),
(2, 9),
(2, 10)
