def solution(s):
    answer = True
    s_list = list(s)
    l_list = []
    a = ""
    for b in s_list:
        a = b
        if a == '(':
            l_list.append(a)
        elif len(l_list) == 0:
            return False
        else:
            l_list.pop()
    
    if (a == '(' or len(l_list) != 0):
        return False
    return True