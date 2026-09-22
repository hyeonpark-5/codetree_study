bombs = [
    [(0, 0), (-2, 0), (-1, 0), (1, 0), (2, 0)], # 세로
    [(0, 0), (-1, 0), (1, 0), (0, -1), (0, 1)], # 십자
    [(0, 0), (-1, -1), (-1, 1), (1, 1), (1, -1)] # x자
]

def bomb(res):
    check = set()
    for i in range(cnt):
        start_x, start_y = bomb_location[i][0], bomb_location[i][1]

        for x, y in bombs[res[i]]:
            nx = start_x + x
            ny = start_y + y
            if 0 <= nx < n and 0 <= ny < n:
                if not check or (nx, ny) not in check:
                    check.add((nx, ny))
    return len(check)

def dfs(x):
    global answer

    if x == cnt:
        answer = max(answer, bomb(res))
        return
        
    
    for i in range(3):
        res[x] = i
        dfs(x + 1)

        

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
bomb_location = []
check = [0] * 3
answer = 0

for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            bomb_location.append((i, j))

cnt = len(bomb_location)
res = [0] * cnt
dfs(0)
print(answer)