import React, { useState } from 'react';
import '../App.css';
import cat1 from '../image/a1.jpg'

function OneComponents(props) {
    const [catName1,setCatName1]=useState("쫑이1")
    const [catName2,setCatName2]=useState("쫑이2")
    //출력은 가능하지만 수정은 할수없다.
    let message="Have a Good Day"


    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                One Component 실습
            </h5>
            <h4 className='one two'>{message}</h4>
            <br/>
            <h5>import를 이용해서 src이미지 가져오기</h5>
            <img alt='' src={cat1} width={200}/>
            <b>{catName1}</b>
            <br/>
            <br/>
            <h5>require를 이용해서 src이미지 가져오기</h5>
            <img alt='' src={require(`../image/a2.jpg`)} width={200} />
            <b>{catName2}</b>
            <hr/>
            <div className='input-group'>
                <input type='text' className='form-control' placeholder='첫번째쫑이'
                onKeyUp={(e)=>{
                    setCatName1(e.target.value);
                }} />
                <input type='text' className='form-control' placeholder='두번째쫑이-엔터'
                onKeyUp={(e)=>{
                    if(e.key==='Enter'){
                        setCatName2(e.target.value)
                    }
                }} />
            </div>

        </div>
    );
}

export default OneComponents;