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
cz2001
1
10
2
2

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
cz2007
2
18
1
2
1
10
2
10
1
2
1
10
2
10

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
U101L
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


<<<<<<< HEAD
# CASE 4: Check available slot in a class (vacancy in a class)
=======
# CASE 4: Check available slot in a class
>>>>>>> 11520ae6121ad90134cf1401b00e42844b878de6
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



<<<<<<< HEAD
# CASE 5:Print student list by lecture, tutorial or laboratory session for a course. 

###Print student list for cz2001
```

7
cz2001
1

7
cz2001
2

7
cz2001
3
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

7
cz2002
3
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
2
```

###Print student list for empty lab
```
7
cz2007
3
2
```
=======
# CASE: 5




# CASE 6: Enter course assessment components weightage

## Add course assessment with only 1 exam + main coursework component without sub-components
```
8
cz2001
60
1
coursework
100

```

## Enter course assessment with exam + a coursework with 2 sub-components
```
8
cz2002
60
2
assignment
70
class_participation
30

```

## Enter invalid weightage
```
8
cz2007
120
60

```
>>>>>>> 11520ae6121ad90134cf1401b00e42844b878de6
