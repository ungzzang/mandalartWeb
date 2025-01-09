import{n as l,u as E,r as c,b as M,g as B,j as e}from"./index-DRgm4NuZ.js";import{c as k,a as x,o as L}from"./yup-BGCWYPGN.js";import{u as C,C as q}from"./index.esm-BpKNWMCi.js";import{R as D}from"./quill.snow-_6xdJk3I.js";import{g as F}from"./myplan-DgqTTbtC.js";import{k as P,a as R}from"./share-BEtocycr.js";import"./isEqual-DYK2BPV3.js";const V="login_session",_=l.div`
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
  .ql-editor {
    height: 250px;
  }
  /*
  .writeWrap button {
    width: 100%;
    margin: 0px;
  }
  */
`,m=l.p`
  margin-top: 5px;
  color: #55ad9b;
  font-size: 13px;
`,z=l.div`
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 40px;
  border-top: 0px solid #eee;
`,O=k({title:x().required("제목을 입력해 주세요."),content:x().required("간단 소개글을 입력해 주세요.")});function J(){var p,u,f,h;const d=E(),b={toolbar:{container:[[{header:[1,2,3,4,5,6,!1]}],[{align:[]}],["bold","italic","underline","strike"],[{list:"ordered"},{list:"bullet"}],[{color:["#000000","#e60000","#ff9900","#ffff00","#008a00","#0066cc","#9933ff","#ffffff","#facccc","#ffebcc","#ffffcc","#cce8cc","#cce0f5","#ebd6ff","#bbbbbb","#f06666","#ffc266","#ffff66","#66b966","#66a3e0","#c285ff","#888888","#a10000","#b26b00","#b2b200","#006100","#0047b2","#6b24b2","#444444","#5c0000","#663d00","#666600","#003700","#002966","#3d1466","custom-color"]},{background:[]}]]}},[j,g]=c.useState([]),[y,$]=M(),a=y.get("projectId"),r=B(V),{control:I,register:o,reset:w,setValue:n,handleSubmit:S,formState:{errors:i}}=C({resolver:L(O),defaultValues:{title:"",content:"",projectId:"",projectViewId:a},mode:"all"}),v=async()=>{try{const t=await F({userId:r.userId,subLocation:"/"});g(t.resultData)}catch(t){console.log(t)}},N=()=>{d(-1)},W=async t=>{try{(await P(t)).resultData===1?(alert("공유 만다라트 수정이 완료되었습니다."),d("/share")):alert(`공유 만다라트 수정이 실패되었습니다.
다시 시도해 주세요.`)}catch(s){console.log(s)}};return c.useEffect(()=>{v(),n("userId",r.userId&&r.userId),n("projectId",a)},[]),c.useEffect(()=>{(async()=>{try{const s=await R(a,r==null?void 0:r.userId);n("title",s.resultData.title),n("content",s.resultData.content)}catch(s){console.log("검색 실패:",s)}})()},[]),e.jsx(e.Fragment,{children:e.jsxs(_,{children:[e.jsx("h1",{className:"subTitle",children:"만다라트 공유하기"}),e.jsxs("form",{onSubmit:S(W),children:[e.jsx("input",{type:"hidden",...o("userId")}),e.jsx("input",{type:"hidden",...o("projectId")}),e.jsxs("div",{className:"writeWrap",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{children:["제목 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx("input",{type:"text",...o("title")}),((p=i.title)==null?void 0:p.message)&&e.jsxs(m,{children:["(",(u=i.title)==null?void 0:u.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"share",children:["공유 만다라트 선택 ",e.jsx("span",{children:"*"})]}),e.jsx("div",{style:{width:"100%"},children:j.map((t,s)=>t.projectId===parseInt(a)?e.jsx("span",{children:t.title},s):null)})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{children:["간단 소개글 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx(q,{name:"content",control:I,rules:{required:"간단 소개글을 입력해 주세요."},render:({field:t})=>e.jsx(D,{modules:b,...t,placeholder:"간단 소개글을 입력해 주세요."})}),((f=i.content)==null?void 0:f.message)&&e.jsxs(m,{children:["(",(h=i.content)==null?void 0:h.message,")"]})]})]})]}),e.jsxs(z,{children:[e.jsx("button",{type:"button",className:"btnLine",onClick:()=>w(),children:"다시작성"}),e.jsx("button",{type:"button",className:"btnLine",onClick:()=>N(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnColor",children:"수정하기"})]})]})]})})}export{J as default};
