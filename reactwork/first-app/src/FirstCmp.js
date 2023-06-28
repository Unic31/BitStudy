import React,{Component} from "react";
import img1 from './image/KakaoTalk_20230411_101803350_01.jpg';
import img2 from './image/KakaoTalk_20230411_101803350_02.jpg';

//class로 컴포넌트 생성하기
class FirstCmp extends Component{
    render(){
        return (
            <div>
                <h2 style={{color:'green',border:'2px solid orange',backgroundColor:'pink'}}>
                    React 첫 컴포넌트
                </h2>
                <h6>src의 이미지 나타내기</h6>
                <img style={{width:'200px'}} alt="이미지1" src={img1}/>
                <img style={{width:'200px'}} alt="이미지2" src={img2}/>
                <h6>public의 이미지 나타내기</h6>
                <img style={{width:'200px'}} alt="이미지3" src="KakaoTalk_20230411_113150132_02.jpg" />
                
                </div>
        )
    }
}
//default 로 export 할 경우 import 시에 이름을 마음대로 정할수있다
//export default 는 파일 내에서 한번만 가능하다
//export default FirstCmp;

//이렇게 export 한 경우 import 할때 반드시 같은 이름으로만 가능
export {FirstCmp}