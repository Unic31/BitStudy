class Student{
    constructor(name) {
        console.log("생성자 호출")
        this.name=name;

    }
}

//클래스 생성
let s1=new Student("홍길동")
console.log(s1.name)

let s2=new Student("제니퍼")
console.log(s2.name)

//Sawon이라는 클래스
let Sawon=class{
    constructor(name,buseo) {
        this.name=name;
        this.buseo=buseo;
    }

    //멤버 메서드
    printSawon(){
        console.log(`사원명:${this.name}, 부서"${this.buseo}`)
    }

    //정적메소드
    static showTitle(){
        console.log("**회사 직원 명단**")
    }
}

//생성
let sw1=new Sawon("캔디","교육부")
console.log(sw1.name+":"+sw1.buseo)
console.log(`${sw1.name}님은 ${sw1.buseo}에 속해있습니다`)

//메소드 호출
sw1.printSawon()

//정적 메소드 호출
Sawon.showTitle()



