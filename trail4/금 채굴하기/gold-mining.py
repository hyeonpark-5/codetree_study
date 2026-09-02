n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
answer = 0

def check(x, y, k):
    cnt = 0
    for dx in range(-k, k + 1):
        w = k - abs(dx)
        for dy in range(-w, w + 1):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 1:
                cnt += 1

    return cnt       
    
for i in range(n):
    for j in range(n):
        for k in range(2*n + 1):
            res = check(i, j, k)
            total = k ** 2 + ((k + 1) ** 2)
            if total <= (m * res):
                answer = max(answer, res)
            
print(answer)