import React from "react";
import './MyStyle.css';
import img1 from './image/KakaoTalk_20230411_101803350.jpg'
const SecondCmp=()=>{
    return (
        <div>
            <h2 className="title">두번째 컴포넌트</h2>
            <h3 className="msg1">Happy day</h3>
            <img alt="사진1" src={img1} className="photo1"/>
        </div>
    )
}

export default SecondCmp;