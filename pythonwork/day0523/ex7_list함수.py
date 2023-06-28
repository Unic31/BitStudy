#list 타입의 각종 함수 연습
list=["green","blue","white","yellow","orange"]
print(list)
print(list.pop())#마지막 데이터 꺼내기 orange
list2=list.copy()#남은 데이터 복사
print(list2)
list2.sort()
print(list)#넣은 순서대로 출력
print(list2)#정렬되어서 출력

list.reverse()
print(list)#거꾸로 출력

list.insert(1,"gray")#1번 인덱스 이전 추가
print(list)

list.remove("white")
print(list)