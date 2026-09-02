from collections import deque
n, t = map(int, input().split())
u = list(map(int, input().split()))
d = list(map(int, input().split()))


u = deque(u)
d = deque(d)

for _ in range(t):
    temp_u = u.pop()
    temp_d = d.pop()

    u.appendleft(temp_d)
    d.appendleft(temp_u)

for i in u:
    print(i, end=" ")
print()
for j in d:
    print(j, end=" ")