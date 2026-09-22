dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n, r, c = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
x = r - 1
y = c - 1
answer = [board[x][y]]

while True:
    check = False

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n and board[x][y] < board[nx][ny]:
            answer.append(board[nx][ny])
            check = True
            x = nx
            y = ny
            break

    if not check:
        break
            

for ans in answer:
    print(ans, end =' ')    