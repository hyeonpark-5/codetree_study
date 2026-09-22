def dfs(x):
    global answer
    if x == n:
        answer += 1
        return
    
    for i in range(1, 5):
        if x + i <= n:
            dfs(x + i)

n = int(input())
answer = 0
dfs(0)
print(answer)