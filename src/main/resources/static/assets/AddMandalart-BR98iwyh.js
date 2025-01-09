import{n as c,r as n,u as B,g as E,j as e}from"./index-DRgm4NuZ.js";import{u as L,C as k}from"./index.esm-BpKNWMCi.js";import{c as q,a as o,o as C}from"./yup-BGCWYPGN.js";import{R as F}from"./quill.snow-_6xdJk3I.js";import{g as M}from"./myplan-DgqTTbtC.js";import{p as D}from"./share-BEtocycr.js";import"./isEqual-DYK2BPV3.js";const R="login_session",_=c.div`
  max-width: 1200px;
  margin: 0 auto;
  .writeWrap {
    border-top: 1px solid #242424;
  }
  .writeWrap {
    border-top: 1px solid #242424;
  }
  .writeWrap .inputBox input[type="text"] {
    width: 95%;
  }
  .writeWrap .inputBox textarea {
    width: 95%;
    height: 300px;
    padding: 15px 10px;
    resize: vertical;
  }
  .writeWrap select {
    min-width: 40%;
  }
  .ql-editor {
    height: 250px;
  }
  /*
  .writeWrap button {
    width: 100%;
    margin: 0px;
  }
  */
`,l=c.p`
  margin-top: 5px;
  color: #55ad9b;
  font-size: 13px;
`,z=c.div`
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 40px;
  border-top: 0px solid #eee;
`,O=q({title:o().required("제목을 입력해 주세요."),projectId:o().required("공유할 만다라트 계획표를 선택해 주세요."),content:o().required("간단 소개글을 입력해 주세요.")});function A(){var u,h,x,f,m,b;const[j,g]=n.useState([]),d=B(),r=E(R),y={toolbar:{container:[[{header:[1,2,3,4,5,6,!1]}],[{align:[]}],["bold","italic","underline","strike"],[{list:"ordered"},{list:"bullet"}],[{color:["#000000","#e60000","#ff9900","#ffff00","#008a00","#0066cc","#9933ff","#ffffff","#facccc","#ffebcc","#ffffcc","#cce8cc","#cce0f5","#ebd6ff","#bbbbbb","#f06666","#ffc266","#ffff66","#66b966","#66a3e0","#c285ff","#888888","#a10000","#b26b00","#b2b200","#006100","#0047b2","#6b24b2","#444444","#5c0000","#663d00","#666600","#003700","#002966","#3d1466","custom-color"]},{background:[]}]]}},{control:w,register:i,reset:v,handleSubmit:I,setValue:p,formState:{errors:s}}=L({resolver:C(O),defaultValues:{userId:"",title:"",projectId:"",content:""},mode:"all"}),S=async()=>{try{const t=await M({userId:r.userId,subLocation:"/"});g(t.resultData)}catch(t){console.log(t)}},N=()=>{d(-1)},W=async t=>{try{(await D(t)).resultData===1?(alert("공유 만다라트 등록이 완료되었습니다."),d("/share")):alert(`공유 만다라트 등록이 실패되었습니다.
다시 시도해 주세요.`)}catch(a){console.log(a)}};return n.useEffect(()=>{S()},[]),n.useEffect(()=>{p("userId",r.userId&&r.userId)},[r,p]),e.jsx(e.Fragment,{children:e.jsxs(_,{children:[e.jsx("h1",{className:"subTitle",children:"만다라트 공유"}),e.jsxs("form",{onSubmit:I(W),children:[e.jsx("input",{type:"hidden",...i("userId")}),e.jsxs("div",{className:"writeWrap",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{children:["제목 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx("input",{type:"text",...i("title")}),((u=s.title)==null?void 0:u.message)&&e.jsxs(l,{children:["(",(h=s.title)==null?void 0:h.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"share",children:["공유 만다라트 선택 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsxs("select",{id:"share",...i("projectId"),children:[e.jsx("option",{value:"",children:"선택해주세요."}),j.map((t,a)=>t.sharedFg===0&&e.jsx("option",{value:t.projectId,children:t.title},a))]}),((x=s.share)==null?void 0:x.message)&&e.jsxs(l,{children:["(",(f=s.share)==null?void 0:f.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{children:["간단 소개글 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx(k,{name:"content",control:w,rules:{required:"간단 소개글을 입력해 주세요."},render:({field:t})=>e.jsx(F,{modules:y,...t,placeholder:"간단 소개글을 입력해 주세요."})}),((m=s.content)==null?void 0:m.message)&&e.jsxs(l,{children:["(",(b=s.content)==null?void 0:b.message,")"]})]})]})]}),e.jsxs(z,{children:[e.jsx("button",{type:"button",className:"btnLine",onClick:()=>v(),children:"다시작성"}),e.jsx("button",{type:"button",className:"btnLine",onClick:()=>N(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnColor",children:"등록하기"})]})]})]})})}export{A as default};
