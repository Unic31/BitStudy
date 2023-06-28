import React, {useState} from 'react';

function MunjeComponents(props) {
    const [img,setImg]=useState('1')
    const selectImg=(e)=>{
        setImg(e.target.value)
    }


    const [show,setShow]=useState(true)
    const showImg=(e)=>{
        if(show==true){
            setShow(false)
        } else {
            setShow(true)
        }
    }
    const [text,setText]=useState('')
    const changeText=(e)=>{
        setText(e.target.value)
    }
    
    const [line,setLine]=useState('solid')
    const changeLine=(e)=>{
        setLine(e.target.value)
    }

        const [size,setSize]=useState(300)
        
        const psize=(e)=>{
            setSize(size+50)
        }
        const msize=(e)=>{
            setSize(size-50)
        }


    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                Munje Component 실습{size}
            </h5>
            <input type='checkbox' onClick={showImg}/>사진숨김 &nbsp;
            <button onClick={psize}>크게</button>&nbsp;
            <button onClick={msize}>작게</button>
            <br/>
            <input style={{width:'400px'}} type='text' onChange={changeText}/>
            <br/>
            <select style={{clear:'both',width:'100px'}} onChange={selectImg}>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select>
            <br/>
            <select style={{clear:'both',width:'100px'}} onChange={changeLine}>
                <option>solid</option>
                <option>dotted</option>
                <option>none</option>
                <option>double</option>
            </select>
            <div style={{border:`5px ${line} black`,width:`${size}px`,height:'400px',margin:'0 auto'}}>
                {
                    show &&
                    <img alt='' style={{width:'100%',height:'100%'}} src={require(`../image/a${img}.jpg`)}/>
                }
            </div>
            <div style={{border:'2px solid black',width:'400px',height:'100px',margin:'0 auto',textAlign:'center'}}>
                {text}
            </div>

        </div>
    );
}

export default MunjeComponents;
