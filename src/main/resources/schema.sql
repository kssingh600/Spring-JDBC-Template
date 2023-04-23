CREATE TABLE course(
    courseId int NOT NULL,
    courseTitle varchar(50) NOT NULL,
    descr varchar(100) NOT NULL,
    link varchar(100) NOT NULL
);

-- CREATE TABLE course (
--     course_id integer identity NOT NULL,
--     title varchar(88) NOT NULL,
--     descr varchar(500) NOT NULL,
--     link varchar(255) NOT NULL,
--     CONSTRAINT pk_course_course_id PRIMARY KEY (course_id) ;
-- );