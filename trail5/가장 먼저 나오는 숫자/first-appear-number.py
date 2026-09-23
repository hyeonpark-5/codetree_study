n, m = map(int, input().split())
arr = list(map(int, input().split()))
query = list(map(int, input().split()))

def lower(target):
    left = 0
    right = n - 1
    idx = n

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] >= target:
            idx = min(idx, mid)
            right = mid - 1
        else:
            left = mid + 1

    if idx == n or arr[idx] != target:
        return -1

    return idx + 1

for q in query:
    print(lower(q))

    