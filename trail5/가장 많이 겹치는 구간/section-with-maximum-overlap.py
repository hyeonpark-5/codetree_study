n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

point = []
for x, y in intervals:
    point.append((x, 1))
    point.append((y, -1))

point.sort()

answer = 0
res = 0
for x, v in point:
    res += v
    answer = max(answer, res)
    
print(answer)
