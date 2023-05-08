# BckTrk_Sudoku
A program that uses recursion and backtracking to solve sudoku puzzles

There is a 2d array called board where you add your sudoku puzzle.
```
board = [
        [0,0,5,4,9,0,0,0,8],
        [2,0,0,8,5,1,0,0,0],
        [0,1,0,7,0,0,5,2,0],
        [0,0,0,0,0,0,0,5,3],
        [0,0,2,3,0,8,4,0,0],
        [1,3,0,0,0,0,0,0,0],
        [0,7,4,0,0,5,0,6,0],
        [0,0,0,1,8,7,0,0,5],
        [5,0,0,0,3,4,7,0,0]
        ]
```
### printBoard() function
It will print the array to look similar like a sudoku puzzle.

### findEmpty() function
This function will first look for an empty space which I have denoted with 0(zero).

### check() function
It will look if the number which we are inserting to the empty space is already present on that row or column or that particular 3x3 box or not.

### solve() function
Finally this is the function where we are calling the findEmpty() function to get the empty space then calling the check() fucntion before inserting the number. Here the recursion happens till we get our solution.

The Backtracking works as if we inserted 3 at (0,0) as 1 and 2 is already in the box.
```
3 0 5  | 4 9 0  | 0 0 8
2 0 0  | 8 5 1  | 0 0 0
0 1 0  | 7 0 0  | 5 2 0
- - - - - - - - - - - - 
0 0 0  | 0 0 0  | 0 5 3
0 0 2  | 3 0 8  | 4 0 0
1 3 0  | 0 0 0  | 0 0 0
- - - - - - - - - - - - 
0 7 4  | 0 0 5  | 0 6 0
0 0 0  | 1 8 7  | 0 0 5
5 0 0  | 0 3 4  | 7 0 0
```
Then it will get (0, 1) as the empty space then as we already have 1,2,3,5 in the box and 4 in the same row so it will insert 6.
```
3 6 5  | 4 9 0  | 0 0 8
2 0 0  | 8 5 1  | 0 0 0
0 1 0  | 7 0 0  | 5 2 0
- - - - - - - - - - - - 
0 0 0  | 0 0 0  | 0 5 3
0 0 2  | 3 0 8  | 4 0 0
1 3 0  | 0 0 0  | 0 0 0
- - - - - - - - - - - - 
0 7 4  | 0 0 5  | 0 6 0
0 0 0  | 1 8 7  | 0 0 5
5 0 0  | 0 3 4  | 7 0 0
```
working forward, at (0, 5) it will try to insert 7 or 8 or 9 but all of them are already in the same box. So, now backtraking works. it will go back and insert a different number at (0, 1) like for example 8 as 7 is already in the same column.
```
3 8 5  | 4 9 0  | 0 0 8
2 0 0  | 8 5 1  | 0 0 0
0 1 0  | 7 0 0  | 5 2 0
- - - - - - - - - - - - 
0 0 0  | 0 0 0  | 0 5 3
0 0 2  | 3 0 8  | 4 0 0
1 3 0  | 0 0 0  | 0 0 0
- - - - - - - - - - - - 
0 7 4  | 0 0 5  | 0 6 0
0 0 0  | 1 8 7  | 0 0 5
5 0 0  | 0 3 4  | 7 0 0
```
proceeding like this the fuction will call itself till we will get the solution.

## Note: I will be working for a GUI version of this project so its get pretty easy to add new puzzles. stay tuned.
