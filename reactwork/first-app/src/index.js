import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
// import FirstCmp from './FirstCmp'
// import {FirstCmp} from './FirstCmp'//default 안하고 export 한건 {} 로 가져온다
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
