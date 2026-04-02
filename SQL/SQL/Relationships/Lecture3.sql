--> Always 1st drop the relationship table because you cannot drop the table from where you are using 
--> primary key attribute as foreign key 

--> 1st drop Student_Teacher , then only you can drop Student table and Teacher Table.

--> we also have to follow order while insertion , 1st add attributes of student table(because rno is 1st column in student_teacher table)
--> then add attributes of teacher table

************************************************************************************************

ajdb20=# insert into student values(1,'AAA',70,'DELHI');
INSERT 0 1
ajdb20=# insert into student values(2,'BBB',60,'PUNE');
INSERT 0 1
ajdb20=# insert into student values(3,'CCC',65,'MUMBAI');
INSERT 0 1
ajdb20=# insert into student values(4,'DDD',80,'PUNE');
INSERT 0 1

ajdb20=# select * from student;

 rno | name | per |  city
-----+------+-----+--------
   1 | AAA  |  70 | DELHI
   2 | BBB  |  60 | PUNE
   3 | CCC  |  65 | MUMBAI
   4 | DDD  |  80 | PUNE
(4 rows)

************************************************************************************************

ajdb20=# insert into teacher values(101,'PPP',10000,'PANJI');
INSERT 0 1
ajdb20=# insert into teacher values(102,'QQQ',70000,'DELHI');
INSERT 0 1
ajdb20=# insert into teacher values(103,'RRR',30000,'PUNE');
INSERT 0 1
ajdb20=# insert into teacher values(104,'SSS',70000,'MUMBAI');
INSERT 0 1

ajdb20=# select * from teacher;

 tno | name | salary |  city
-----+------+--------+--------
 101 | PPP  |  10000 | PANJI
 102 | QQQ  |  70000 | DELHI
 103 | RRR  |  30000 | PUNE
 104 | SSS  |  70000 | MUMBAI
(4 rows)

************************************************************************************************

ajdb20=# insert into student_teacher values(1,101,'2017-08-21');
INSERT 0 1
ajdb20=# insert into student_teacher values(2,104,'2017-08-17');
INSERT 0 1
ajdb20=# insert into student_teacher values(2,102,'2017-08-24');
INSERT 0 1
ajdb20=# insert into student_teacher values(3,103,'2017-08-15');
INSERT 0 1
ajdb20=# insert into student_teacher values(2,101,'2017-08-21');
INSERT 0 1

ajdb20=# select * from student_teacher;

 rno | tno |   ldate
-----+-----+------------
   1 | 101 | 2017-08-21
   2 | 104 | 2017-08-17
   2 | 102 | 2017-08-24
   3 | 103 | 2017-08-15
   2 | 101 | 2017-08-21
(5 rows)

************************************************************************************************

ajdb20=# update student set rno = 7 where rno = 2;
UPDATE 1

ajdb20=# select * from student;
 rno | name | per |  city
-----+------+-----+--------
   1 | AAA  |  70 | DELHI
   3 | CCC  |  65 | MUMBAI
   4 | DDD  |  80 | PUNE
   7 | BBB  |  60 | PUNE
(4 rows)


ajdb20=# select * from student_teacher;
 rno | tno |   ldate
-----+-----+------------
   1 | 101 | 2017-08-21
   3 | 103 | 2017-08-15
   7 | 104 | 2017-08-17
   7 | 102 | 2017-08-24
   7 | 101 | 2017-08-21
(5 rows)

--> because of UPDATE CASCADE , changes done in student table is also reflected in student_teacher (updated record moves to bottom)

ajdb20=# DELETE FROM student WHERE rno = 7;
DELETE 1

ajdb20=# select * from student;
 rno | name | per |  city
-----+------+-----+--------
   1 | AAA  |  70 | DELHI
   3 | CCC  |  65 | MUMBAI
   4 | DDD  |  80 | PUNE
(3 rows)


ajdb20=# select * from student_teacher;
 rno | tno |   ldate
-----+-----+------------
   1 | 101 | 2017-08-21
   3 | 103 | 2017-08-15
(2 rows)
--> Due to DELETE CASCADE

-->******************************************************************************
--> Deleted prvious records and added same records again

Q. Find no. of people from PUNE
--> Ans = 3 (2 students from pune and 1 teacher from pune)

ajdb20=# select count(*) from student where city = 'PUNE' ;
 count
-------
     2
(1 row)


ajdb20=# select count(*) from teacher where city = 'PUNE' ;
 count
-------
     1
(1 row)


--> SELECT 2 + 1;   o/p = 3
--> SELECT () + ();                   ( )                          +                         ( )
                                       |                                                      |

ajdb20=# select (select count(*) from student where city = 'PUNE') + (select count(*) from teacher where city = 'PUNE') AS count_of_people_from_pune;
 count_of_people_from_pune
---------------------------
                         3
(1 row)




























































































