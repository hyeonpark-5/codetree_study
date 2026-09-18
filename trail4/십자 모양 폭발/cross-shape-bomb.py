dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bomb(r, c):
    move = board[r][c]

    board[r][c] = 0

    for i in range(4):
        x, y = r, c
        for j in range(move - 1):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                board[nx][ny] = 0
                x, y = nx, ny

def gravity():
    temp = [[0] * n for _ in range(n)]
    for col in range(n):
        temp_row = n - 1
        for row in range(n - 1, -1, -1):
            if board[row][col] != 0:
                temp[temp_row][col] = board[row][col] 
                temp_row -= 1

    for tt in temp:
        for t in tt:
            print(t, end = ' ')
        print()

  
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())
cols = [c]
r, c = r - 1, c - 1
bomb(r, c)
gravity()



