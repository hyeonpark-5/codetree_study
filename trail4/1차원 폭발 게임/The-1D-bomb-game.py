n, m = map(int, input().split())
numbers = [int(input()) for _ in range(n)]



while True:
    result = []
    res = []
    check = False
    
    for nn in numbers:
        if not res or res[-1] == nn:
            res.append(nn)
        else:
            if len(res) < m:
                result += res
            else:
                check = True
                    
            res = [nn]
    
    if res:
        if len(res) < m:
            result += res
        else:
            check = True

    numbers = result

    if not check:
        break
        
print(len(result))
for r in result:
    print(r)