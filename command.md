# CASE 1: Adding Student
```
1
James
U111L
SCSE
1

1
Nick
U222L
SCSE
1

1
Jenny
U333L
SCSE
3

1
PP
U444L
SCSE
1

1
Walnut
U555L
EEE
1

1
Peter
U666L
MAE
1

1
Kelly
U777L
ASE
2

1
Laura
U888L
CBE
2

1
William
U999L
SPMS
1

1
Emma
U100L
CEE
2

1
Abby
U101L
MSE
2

1
Jason
U122L
NBS
1

1
Martin
U133L
EEE
3

1
Rick
U144L
ADM
1

1
Eric
U155L
IEM
1

1
Wendy
U166L
SCBE
2

```

### Test adding existing student
```

1
Nick
U222L

```


### Test invalid entry
```

1
Dummy
U987H
DummySchool
6
2


```
--------------------------------------------------------------




# CASE 2: Adding courses
```

2
cz2002
3
18
1
2
1
10
2
10
2

2
cz2001
1
15
2
2

2
cz2007
2
18
1
3
1
10
2
10
3
2
1
3
1
10
2
10
3
2

```
### Test adding existing course
```

2
cz2001

```
---------------------------------------------------------------


# CASE 3: Add student to course

### Add student to cz2001
```

5
U111L
cz2001

5
U222L
cz2001

5
U333L
cz2001

5
U444L
cz2001

5
U555L
cz2001

5
U666L
cz2001

5
U777L
cz2001

5
U888L
cz2001

5
U999L
cz2001

5
U100L
cz2001


5
U101L
cz2001

5
U122L
cz2001

5
U133L
cz2001

5
U144L
cz2001

5
U155L
cz2001

```
### Add student to cz2002
```

5
U111L
cz2002
1

5
U222L
cz2002
1

5
U333L
cz2002
1

5
U444L
cz2002
1

5
U555L
cz2002
1

5
U666L
cz2002
1

5
U777L
cz2002
1

5
U888L
cz2002
1

5
U999L
cz2002
1

5
U100L
cz2002
1

5
U101L
cz2002
2

5
U122L
cz2002
2

5
U133L
cz2002
2


```

### Add student to cz2007
```

5
U111L
cz2007
1
1

5
U222L
cz2007
1
1

5
U333L
cz2007
1
1

5
U444L
cz2007
1
1

5
U555L
cz2007
1
1

5
U666L
cz2007
1
1

5
U777L
cz2007
1
1

5
U888L
cz2007
1
1

5
U999L
cz2007
1
1

5
U100L
cz2007
1
1

```



### Add to course which has no lecture vacancy
```

5
U166L
cz2001

```
### Add to course which has no lab/tut vacancy
```

5
U155L
cz2007
1
2
1
2

```
### Add wrong student ID
```

5
U123H

```
### Add to wrong course code
```

5
U144L
cz2006

```

--------------------------------------------------------


# CASE 4: Check available slot in a class (vacancy in a class)

```

6
cz2001

6
cz2002

6
cz2007

```

### Wrong course code
```

6
cz2006

```

--------------------------------------------------



# CASE 5:Print student list by lecture, tutorial or laboratory session for a course. 

###Print student list for cz2001
```

7
cz2001
1

```
###Print student list for cz2002
```
7
cz2002
1

7
cz2002
2
1

7
cz2002
2
2

```

###Print student list for cz2007
```

7
cz2007
1

7
cz2007
2
1

7
cz2007
3
1


```
###Print student list for nonexistent course
```
7
cz2006
```

###Print student list for nonexistent tutorial 
```

7
cz2001
2

7
cz2002
2
3
```

###Print student list for nonexistent lab 
```
7
cz2001
3

7
cz2002
3

7
cz2007
3
3

```

###Print student list for empty tutorial
```
7
cz2007
2
3
```

###Print student list for empty lab
```
7
cz2007
2
3
```





# CASE 6: Enter course assessment components weightage

### Add course assessment with only 1 exam + main coursework component without sub-components
```
8
cz2001
60
1
coursework

```

### Enter course assessment with exam + a coursework with 2 sub-components
```
8
cz2002
60
2
assignment
70
class participation


```

### Enter invalid weightage
```
8
cz2001
120
60
coursework

```

### Enter invalid number of CAs
``` 
8
cz2001
60
0
1
coursework

```

### Enter invalid course code
```
8
cz2009
cz2001
60
1
coursework


```

# CASE 7: Enter coursework mark – inclusive of its components

###Enter valid coursework mark for course with only 1 main component
```
9
U111L
cz2001
80

9
U222L
cz2001
95

9
U333L
cz2001
98

9
U444L
cz2001
70

9
U555L
cz2001
65

9
U666L
cz2001
68

9
U777L
cz2001
59

9
U888L
cz2001
28

9
U999L
cz2001
37


9
U100L
cz2001
100

9
U101L
cz2001
40

9
U122L
cz2001
63

9
U133L
cz2001
88

9
U144L
cz2001
99

```

###Enter valid coursework marks for course with 2 sub-components
```
9
U111L
cz2002
90
80

```

###Enter invalid matriculation number
```
9
1
U111L
cz2001
80

```

###Enter invalid course code
```
9
U111L
cz2009

```

###Enter a course which the student hasn't been registered to
```
9
U101L
cz2007
cz2001
90

```


###Enter invalid marks out of mark range
```
9
U222L
cz2001
120
90

```

#CASE 8: Enter exam mark

###Enter valid exam mark for the valid course
```
10
U111L
cz2001
80

10
U222L
cz2001
100

10
U333L
cz2001
98

10
U444L
cz2001
70

10
U555L
cz2001
42

10
U666L
cz2001
68

10
U777L
cz2001
59

10
U888L
cz2001
28

10
U999L
cz2001
38

10
U999L
cz2001
33

10
U100L
cz2001
100

10
U101L
cz2001
70

10
U122L
cz2001
50

10
U133L
cz2001
30

10
U144L
cz2001
4

10
U111L
cz2002
44

```

###Enter invalid exam mark(out of range)
```
10
U222L
cz2001
150
50

10
U222L
cz2001
-30
20

```

###Enter course without assessment components
```
10
U100L
cz2007

```

###Enter course with student who does not register in
```
10
U144L
cz2002
cz2001
90

```

###Enter student with invalid matric number
```
10
U000L
U111L
cz2001
90

```

###Enter course with invalid course code
```
10
U100L
cz2000


```

#CASE 9: Print course statistics

###Enter valid course code
```
11
cz2001

```

###Enter invalid course code
```
11
cz2000
cz2001

```
#CASE 10: Print student transcript
###Enter valid student id
```
12
U111L

```

###Enter invalid student id
```
12
U000L
U111L

```


###Enter a student that has not been registered to a course
```
10
U166L
```

### Enter a nonexistent course
```
10
U111L
cz2006
```
