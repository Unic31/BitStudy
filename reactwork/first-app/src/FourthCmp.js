import { AddAPhoto, AddAlarm, DeleteForeverRounded, DeleteSharp } from '@mui/icons-material';
import { Button } from '@mui/material';
import React, { useState } from 'react';
import InputEmojiWithRef from 'react-input-emoji';

function FourthCmp(props) {
    //react에서 값을 변경하려면 반드시 useState를 이용해야만 한다
    const [number,setNumber]=useState(1);//number변수에 초기값을 1로 지정
    return (
        <div>
            <h2 className='title'>4번째 컴포넌트</h2>
            <DeleteSharp/>
            <DeleteForeverRounded/>
            <AddAPhoto/>
            <AddAlarm/>

            <InputEmojiWithRef
                style={{width:'200px'}}
                placeholder="메시지를 입력해 주세요"
            />
            <hr/>
            <a className='stylenum'>{number}</a>
            <br/><br/>
            <Button color='success' variant='contained'
            onClick={()=>{
                if(number===0){
                    alert("더이상 감소할 수 없습니다")
                } else {
                    setNumber(number-1)
                }
                
            }}
            >감소</Button>
            <Button color='warning' variant='contained'
            onClick={()=>{
                if(number<10){
                setNumber(number+1);
                } else {
                    alert("더이상 증가할 수 없습니다")
                }
            }}
            >증가</Button>
            
        </div>
    );
}

export default FourthCmp;