import React, {useState} from 'react';
import cat1 from '../image/a1.jpg'
import cat2 from '../image/a2.jpg'
import cat3 from '../image/a3.jpg'

function FourComponents(props) {
    const [size,setSize]=useState('20px')
    const changeSize=(e)=>{
        setSize(e.target.value)
    }

    const [bgcolor,setBgcolor]=useState('white')
    const changeBgcolor=(e)=>{
        setBgcolor(e.target.value)
    }

    const [img,setImg]=useState(cat1)
    const changeImg=(e)=>{
        if(img==cat1) {
            setImg(cat2)
        } else if (img==cat2) {
            setImg(cat3)
        } else {
            setImg(cat1)
        }
    }

    const [show,setShow]=useState(true)
    const showImg=(e)=>{
        if(show==true){
            setShow(false)
        } else {
            setShow(true)
        }
    }

    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                    Four Component 실습
            </h5>
            글꼴크기
            <select onClick={changeSize}>
                <option>20px</option>
                <option>30px</option>
                <option>40px</option>
                <option>50px</option>
            </select>
            <br/>
            배경색&nbsp;&nbsp;
            <label>
                <input type='radio' name='bgcolor' onClick={changeBgcolor} defaultValue={'red'}/>빨강
            </label>
            &nbsp;
            <label>
                <input type='radio' name='bgcolor' onClick={changeBgcolor} defaultValue={'blue'} />파랑
            </label>
            &nbsp;
            <label>
                <input type='radio' name='bgcolor' onClick={changeBgcolor} defaultValue={'white'} defaultChecked />흰색
            </label>


            <br/><br/><br/>
            <div style={{fontSize:size,backgroundColor:bgcolor,border:'2px solid gray'}}>오늘은 금요일</div>
            
            사진&nbsp;
            <button onClick={changeImg}>변경</button>
            <input type='checkbox' onClick={showImg}/>숨기기
            <div>
            {
                show &&
            <img alt='' width='300px' src={img} />
            }
            </div>
            
            
            
            
            
            
        </div>
    );
}

export default FourComponents;