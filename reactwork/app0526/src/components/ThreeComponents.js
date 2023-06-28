import React, { useState } from 'react';
import mycat from '../image/a4.jpg'

function ThreeComponents(props) {
    const [name,setName]=useState('')
    const [score,setScore]=useState(0)
    const [grade,setGrade]=useState('')
    const [tcolor,setTcolor]=useState('green')
    const [show,setShow]=useState(true)

    //radio click 이벤트
    const radioChangeColor=(e)=>{
        setTcolor(e.target.value)
    }

    //이름 변경시 바로 적용
    const changeName=(e)=>{
        setName(e.target.value)
    }

    //점수 입력시 바로 적용-숫자가 아닐경우 경고 후 종료
    const changeScore=(e)=>{
        if(isNaN(e.target.value)){
            alert("숫자만 입력하세요")
            e.target.value='';
            return;
        }
        setScore(Number(e.target.value))
    }

    //등급계산
    const gradeClick=(e)=>{
        if(score>=90){
            setGrade("참 잘했어요")
        } else if(score>=80){
            setGrade("잘했어요")
        } else {
            setGrade("했어요")
        }
    }

    
    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                Three Component 실습
            </h5>
            <h6>글자색을 선택하세요</h6>
            <div>
                <label>
                    <input type='radio' name='tcolor' defaultValue={'red'} onClick={radioChangeColor} />빨강색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='tcolor' defaultValue={'green'} onClick={radioChangeColor} defaultChecked />초록색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='tcolor' defaultValue={'magenta'} onClick={radioChangeColor} />핑크색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' name='tcolor' defaultValue={'black'} onClick={radioChangeColor} />검정색
                </label>
            </div>
            <div className='input-group' style={{marginTop:'30px',fontSize:'20px'}}>
                <b>이름 : </b>
                <input type='text' className='form-control' onChange={changeName} />
                &nbsp;&nbsp;
                <b>점수 : </b>
                <input type='text' className='form-control' onChange={changeScore}/>
                <button className='btn btn-outline-danger btn-sm' onClick={gradeClick}>등급계산</button>
            </div>
            <div style={{marginTop:'30px',fontSize:'20px',width:'300px',textAlign:'left',color:tcolor}}>
                
                이름 : {name}<br/>
                점수 : {score}점<br/>
                등급 : {grade}<br/>

            </div>
            <h5>사진 보였다/숨겼다 하기</h5>
            <label>
                <input type='checkbox' defaultChecked onClick={(e)=>{
                    setShow(e.target.checked)
                }} />&nbsp;사진 보이게 하기
            </label>
            <br/><br/>
            {
                show &&
            <img alt='' src={mycat} width={300} border='10'/>
            }


        </div>
    );
}

export default ThreeComponents;