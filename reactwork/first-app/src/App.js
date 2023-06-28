import logo from './logo.svg';
import './App.css';
import { FirstCmp } from './FirstCmp';
import SecondCmp from './SecondCmp';
import ThirdCmp from './ThirdCmp';
import FourthCmp from './FourthCmp';
import FifthCmp from "./FifthCmp";
import {useState} from "react";

function App() {
    const [cmp,setCmp]=useState(1)
    return (
        <div className="App">
            <select onChange={(e)=>{
                setCmp(Number(e.target.value))
            }} value={cmp}>
                <option value={1}>1</option>
                <option value={2}>2</option>
                <option value={3}>3</option>
                <option value={4}>4</option>
                <option value={5}>5</option>
            </select>
            {cmp===1?<FirstCmp/>:cmp===2?<SecondCmp/>:cmp===3?<ThirdCmp/>:cmp===4?<FourthCmp/>:<FifthCmp/>}
        </div>
  );
}

export default App;
