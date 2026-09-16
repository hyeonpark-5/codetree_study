from collections import deque

n, m, q = map(int, input().split())
board = [deque(map(int, input().split())) for _ in range(n)]
# winds = [(int(r), d) for r, d in [input().split() for _ in range(q)]]

def find(row, new):
    if -1 < new < n: 
        for i in range(m):
            if board[row][i] == board[new][i]:
                return True
    return False

for _ in range(q):
    r, d = input().split()
    check = [False] * n
    move = deque([(int(r) - 1, d)])
    check[int(r) - 1] = True

    while move:
        row, dir = move.popleft()

        if dir == 'L':
            temp = board[row].pop()
            board[row].appendleft(temp)
        else:
            temp = board[row].popleft()
            board[row].append(temp)

        
        f = row + 1
        b = row - 1

        if dir == 'R':
            dir = 'L'
        else:
            dir = 'R'

        if find(row, f) and check[f] == False:
            check[f] = True
            move.append((f, dir))
            
        
        if find(row, b) and check[b] == False:
            check[b] = True
            move.append((b, dir))



for i in board:
    for j in i:
        print(j, end = ' ')
    print()