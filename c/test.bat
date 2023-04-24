gcc -c wclib.c
ar rcs wclib.a wclib.o
gcc -c test.c
gcc -static test.o wclib.a 
a.exe
pause