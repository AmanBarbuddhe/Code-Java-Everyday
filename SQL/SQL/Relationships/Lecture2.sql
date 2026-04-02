Many to Many (M-M)
------------------

Student and teacher entities are many to many related with descriptive attribute 'ldate'

for many to many relationship , a relationship table is created 

here the relationship table is Student_Teacher

              Student                                 Student_Teacher                             Teacher
 ----------------------------------             --------------------------------         ---------------------------------------------------             
 rno   |   name   |  per   |   city             rno     |     tno     |    ldate         tno     |    name    |      salary      |     city
 1     |    AAA   |  60    |   PUNE               1     |      101    |  2017-08-21       101    |    PPP     |      10000       |    PANJI
 2     |    BBB   |  70    |   DELHI              1     |      101    |  2017-08-22       102    |    QQQ     |      70000       |    DELHI
                                                  2     |      101    |  2017-08-21
                                                  1     |      102    |  2017-08-21



meaning of Student_Teacher table --> student with rno = 101 , has attended a lecture of teacher with tno = 1 on 2017-08-21
                                 --> student with rno = 101 , has attended a lecture of teacher with tno = 1 on 2017-08-21
                                 


Student --> rno(primary key) , name , per , city
Teacher --> tno(primary key) , name , salary , city
Student_Teacher --> rno , tno , ldate 

Student ---------------- HAS ------------------- Teacher

ldate is the attribute of relationship table 

Q. What is descriptive attribute?
--> it is an attribute which describes relationship
--> it is always part of relationship table
--> there can be more than one descriptive attribute

Q. What is Foreign key?
--> Primary key of one table when acts as a key in another table(relationship table) such 



ajdb20=# CREATE TABLE student(
ajdb20(# rno int primary key ,
ajdb20(# name varchar(10),
ajdb20(# per float,
ajdb20(# city varchar(10)
ajdb20(# );
CREATE TABLE

ajdb20=# CREATE TABLE teacher(
ajdb20(# tno int primary key,
ajdb20(# name varchar(10),
ajdb20(# salary float,
ajdb20(# city varchar(10)
ajdb20(# );
CREATE TABLE

ajdb20=# CREATE TABLE Student_Teacher(
ajdb20(# rno int REFERENCES student(rno) ON DELETE CASCADE ON UPDATE CASCADE,  
ajdb20(# tno int REFERENCES teacher(tno) ON DELETE CASCADE ON UPDATE CASCADE,
ajdb20(# ldate DATE
ajdb20(# );
CREATE TABLE

--> rno , col_name same as in student table , REFERENCES student(rno) --> to tell that its foreign key , 
--> ON DELETE CASCADE --> if we delete rno = 1 from student table then rno = 1 should also get delete from Student_Teacher table,
--> ON UPDATE CASCADE --> if update is done in student table then same update should be done in Student_Teacher

ajdb20=# \d student_teacher;
          Table "public.student_teacher"
 Column |  Type   | Collation | Nullable | Default
--------+---------+-----------+----------+---------
 rno    | integer |           |          |
 tno    | integer |           |          |
 ldate  | date    |           |          |
Foreign-key constraints:
    "student_teacher_rno_fkey" FOREIGN KEY (rno) REFERENCES student(rno) ON UPDATE CASCADE ON DELETE CASCADE
    "student_teacher_tno_fkey" FOREIGN KEY (tno) REFERENCES teacher(tno) ON UPDATE CASCADE ON DELETE CASCADE



















