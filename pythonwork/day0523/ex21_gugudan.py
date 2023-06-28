"""
숫자를 입력하면 해당 구구단 출력
단, 2~9가 아니면 다시 입력해주세요 출력
0 입력하면 종료
출력시 format 이용해서 출력할것
"""

while True:
    dan=int(input("단을 입력하세요"))
    if dan==0:
        break
    if not 2<=dan<=9:
        print("다시 입력해주세요")
        continue
    for n in range(1,10):
        print("{} x {} = {}".format(dan,n,dan*n))
    print("="*20)
print("프로그램 끝")