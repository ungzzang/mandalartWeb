import{n as i,u as h,g as j,r as b,j as s,L as l,l as f,s as w}from"./index-DRgm4NuZ.js";import{u as S}from"./index.esm-BpKNWMCi.js";import{c as y,a as d,o as F}from"./yup-BGCWYPGN.js";import{S as v}from"./SubpageVisual-RTkdiXCS.js";const p="login_session",I=i.div`
  .loginForm {
    max-width: 600px;
    margin: 0px auto;
    padding: 0px 50px;
  }
  .loginForm .inputBox {
    display: block;
    margin-bottom: 5px;
    padding: 0px;
    border: none;
  }
  .loginForm .inputBox label {
    display: inline-block;
    margin: 10px 0px;
  }
  .loginForm .inputBox input {
    width: 100%;
  }
  .loginForm button {
    width: 100%;
    margin: 0px;
  }
`,c=i.p`
  margin-bottom: 10px;
  color: #55ad9b;
  font-size: 13px;
`,N=i.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 20px 0px;
  a {
    color: #666;
  }
  span {
    padding: 0px 10px;
    color: #666;
    font-size: 13px;
  }
`,z=y({userId:d().required("이메일을 입력해 주세요.").email("올바른 이메일 형식이 아닙니다.").matches(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i,"올바른 이메일 형식이 아닙니다."),upw:d().required("비밀번호를 입력해 주세요.").min("8","비밀번호는 최소 8자리 이상 입력하셔야 합니다.")});function Z(){var n,t;const a=h(),m=j(p),{handleSubmit:u,register:o,formState:{errors:r}}=S({defaultValues:{userId:"",upw:""},mode:"onBlur",resolver:F(z)}),x=async g=>{try{const e=await f(g);e.resultData.userId?(w(p,e.resultData),a("/")):alert(e.resultMsg)}catch(e){console.log("로그인 실패:",e)}};return b.useEffect(()=>{m&&a("/")},[]),s.jsxs(s.Fragment,{children:[s.jsx(v,{}),s.jsxs(I,{children:[s.jsx("h1",{className:"subTitle",children:"회원 로그인"}),s.jsx("form",{onSubmit:u(x),children:s.jsxs("div",{className:"loginForm",children:[s.jsxs("div",{className:"inputBox",children:[s.jsx("label",{htmlFor:"email",children:"이메일 아이디"}),s.jsx("input",{type:"text",id:"email",placeholder:"이메일 아이디 입력",maxLength:30,...o("userId")})]}),r.userId&&s.jsxs(c,{children:["(",(n=r.userId)==null?void 0:n.message,")"]}),s.jsxs("div",{className:"inputBox",children:[s.jsx("label",{htmlFor:"password",children:"비밀번호"}),s.jsx("input",{type:"password",id:"password",placeholder:"비밀번호 입력",...o("upw")})]}),r.upw&&s.jsxs(c,{children:["(",(t=r.upw)==null?void 0:t.message,")"]}),s.jsxs(N,{children:[s.jsx(l,{to:"/join",children:"회원가입"}),s.jsx("span",{children:"/"}),s.jsx(l,{to:"/change",children:"비밀번호 찾기"})]}),s.jsx("div",{children:s.jsx("button",{type:"submit",className:"btnColor",children:"로그인"})})]})})]})]})}export{Z as default};
