n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]

points = []
for idx, (x1, x2) in enumerate(arr):
    points.append((x1, 1, idx))
    points.append((x2, -1, idx))

points.sort()

res = set()
answer = 0
for x, v, idx in points:
    if v > 0:
        if not res:
            answer += 1
        res.add(idx)
    else:
        res.remove(idx)   

print(answer)

