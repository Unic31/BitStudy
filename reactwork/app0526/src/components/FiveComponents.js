import React from 'react';

function FiveComponents(props) {
    const names=["장미꽃","안개꽃","다알리아","프리지아","국화꽃"]

    //배열출력방법
    const nameList=names.map((item,idx)=>(<li>{idx}:{item}</li>))
    //배열출력방법2  - 잘안씀
    const arrloop=()=> {
        let arr = [];
        for (let i = 0; i < names.length; i++) {
            arr.push(<h5>{names[i]}</h5>)
        }
        return arr;
    }

    return (
        <div style={{textAlign:'left'}}>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                    Five Component 실습
            </h5>
            {nameList}
            <hr/>
            {arrloop()}
            <hr/>
            {
                //배열출력방법3 직접map 으로 출력
                names.map((item,idx)=>(<h6>{idx}:{item}</h6>))
            }
            <hr/>
            {
                [...new Array(5)].map((item,idx)=><h6>{idx+1}</h6>)
            }
            <hr/>
            {
                [...new Array(7)].map((item,idx)=><div style={{float:'left'}}><img alt='' key={idx} style={{width:'200px',height:'200px'}} src={require(`../image/a${idx+1}.jpg`)}/></div>)
            }
        </div>
    );
}

export default FiveComponents;