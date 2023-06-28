import React, {useState} from 'react';
import './MyStyle.css'

function FifthCmp(props) {
    const [name,setName]=useState("캔디");
    const [addr,setAddr]=useState("강남구");

    return (
        <div>
            <h2 className='title'>5번째 컴포넌트</h2>
            <div style={{fontSize:'2em',fontFamily:'Jua'}}>
                이름 : {name}<br/>
                주소 : {addr}
            </div>
            <input type='text' value={name} placeholder='이름입력'
            onChange={(e)=>{
                setName(e.target.value)
            }}
            />
            <br/>
            <input type='text' value={addr} placeholder='주소입력'
            onChange={(e)=>{
                setAddr(e.target.value)
            }}
            />
        </div>
    );
}

export default FifthCmp;
