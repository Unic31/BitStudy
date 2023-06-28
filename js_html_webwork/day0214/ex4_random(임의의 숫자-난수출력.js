//임의의 숫자를 구한다 Math.random() 
var a=Math.random();
console.log(a);//0.0000~0.9999


console.log("0~9사이의 난수 5개 구하기");
for(let i=1;i<=5;i++){
    let r=parseInt(Math.random()*10);
    console.log(r);
}
console.log("0~99사이의 난수 5개 구하기");
for(let i=1;i<=5;i++){
    let r=parseInt(Math.random()*100);
    console.log(r);
}
console.log("1~45사이의 난수 7개 구하기");
for(let i=1;i<=7;i++){
    let r=parseInt(Math.random()*45)+1;
    console.log(r);
}