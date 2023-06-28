import React, { useState } from 'react';

function TwoComponents(props) {
    const [message,setMessage]=useState('마우스위치');
    const handleEvent=(e)=>{
        setMessage(`마우스 위치 => X좌표:${e.pageX}, Y좌표:${e.pageY}`)
    }
    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                Two Component 실습
            </h5>
            <div 
                onMouseMove={handleEvent}
            style={{width:'500px',height:'300px',border:'1px solid gray'}}>
                <h5>마우스를 움직이면 좌표가 출력 됩니다</h5>
                <br/><br/>
                <h5>{message}</h5>
            </div>
        </div>
    );
}

export default TwoComponents;