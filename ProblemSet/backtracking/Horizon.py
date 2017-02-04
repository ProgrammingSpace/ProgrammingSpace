count = 0

def backtrack(m, row, col, word, k):
    global count
    if k == (len(word) - 1):
        count+= 1
        return
    for i in range(-1, 2):
        for j in range(-1, 2):
            try:
                if m[row + i][col + j] == word[k]:
                    backtrack(m, row + i, col + j, word, k + 1)
            except IndexError:
                pass

if __name__ == '__main__':
    matrix =[input().split() for i in range(0, 7)]
    print(matrix)
    word = input()

    for i in range(0, len(matrix)):
        for j in range(0, len(matrix[i])):
            if matrix[i][j] == word[0]:
                backtrack(matrix, i, j, word, 0)

    print(count)