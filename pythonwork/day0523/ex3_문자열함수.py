s1="Have a Nice Day"
s2="Happy Day"
print(s1.startswith("Have"))#true
print(s1.startswith("Happy"))#False
print(s2.endswith("Day"))#true
s3=s1.replace(" ","*")#공백을 *로 변경
print(s3)
print(s1.count("a"))#s1에서의 a갯수
print(s1.lower(),s1.upper())#다 소문자, 다 대문자
print('/'.join(s1))#모든 글자 사이에  / 넣기
print(s2.isalpha())#모두 알파벳일경우 True
print(s2.isdigit())#모두 숫자일경우 True

