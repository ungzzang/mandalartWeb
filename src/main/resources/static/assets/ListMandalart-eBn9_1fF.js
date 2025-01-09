import{n as j,r as a,u as v,g as T,j as e}from"./index-DRgm4NuZ.js";import{I as M}from"./index-D70tr6L7.js";import{L as E}from"./LoopContent-DZz7jmBf.js";import{u as y}from"./index.esm-BpKNWMCi.js";import{c as L,a as V,o as w}from"./yup-BGCWYPGN.js";import{P as C}from"./PopupLayout-DEN_2vDs.js";import{g as F,p as P,s as k}from"./myplan-DgqTTbtC.js";const B="login_session",_=j.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  min-width: 1200px;
  margin-bottom: 15px;
  padding: 0px 30px 0px 50px;
  select {
    margin-right: 5px;
  }
  input {
    margin-right: 3px;
  }
  .sortType {
    display: flex;
    gap: 20px;
  }
  .sortType span {
    margin-right: 10px;
  }
  .sortType input[type="radio"] {
    display: none;
  }
  .sortType label {
    color: #999;
    cursor: pointer;
  }
  .sortType input[type="radio"]:checked + label {
    border-bottom: 1px solid #242424;
    color: #242424;
  }
  .boardSearch {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  .boardSearch svg {
    margin-top: 2px;
  }
`,$=j.p`
  margin-top: 5px;
  color: #55ad9b;
  font-size: 13px;
`,O=L({title:V().required("제목을 입력해 주세요.").min(5,"최소 5글자 이상 제목을 입력해 주세요.")});function Y(){const[d,u]=a.useState(!1),[o,l]=a.useState([]),i=v(),t=T(B),{handleSubmit:g,register:c,setValue:n,formState:{errors:m}}=y({defaultValues:{userId:"",title:"",content:""},mode:"all",resolver:w(O)}),{handleSubmit:f,register:p,setValue:x}=y({defaultValues:{userId:"",sort:"date",type:"1",searchText:""},mode:"all"}),S=async()=>{try{const r=await F({userId:t.userId,subLocation:""});l(r.resultData)}catch(r){console.log(r)}},I=async r=>{try{const s=await P(r);s.resultData.projectId&&i(`/myplan/edit?projectId=${s.resultData.projectId}`)}catch(s){console.log("만다라트 생성 실패:",s)}},N=async r=>{try{const s=await k(r),b=s.statusCode.toString().charAt(0);b==="2"&&l(s.resultData),b==="4"&&l([])}catch(s){console.log("검색 실패:",s)}},h=()=>{n("title",""),n("content",""),u(!1)};return a.useEffect(()=>{if(!(t!=null&&t.userId)){alert("회원 로그인이 필요합니다."),i("/login?url=/myplan");return}return()=>{}},[t,i]),a.useEffect(()=>{n("userId",(t==null?void 0:t.userId)&&t.userId)},[t,n]),a.useEffect(()=>{x("userId",(t==null?void 0:t.userId)&&t.userId)},[x,t]),a.useEffect(()=>{S()},[]),e.jsxs(e.Fragment,{children:[e.jsx("h1",{className:"subTitle",children:"나의 만다라트"}),e.jsxs("form",{onSubmit:f(N),children:[e.jsx("input",{type:"hidden",...p("userId")}),e.jsxs(_,{children:[e.jsx("div",{className:"sortType",children:e.jsxs("span",{children:["[전체 : ",o==null?void 0:o.length,"건]"]})}),e.jsxs("div",{className:"boardSearch",children:[e.jsxs("select",{...p("searchFilter"),children:[e.jsx("option",{value:"1",children:"제목"}),e.jsx("option",{value:"2",children:"내용"}),e.jsx("option",{value:"3",children:"제목+내용"})]}),e.jsx("input",{type:"text",maxLength:"20",placeholder:"검색어를 입력하세요.",...p("searchText")}),e.jsxs("button",{type:"submit",className:"btnLine",children:[e.jsx(M,{})," 검색"]}),e.jsx("button",{type:"button",className:"btnColor",onClick:()=>u(!0),children:"+ 등록하기"})]})]})]}),e.jsx(E,{location:"myplan",datas:o}),d&&e.jsx(C,{isVisible:d,onClose:h,title:"",children:e.jsxs("form",{onSubmit:g(I),children:[e.jsx("input",{type:"hidden",...c("userId")}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"title",children:"만다라트 제목 입력"}),e.jsx("input",{type:"text",id:"title",maxLength:30,className:"popupInput",placeholder:"제목을 입력하세요.",...c("title")}),m.title&&e.jsxs($,{children:["(",m.title.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"content",children:"만다라트 간단 설명"}),e.jsx("textarea",{id:"content",className:"popupTextarea",placeholder:"간단설명을 입력하세요.",...c("content")})]}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:r=>h(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"등록하기"})]})]})})]})}export{Y as default};
