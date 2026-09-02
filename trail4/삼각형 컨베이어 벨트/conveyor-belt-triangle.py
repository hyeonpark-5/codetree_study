from collections import deque
n, t = map(int, input().split())

l = deque(list(map(int, input().split())))
r = deque(list(map(int, input().split())))
d = deque(list(map(int, input().split())))

for _ in range(t):
    temp_l = l.pop()
    temp_r = r.pop()
    temp_d = d.pop()

    r.appendleft(temp_l)
    d.appendleft(temp_r)
    l.appendleft(temp_d)

for ll in l:
    print(ll, end = " ")
print()
for rr in r:
    print(rr, end = " ")
print()
for dd in d:
    print(dd, end = " ")