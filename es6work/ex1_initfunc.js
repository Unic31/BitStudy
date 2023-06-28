let f1=()=>"Hello";

console.log(f1())

let f2=(a,b=10)=>a*b;

console.log("3*4는?",f2(3,4))
console.log(f2(5));//a=5,b=10

let f3=(x=1,y=2,z=3)=>x+y+z;

console.log(f3(4))
console.log(f3(10,20))
console.log(f3(10,20,30))
