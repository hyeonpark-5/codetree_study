n = int(input())
edges = [tuple(map(int, input().split())) for _ in range(n - 1)]
tree = [[] for _ in range(n + 1)]
check = [0] * (n + 1)
result = [0] * (n + 1)
# Please write your code here.
def dfs(x):
    for i in tree[x]:
        if check[i] == 0:
            check[i] = 1
            result[i] = x
            dfs(i)


for x, y in edges:
    tree[x].append(y)
    tree[y].append(x)

check[1] = 1
dfs(1)

for i in range(2, n + 1):
    print(result[i])