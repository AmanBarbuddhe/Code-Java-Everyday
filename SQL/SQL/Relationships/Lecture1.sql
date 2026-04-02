Relationship in SQL
===================





There are 3 types of relationships in SQL
(1) Many to Many (M-M)
     ex: Many students has Many teachers
          students are : A B C , Teachers are : P Q R
          lets say A learns from P,Q,R , B learns from Q and R , C learns from P

          A learns from P,Q,R i.e. One to Many (1-M) and A and B learns from Q i.e. Many to One (M-1) 
          therefore overall it is Many to Many

(2) 1-M/M-1  : both are same , its about how you read it 
     ex: 1 branch has many customers(1-M)
       : Many customers are in 1 branch(M-1)
           both are same , its just how you read it
(3) 1-1
     ex: One person has One passport


Q. When two or more tables are related or are having relationships or when we can apply relationship between two tables?

--> 2 tables are related to eachother , only when atleast one of the column is same/common (not only column name should be same , but also values in it should be same) in both tables
--> when two tables not having any common column are combined then it is neither join nor relationship , it is cartesian product






