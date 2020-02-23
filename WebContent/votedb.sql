CREATE DATABASE votedb;
USE votedb;

CREATE TABLE t_user
(
   id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
   NAME VARCHAR(50) NOT NULL,
   pwd VARCHAR(20) NOT NULL,
   nickname VARCHAR(100),
   online INT DEFAULT 1 
);

CREATE TABLE t_subject
(
   id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(500) NOT NULL,
   number INT,
   starttime BIGINT(20),
   endtime BIGINT(20),
   userId BIGINT(20),
   FOREIGN KEY(userId) REFERENCES t_user(id)
);

CREATE TABLE t_option
(
   id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
   content VARCHAR(500) NOT NULL,
   idx int£¬
   subjectId BIGINT(20),
   FOREIGN KEY(subjectId) REFERENCES t_Subject(id)
);

CREATE TABLE t_record
(
   id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
   subjectId BIGINT(20) NOT NULL,
   optionId BIGINT(20) NOT NULL,
   userId BIGINT(20) NOT NULL,
   FOREIGN KEY(subjectId) REFERENCES t_subject(id),
   FOREIGN KEY(optionId) REFERENCES t_option(id),
   FOREIGN KEY(userId) REFERENCES t_user(id)
)