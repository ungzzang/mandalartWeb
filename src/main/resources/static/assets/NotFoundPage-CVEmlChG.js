import{n as s,u as i,j as t,L as a}from"./index-DRgm4NuZ.js";const o=s.div`
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  display: flex;
  padding: 40px;
  background: #f5f5f5;
  align-items: center;
  z-index: 20;

  .ButtonWrap {
    display: flex;
  }
`;function l(){const n=i(),e=()=>{n(-1)};return t.jsx(o,{children:t.jsxs("div",{children:[t.jsx("h1",{className:"subTitle",children:"요청하신 페이지를 찾을 수 없습니다."}),t.jsxs("div",{className:"ButtonWrap",children:[t.jsx("button",{type:"button",className:"btnLine",onClick:()=>e(),children:"이전 페이지로"}),t.jsx(a,{to:"/",className:"btnColor",children:"메인 페이지로"})]})]})})}export{l as default};
