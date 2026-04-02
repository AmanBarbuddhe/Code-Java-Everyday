--> Cartesian Product 
    A = {10,20,30}
    B = {11,22}

    A * B = {
      ^           (10,11) , (10,22)
      |           (20,11) , (20,22)
                  (30,11) , (30,11)
     Cross
            }

--> if table A has 3 records and table B has 2 records then total records = 6

ajdb20=# select * from student , teacher;

 rno | name | per |  city  | tno | name | salary |  city
-----+------+-----+--------+-----+------+--------+--------
   1 | AAA  |  70 | DELHI  | 101 | PPP  |  10000 | PANJI
   1 | AAA  |  70 | DELHI  | 102 | QQQ  |  70000 | DELHI
   1 | AAA  |  70 | DELHI  | 103 | RRR  |  30000 | PUNE
   1 | AAA  |  70 | DELHI  | 104 | SSS  |  70000 | MUMBAI
  -------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 101 | PPP  |  10000 | PANJI
   2 | BBB  |  60 | PUNE   | 102 | QQQ  |  70000 | DELHI
   2 | BBB  |  60 | PUNE   | 103 | RRR  |  30000 | PUNE
   2 | BBB  |  60 | PUNE   | 104 | SSS  |  70000 | MUMBAI
  -------------------------------------------------------
   3 | CCC  |  65 | MUMBAI | 101 | PPP  |  10000 | PANJI
   3 | CCC  |  65 | MUMBAI | 102 | QQQ  |  70000 | DELHI
   3 | CCC  |  65 | MUMBAI | 103 | RRR  |  30000 | PUNE
   3 | CCC  |  65 | MUMBAI | 104 | SSS  |  70000 | MUMBAI
  ------------------------------------------------------- 
   4 | DDD  |  80 | PUNE   | 101 | PPP  |  10000 | PANJI
   4 | DDD  |  80 | PUNE   | 102 | QQQ  |  70000 | DELHI
   4 | DDD  |  80 | PUNE   | 103 | RRR  |  30000 | PUNE
   4 | DDD  |  80 | PUNE   | 104 | SSS  |  70000 | MUMBAI
(16 rows) --> table student has 4 records , table teacher has 4 records , therefore total records = 4*4 = 16

Q. When to join to table
--> when student table and student_teacher table has atleast one column common 
--> and if no common column is present then we cannot use join command  --> if still want to combine , 
--> then it has to forcefully be combined using cartesian product i.e. select student , doctor and it gives irrelevant data

INNER JOIN
----------

SELECT * FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno;

 rno | name | per |  city  | tno | name | salary |  city  | rno | tno |   ldate
-----+------+-----+--------+-----+------+--------+--------+-----+-----+------------
   1 | AAA  |  70 | DELHI  | 101 | PPP  |  10000 | PANJI  |   1 | 101 | 2017-08-21
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 104 | SSS  |  70000 | MUMBAI |   2 | 104 | 2017-08-17
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 102 | QQQ  |  70000 | DELHI  |   2 | 102 | 2017-08-24
   --------------------------------------------------------------------------------
   3 | CCC  |  65 | MUMBAI | 103 | RRR  |  30000 | PUNE   |   3 | 103 | 2017-08-15
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 101 | PPP  |  10000 | PANJI  |   2 | 101 | 2017-08-21
   
(5 rows)

in student_teacher
student with rno = 1 has teacher with tno = 101 , 
therefore student table and teacher table attributes are shown and all details of rno = 1 and tno = 101 , 
and now it our choice what we want from it

student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno --> it is a inner join 
--> mapping student cha rno(primary key) to student_teacher cha rno
--> mapping taecher cha tno(primary key) to student_teacher cha tno

ajdb20=# SELECT student.name AS student , teacher.name AS teacher FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno;

 student | teacher
---------+---------
 AAA     | PPP
 BBB     | SSS
 BBB     | QQQ
 CCC     | RRR
 BBB     | PPP
(5 rows)
--> student wise list of teacher i.e. A che teacher konte , B che teacher konte ,etc.

ajdb20=# SELECT teacher.name AS teacher , student.name AS student FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno ORDER BY teacher.name;
 teacher | student
---------+---------
 PPP     | AAA
 PPP     | BBB
 QQQ     | BBB
 RRR     | CCC
 SSS     | BBB
(5 rows)
--> teacher wise student name

--> show data of teacher which is from punr 
ajdb20=# SELECT * FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno AND teacher.city = 'PUNE';

 rno | name | per |  city  | tno | name | salary | city | rno | tno |   ldate
-----+------+-----+--------+-----+------+--------+------+-----+-----+------------
   3 | CCC  |  65 | MUMBAI | 103 | RRR  |  30000 | PUNE |   3 | 103 | 2017-08-15
(1 row)

-->show student name , who's teacher is from 'PUNE'
ajdb20=# SELECT student.name FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno AND teacher.city = 'PUNE';

 name
------
 CCC
(1 row)

                                                        OR

--> here we have used ALIAS(AS)
ajdb20=# SELECT s.name FROM student s, teacher t, student_teacher st 
WHERE s.rno = st.rno AND t.tno = st.tno AND t.city = 'PUNE';
 name
------
 CCC
(1 row)

--> here we are relating two tables with each other , 
--> that is based on teachers attribute we are finding out some of students attribute

--> FORMAT:          SELECT  (anything that we want to print)
-->                  FROM    (all tables that are related , here it was student,teacher,student_teacher)
-->                  WHERE   student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno --> inner join
-->                  AND     (Required Condition)




--> ******************************************** IMPLICITLY USING INNER JOIN ********************************************

SELECT * FROM student,teacher,student_teacher 
WHERE student.rno = student_teacher.rno AND teacher.tno = student_teacher.tno;

 rno | name | per |  city  | tno | name | salary |  city  | rno | tno |   ldate
-----+------+-----+--------+-----+------+--------+--------+-----+-----+------------
   1 | AAA  |  70 | DELHI  | 101 | PPP  |  10000 | PANJI  |   1 | 101 | 2017-08-21
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 104 | SSS  |  70000 | MUMBAI |   2 | 104 | 2017-08-17
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 102 | QQQ  |  70000 | DELHI  |   2 | 102 | 2017-08-24
   --------------------------------------------------------------------------------
   3 | CCC  |  65 | MUMBAI | 103 | RRR  |  30000 | PUNE   |   3 | 103 | 2017-08-15
   --------------------------------------------------------------------------------
   2 | BBB  |  60 | PUNE   | 101 | PPP  |  10000 | PANJI  |   2 | 101 | 2017-08-21
   
(5 rows)

--> ******************************************** EXPLICITLY USING INNER JOIN ********************************************

ajdb20=# SELECT * FROM student JOIN student_teacher ON student.rno = student_teacher.rno;   --> student.rno = student_teacher.rno  this is basis on which table is join

 rno | name | per |  city  | rno | tno |   ldate
-----+------+-----+--------+-----+-----+------------
   1 | AAA  |  70 | DELHI  |   1 | 101 | 2017-08-21
   2 | BBB  |  60 | PUNE   |   2 | 104 | 2017-08-17
   2 | BBB  |  60 | PUNE   |   2 | 102 | 2017-08-24
   3 | CCC  |  65 | MUMBAI |   3 | 103 | 2017-08-15
   2 | BBB  |  60 | PUNE   |   2 | 101 | 2017-08-21
(5 rows)

now we have joined student table and student_teacher table , now join teacher table with it

ajdb20=# SELECT * FROM student JOIN student_teacher ON student.rno = student_teacher.rno JOIN teacher on teacher.tno = student_teacher.tno;
 rno | name | per |  city  | rno | tno |   ldate    | tno | name | salary |  city
-----+------+-----+--------+-----+-----+------------+-----+------+--------+--------
   1 | AAA  |  70 | DELHI  |   1 | 101 | 2017-08-21 | 101 | PPP  |  10000 | PANJI
   2 | BBB  |  60 | PUNE   |   2 | 104 | 2017-08-17 | 104 | SSS  |  70000 | MUMBAI
   2 | BBB  |  60 | PUNE   |   2 | 102 | 2017-08-24 | 102 | QQQ  |  70000 | DELHI
   3 | CCC  |  65 | MUMBAI |   3 | 103 | 2017-08-15 | 103 | RRR  |  30000 | PUNE
   2 | BBB  |  60 | PUNE   |   2 | 101 | 2017-08-21 | 101 | PPP  |  10000 | PANJI
   -- student_table--------*--student_teacher_table-*--- teacher_table ------------
(5 rows)





























































