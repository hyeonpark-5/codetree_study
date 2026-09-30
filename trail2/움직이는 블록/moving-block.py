n = int(input())
blocks = [int(input()) for _ in range(n)]
c = sum(blocks) // len(blocks)
answer = 0

for block in blocks:
    if block >= c:
        answer += (block - c)

print(answer)