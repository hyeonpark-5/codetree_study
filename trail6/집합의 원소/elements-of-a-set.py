n, m = map(int, input().split())
arr = list(range(n + 1))
size = [1] * (n + 1)

def find(x):
    if arr[x] != x:
        arr[x] = find(arr[x])
    return arr[x]

def union(a, b):
    ra, rb = find(a), find(b)
    if ra == rb:
        return False
    if size[ra] < size[rb]:
        ra, rb = rb, ra
    
    arr[rb] = ra
    size[ra] += size[rb]
    
for _ in range(m):
    order, a, b = map(int, input().split())

    if order == 0:
        union(a, b);
    else:
        if find(a) == find(b):
            print(1)
        else:
            print(0)

