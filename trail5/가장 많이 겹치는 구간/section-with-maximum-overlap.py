n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]
MAX_R = 200000
arr = [0] * (MAX_R + 1)

for x, y in intervals:
    arr[x] = 1
    arr[y] = -1

answer = 0
res = 0
for x in range(1, MAX_R + 1):
    res += arr[x]
    answer = max(answer, res)
    
print(answer)
