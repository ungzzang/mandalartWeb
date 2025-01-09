import{n as s,u as p,r as m,j as e,L as n,o as u,p as h}from"./index-DRgm4NuZ.js";import{u as g}from"./index.esm-BpKNWMCi.js";import{c as f,a as j,o as b}from"./yup-BGCWYPGN.js";import{S as w}from"./SubpageVisual-RTkdiXCS.js";const y=s.div`
  .findPwForm {
    max-width: 600px;
    margin: 0px auto;
    padding: 0px 50px;
  }
  .findPwForm .inputBox {
    display: block;
    margin-bottom: 5px;
    padding: 0px;
    border: none;
  }
  .findPwForm .inputBox label {
    display: inline-block;
    margin: 10px 0px;
  }
  .findPwForm .inputBox input {
    width: 100%;
  }
  .findPwForm button {
    width: 100%;
    margin: 0px;
  }
  .guideText {
    margin-bottom: 20px;
    color: #666;
  }
`,F=s.p`
  margin-bottom: 10px;
  color: #55ad9b;
  font-size: 13px;
`,P=s.div`
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
`,v=s.div`
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(0, 0, 0, 0.5);
  z-index: 100;
`,z=f({userId:j().required("이메일을 입력해 주세요.").email("올바른 이메일 형식이 아닙니다.").matches(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i,"올바른 이메일 형식이 아닙니다.")});function A(){var a;p();const[o,t]=m.useState(!1),{handleSubmit:d,register:l,formState:{errors:i}}=g({defaultValues:{userId:""},mode:"all",resolver:b(z)}),c=async x=>{try{t(!0),(await h(x)).resultData===1?alert("임시 비밀번호가 이메일로 발송되었습니다."):alert(`회원정보가 잘못되었습니다.
다시 확인해 주세요.`),t(!1)}catch(r){console.log("이메일 발송 실패:",r)}};return e.jsxs(e.Fragment,{children:[e.jsx(w,{}),e.jsxs(y,{children:[e.jsx("h1",{className:"subTitle",children:"비밀번호 찾기"}),e.jsxs("div",{className:"findPwForm",children:[e.jsxs("p",{className:"guideText",children:["이메일로 안내된 임시 비밀번호로 회원 로그인 후 [회원정보 수정]을 통해",e.jsx("br",{}),"비밀번호를 반드시 재설정해 주시기 바랍니다."]}),e.jsxs("form",{onSubmit:d(c),children:[e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"email",children:"이메일 아이디"}),e.jsx("input",{type:"text",id:"email",placeholder:"이메일 아이디 입력",maxLength:30,...l("userId")})]}),i.userId&&e.jsxs(F,{children:["(",(a=i.userId)==null?void 0:a.message,")"]}),e.jsxs(P,{children:[e.jsx(n,{to:"/login",children:"로그인"}),e.jsx("span",{children:"/"}),e.jsx(n,{to:"/join",children:"회원가입"})]}),e.jsx("div",{children:e.jsx("button",{type:"submit",className:"btnColor",children:"임시 비밀번호 이메일 발송"})})]}),o&&e.jsx(v,{children:e.jsx(u,{color:"#fff",width:10,height:30,margin:20})})]})]})]})}export{A as default};
