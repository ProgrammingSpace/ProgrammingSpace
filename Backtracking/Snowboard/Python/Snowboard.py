
def backtrack(x,y):
    global count, maxim
    for i in range(-1,2):
        for j in range(-1,2):
            if (x+i >= 0) and (x+i < r) and (y+j >= 0) and (y+j < c) and ((i+j==1) or (i+j==-1)):
                if grid[x+i][y+j] < grid[x][y]:
                    # print(grid[x+i][y+j])
                    count+=1
                    if count>maxim:
                        maxim = count
                    backtrack(x+i, y+j)
                    count-=1

T = int(input())
for k in range(0,T):
    arr = input().split()
    name = arr[0]
    r = int(arr[1])
    c = int(arr[2])
    count = 0
    maxim = 0
    grid = [input().split() for i in range(0, r)]

    for i in range(0, r):
        for j in range(0, c):
            grid[i][j] = int(grid[i][j])

    for i in range(0, r):
        for j in range(0, c):
            backtrack(i, j)
    print(name + ": " + str(maxim+1))