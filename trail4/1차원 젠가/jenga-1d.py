n = int(input())
blocks = [int(input()) for _ in range(n)]

for _ in range(2):
    start, end = map(int, input().split())
    temp = []
    for idx in range(len(blocks)):
        if start - 1 <= idx <= end - 1:
            continue
        temp.append(blocks[idx])
    blocks = temp

print(len(blocks))
for b in blocks:
    print(b)