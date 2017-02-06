# Backtrack Solution - The Horizon
# This is the solution to the problem that I call 'The Horizon'
# This Python code searches for the occurrence of a word in the
# given grid of characters. Refer to the following link for details
# http://algorithms.tutorialhorizon.com/backtracking-search-a-word-in-a-matrix/


def backtrack(x,y,k):
    if k is len(word):
        global count
        count += 1
    else:
        for i in range(-1,2):
            for j in range(-1,2):
                if (x+i>=0) and (x+i<m) and (y+j>=0) and (y+j<n):
                    if word[k] is grid[x+i][y+j]:
                        backtrack(x+i, y+j, k+1)

inp = input().split()
m = int(inp[0])
n = int(inp[1])
grid = [input().split() for i in range(m)]
word = input()
count = 0

for i in range(0, m):
    for j in range(0, n):
        if grid[i][j] is word[0]:
            backtrack(i, j, 1)
print(count)