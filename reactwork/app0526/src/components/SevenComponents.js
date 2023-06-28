import React, {useState} from 'react';
import '../App.css'

function SevenComponents(props) {
    const [array,setArray]=useState(["red","green","blue","orange"])
    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                Seven Component 실습
            </h5>
            <div>
                <h5>색상을 추가해보세요</h5>
                <h5>(더블클릭시 삭제)</h5>
                <input type='color' defaultValue={'#ccffcc'}
                    onBlur={(e)=>{
                        //리액트는 배열 추가를 concat를 이용해서 추가한다
                        setArray(array.concat(e.target.value))
                }}/>
                <input type='text' placeholder='색상을 입력해 주세요' onKeyUp={(e)=>{
                    if(e.key==='Enter') {
                        setArray(array.concat(e.target.value))
                        e.target.value='';
                    }
                }}/>
            </div>
            <div>
                {
                    array.map((color,idx)=>(
                        <div style={{clear:'both',marginLeft:'100px',width:'200px'}}>
                            <div key={idx} style={{backgroundColor:color}} className='circle' onDoubleClick={(e)=>{
                                alert((idx+1)+"번째 색상 제거완료")
                               setArray(([
                                   ...array.slice(0,idx),
                                   ...array.slice(idx+1,array.length)
                               ]))
                            }}>{idx+1}
                            </div>
                            <span>{color}</span>
                        </div>
                    ))
                }
            </div>
        </div>
    );
}

export default SevenComponents;