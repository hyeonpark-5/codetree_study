n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = [int(input()) for _ in range(m)]

# Please write your code here.
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

    return idx

def upper(target):
    left = 0
    right = n - 1
    idx = n
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] > target:
            idx = min(idx, mid)
            right = mid - 1
        else:
            left = mid + 1
    
    return idx


for q in queries:
    print(upper(q) - lower(q))