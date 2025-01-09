import{n as x,b as S,u as w,g as F,r as o,j as e,L as M}from"./index-DRgm4NuZ.js";import{u as D}from"./index.esm-BpKNWMCi.js";import{c as W,a as B,b as E,o as z}from"./yup-BGCWYPGN.js";import{P as L}from"./PopupLayout-DEN_2vDs.js";import{e as V,a as C}from"./myplan-DgqTTbtC.js";import{M as k}from"./Mandalart-CvBjzrqc.js";const q="login_session",_=x.div`
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
`,p=x.p`
  margin-top: 5px;
  color: #55ad9b;
  font-size: 13px;
`,$=x.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-top: 40px;
  border-top: 1px solid #eee;
`,A=W({title:B().required("제목을 입력해 주세요.").max(20,"제목은 최대 20자까지 입력가능합니다."),content:B().required("간단 소개글을 입력해 주세요."),pic:E().test("required","섬네일 이미지를 첨부해 주세요.",s=>s&&s.length>0).test("fileType","1MB 이하의 이미지(jpg, gif, png) 파일만 첨부가능합니다.",s=>{var n;return s&&["image/gif","image/jpeg","image/png"].includes((n=s[0])==null?void 0:n.type)}).test("filesize","파일 크기는 1MB 이하만 가능합니다.",s=>{var n;return s&&((n=s[0])==null?void 0:n.size)<=1*1024*1024})});function H(){var g,b,f,y,v,N;const[s,n]=S(),d=w(),c=s.get("projectId"),r=F(q),[u,h]=o.useState(!1),P=()=>{h(!1)},{register:t,handleSubmit:m,setValue:l,formState:{errors:a}}=D({resolver:z(A),defaultValues:{userId:"",title:"",content:"",pic:""},mode:"all"}),j=async I=>{try{(await V(I)).resultData===1?(alert("나의 만다라트 수정이 완료되었습니다."),d("/myplan")):alert(`나의 만다라트 수정이 실패되었습니다.
다시 시도해 주세요.`)}catch(i){console.log(i)}};return o.useEffect(()=>(r.userId||(alert("회원 로그인이 필요합니다."),d("/login")),()=>{}),[r,d]),o.useEffect(()=>{(async()=>{try{const i=await C(c);l("title",i.resultData.title),l("content",i.resultData.content)}catch(i){console.log("검색 실패:",i)}})()},[]),o.useEffect(()=>{l("projectId",c),l("userId",r.userId&&r.userId)},[r,l]),e.jsxs(e.Fragment,{children:[e.jsxs(_,{children:[e.jsx("h1",{className:"subTitle",children:"나의 만다라트 수정하기"}),e.jsxs("form",{onSubmit:m(j),children:[e.jsx("input",{type:"hidden",...t("projectId")}),e.jsx("input",{type:"hidden",...t("userId")}),e.jsxs("div",{className:"writeWrap",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"title",children:["제목 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%"},children:[e.jsx("input",{type:"text",id:"title",maxLength:20,...t("title")}),((g=a.title)==null?void 0:g.message)&&e.jsxs(p,{children:["(",(b=a.title)==null?void 0:b.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"content",children:["간단 설명 ",e.jsx("span",{children:"*"})]}),e.jsxs("div",{style:{width:"100%",fontSize:"0px"},children:[e.jsx("textarea",{id:"content",placeholder:"간단 설명을 입력해 주세요.",...t("content")}),((f=a.content)==null?void 0:f.message)&&e.jsxs(p,{children:["(",(y=a.content)==null?void 0:y.message,")"]})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"content",children:["섬네일 등록 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"file",...t("pic")}),((v=a.pic)==null?void 0:v.message)&&e.jsxs(p,{children:["(",(N=a.pic)==null?void 0:N.message,")"]})]})]})]}),e.jsxs("div",{className:"inputBox borderNone",children:[e.jsx("label",{htmlFor:"content",children:"계획표 작성"}),e.jsxs("div",{children:[e.jsxs("div",{className:"guide",children:[e.jsx("h4",{children:"만다라트 계획표 작성 방법"}),"1. 핵심 목표 설정 : 이루고 싶은 가장 중요한 목표를 1개를 설정합니다.",e.jsx("br",{}),"2. 세부 목표 설정 : 핵심 목표를 달성하기 위한 8개의 세부 목표를 설정합니다.",e.jsx("br",{}),"3. 실행 계획 작성 : 각 세부 목표를 달성하기 위한 구체적인 실행 계획을 8개씩 총 64개의 칸에 적습니다.",e.jsx("br",{}),"4. 계획표 관리 : 계획표를 정기적으로 검토하고 수정하며 실행합니다."]}),e.jsx("div",{children:e.jsx(k,{projectId:c})})]})]}),e.jsxs($,{children:[e.jsx("button",{type:"button",className:"btnColor",onClick:m(j),children:"저장하기"}),e.jsx(M,{to:"/myplan",className:"btnLine",children:"목록으로"})]})]}),u&&e.jsx(L,{isVisible:u,onClose:P,title:"",children:e.jsxs("form",{children:[e.jsx("input",{type:"hidden",value:"1",...t("idx")}),e.jsx("input",{type:"hidden",value:"test@test.com",...t("mid")}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"titlePop",children:["실천목표 입력",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"text",id:"titlePop",...t("titlePop")})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"startDate",children:"시작일"}),e.jsx("input",{type:"date",id:"startDate",...t("startDate")})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"endDate",children:"종료일"}),e.jsx("input",{type:"date",id:"endDate",...t("endDate")})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"contentPop",children:"세부내용 작성"}),e.jsx("textarea",{id:"contentPop",placeholder:"내용을 입력하세요.",...t("contentPop")})]}),e.jsxs("div",{className:"inputBox",style:{display:"flex"},children:[e.jsx("label",{style:{minWidth:"auto",margin:"0px 20px 0px 0px"},children:"달성 여부"}),e.jsx("input",{type:"radio",value:"0",id:"value0",...t("success"),checked:!0})," ",e.jsx("label",{htmlFor:"value0",style:{minWidth:"auto",margin:"0px"},children:"진행중"})," ","    ",e.jsx("input",{type:"radio",value:"1",name:"success",id:"value1",...t("success")})," ",e.jsx("label",{htmlFor:"value1",style:{minWidth:"auto",margin:"0px"},children:"달성 완료"})]}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>h(!1),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"저장하기"})]})]})})]})}export{H as default};
