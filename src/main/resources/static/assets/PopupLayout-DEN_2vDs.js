import{n as r,j as o}from"./index-DRgm4NuZ.js";const n=r.div`
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(0, 0, 0, 0.5);
  z-index: 10;

  .modalWrap {
    position: relative;
    max-width: 360px;
    min-width: 320px;
    padding: 25px;
    border-radius: 10px;
    background-color: #fff;
  }
  .modalWrap h2 {
    margin-bottom: 10px;
    font-size: 18px;
    font-weight: 500;
  }

  .modalWrap .guideText {
    color: #666;
    font-size: 14px;
  }
  .modalWrap .inputBox {
    display: block;
    padding: 0px;
    padding-bottom: 15px;
    border: none;
  }
  .modalWrap .inputBox label {
    display: block;
    margin-bottom: 5px;
  }
  .modalWrap .inputBox input[type="text"] {
    width: 100%;
    height: 40px;
    border-radius: 10px;
  }
  .modalWrap .inputBox input[type="date"] {
    width: 100%;
    height: 40px;
    padding: 0px 10px;
    border: none;
    border-radius: 10px;
    background-color: #f0f0f0;
    color: #666;
    font-family: "Noto Sans KR", sans-serif;
  }
  .modalWrap .inputBox input[type="radio"] {
    width: 20px;
    height: 20px;
  }
  .modalWrap .inputBox textarea {
    width: 100%;
    height: 100px;
    padding: 10px 10px;
    border-radius: 10px;
  }
  .modalWrap .buttonWrap {
    display: flex;
    gap: 10px;
  }
  .modalWrap .buttonWrap button {
    width: 50%;
  }
`,x=({isVisible:t,onClose:a,title:p,children:i})=>t?o.jsx(n,{onClick:a,children:o.jsxs("div",{className:"modalWrap",onClick:d=>d.stopPropagation(),children:[p?o.jsx("h2",{children:p}):"",i]})}):null;export{x as P};
