import React from 'react';
import '../App.css'

function SixComponents(props) {
    const array1=["red","green","blue","orange","gray","pink","white","yellow"]
    const array2=[
        {"catphoto":"a1.jpg","catname":"쫑이1","catcute":"귀여움1"},
        {"catphoto":"a2.jpg","catname":"쫑이2","catcute":"귀여움2"},
        {"catphoto":"a3.jpg","catname":"쫑이3","catcute":"귀여움3"},
        {"catphoto":"a4.jpg","catname":"쫑이4","catcute":"귀여움4"},
        {"catphoto":"a5.jpg","catname":"쫑이5","catcute":"귀여움5"},
        {"catphoto":"a6.jpg","catname":"쫑이6","catcute":"귀여움6"},
        {"catphoto":"a7.jpg","catname":"쫑이7","catcute":"귀여움7"}
    ]

    return (
        <div>
            <h5 style={{border:'3px solid gray',backgroundColor:'#add826'}}>
                Six Component 실습
            </h5>
            <div>
                <h6>array1 배열 출력하기</h6>
                {
                    array1.map((color,idx)=>(
                        <div key={idx} style={{backgroundColor:color}} className='circle'>
                            {idx}
                        </div>
                    ))
                }
            </div>
            <br/><br/><br/>
            <div>
                <h6>array2배열 출력하기</h6>
                {
                    array2.map((cat,idx)=>(
                        <div className='photo' key={idx} >
                            <figure>
                            <img src={require(`../image/${cat.catphoto}`)}/>
                            <figcaption>
                                {cat.catcute}<br/>{cat.catname}
                            </figcaption>
                            </figure>
                        </div>
                    ))
                }
            </div>
        </div>
    );
}

export default SixComponents;
