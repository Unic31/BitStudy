var a=0
while(true)
{
    a++;
    if(a%2==1)
    continue; //홀수면 조건식으로 가라->처음으로 돌아가라
    console.log(a);
    if(a==10)
    break;
}
console.log("**반복 끝**")
