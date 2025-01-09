import{n,b as v,g as y,u as w,r as x,j as e,L as p}from"./index-DRgm4NuZ.js";import{c as I,a as h,o as N}from"./yup-BGCWYPGN.js";import{u as S}from"./index.esm-BpKNWMCi.js";import{M as B}from"./Mandalart-CvBjzrqc.js";import"./PopupLayout-DEN_2vDs.js";const E="login_session",F=n.div`
  max-width: 1200px;
  margin: 0 auto;
  .writeWrap {
    border-top: 1px solid #242424;
  }
  .writeWrap .inputBox input[type="text"] {
    width: 95%;
  }
  .writeWrap .inputBox textarea {
    width: 95%;
    height: 100px;
    padding: 15px 10px;
    resize: vertical;
  }
  .guide {
    margin-bottom: 30px;
    color: #666;
    font-size: 14px;
  }
  .guide h4 {
    margin-bottom: 5px;
    color: #242424;
    font-size: 16px;
    font-weight: 500;
  }
`,m=n.p`
  margin-top: 5px;
  color: #55ad9b;
  font-size: 13px;
`,W=n.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-top: 40px;
  border-top: 1px solid #eee;
`,z=I({title:h().required("제목을 입력해 주세요."),content:h().required("간단 소개글을 입력해 주세요.")});function k(){var o,l,d,c;const[u,M]=v(),a=u.get("projectId"),t=y(E),j=w(),{register:s,handleSubmit:g,setValue:i,formState:{errors:r}}=S({resolver:N(z),defaultValues:{userId:"",title:"",content:"",pic:""},mode:"all"}),f=b=>{alert("ok"),console.log(b)};return x.useEffect(()=>{i("projectId",a),i("userId",t.userId&&t.userId)},[t,i]),x.useEffect(()=>(t.userId||(alert("회원 로그인이 필요합니다."),j("/login")),()=>{}),[t]),e.jsx(e.Fragment,{children:e.jsxs(F,{children:[e.jsx("h1",{className:"subTitle",children:"나의 만다라트 등록하기"}),e.jsxs("form",{onSubmit:g(f),children:[e.jsx("input",{type:"hidden",...s("projectId")}),e.jsx("input",{type:"hidden",...s("userId")}),e.jsxs("div",{className:"writeWrap",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"title",children:["제목 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx("input",{type:"text",id:"title",...s("title")}),((o=r.title)==null?void 0:o.message)&&e.jsxs(m,{children:["(",(l=r.title)==null?void 0:l.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"content",children:["간단 소개글 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%",fontSize:"0px"},children:[e.jsx("textarea",{id:"content",placeholder:"간단 소개글을 입력해 주세요.",...s("content")}),((d=r.content)==null?void 0:d.message)&&e.jsxs(m,{children:["(",(c=r.content)==null?void 0:c.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"content",children:"섬네일 등록"}),e.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",width:"79.4%"},children:[e.jsx("input",{type:"file",...s("pic")}),e.jsx("button",{type:"submit",className:"btnColor",children:"저장하기"})]})]})]})]}),e.jsxs("div",{className:"inputBox borderNone",children:[e.jsx("label",{htmlFor:"content",children:"계획표 작성"}),e.jsxs("div",{children:[e.jsxs("div",{className:"guide",children:[e.jsx("h4",{children:"만다라트 계획표 작성 방법"}),"1. 핵심 목표 설정 : 이루고 싶은 가장 중요한 목표를 1개를 설정합니다.",e.jsx("br",{}),"2. 세부 목표 설정 : 핵심 목표를 달성하기 위한 8개의 세부 목표를 설정합니다.",e.jsx("br",{}),"3. 실행 계획 작성 : 각 세부 목표를 달성하기 위한 구체적인 실행 계획을 8개씩 총 64개의 칸에 적습니다.",e.jsx("br",{}),"4. 계획표 관리 : 계획표를 정기적으로 검토하고 수정하며 실행합니다."]}),e.jsx(B,{projectId:a})]})]}),e.jsxs(W,{children:[e.jsx(p,{to:!0,children:"저장"}),e.jsx(p,{to:"/myplan",className:"btnColor",children:"목록으로"})]})]})})}export{k as default};
