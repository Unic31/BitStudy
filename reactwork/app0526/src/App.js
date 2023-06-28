import './App.css';
import {useState} from "react";
import OneComponents from "./components/OneComponents";
import TwoComponents from "./components/TwoComponents";
import ThreeComponents from "./components/ThreeComponents";
import FourComponents from "./components/FourComponents";
import FiveComponents from "./components/FiveComponents";
import img from "./image/hos.png";
import SixComponents from "./components/SixComponents";
import SevenComponents from "./components/SevenComponents";
import MunjeComponents from "./components/MunjeComponents";

function App() {
    const [idx,setIdx]=useState(1)

    
    //select이벤트
    const changeComponent=(e)=>{
        //alert(e.target.value+typeof(e.target.value))

        //setter 함수가 호출될때마다 자동 렌더링
        setIdx(Number(e.target.value));
    }

    const [xy, setXY] = useState({x: 0, y: 0});

    const handleMouseMove = (e) => {
        setXY({x: e.clientX, y: e.clientY});
    }
  return (
    <div className="App" onMouseMove={(e) => handleMouseMove(e)}>
        <img src={img} style={{position: "absolute", left: Number(xy.x + 20), top:Number(xy.y - 45)}} className="App-logo" alt="jj"/>
      <h2>2023-05-26 리액트 수업</h2>
      <select className='form-select' style={{width:'200px',marginLeft:'100px'}}
      onChange={changeComponent}
      >
        <option value={1}>One Component</option>
        <option value={2}>Two Component</option>
        <option value={3}>Three Component</option>
        <option value={4}>Four Component</option>
        <option value={5}>Five Component</option>
        <option value={6}>Six Component</option>
        <option value={7}>Seven Component</option>
        <option value={8}>Munje Component</option>
      </select>
        <br/><br/>
        {idx===1?<OneComponents/>:idx===2?<TwoComponents/>:idx===3?<ThreeComponents/>:idx===4?<FourComponents/>:idx===5?<FiveComponents/>
            :idx===6?<SixComponents/>:idx===7?<SevenComponents/>:<MunjeComponents/>}
    </div>
  );
}

export default App;
