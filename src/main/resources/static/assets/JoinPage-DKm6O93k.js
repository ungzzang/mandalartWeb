import{n as t,r as a,u as Z,j as e,o as q,a as I,q as U}from"./index-DRgm4NuZ.js";import{c as M,a as c,d as W,e as D,o as J}from"./yup-BGCWYPGN.js";import{u as O}from"./index.esm-BpKNWMCi.js";import{S as R}from"./SubpageVisual-RTkdiXCS.js";const V=t.div`
  padding: 0px 50px;

  .joinForm {
    max-width: 1280px;
    min-width: 1100px;
    margin: 0 auto;
    border-top: 1px solid #242424;
  }

  label {
    display: inline-block;
    min-width: 160px;
  }
  .inputBox {
    display: flex;
    align-items: center;
    padding: 15px 0px;
    border-bottom: 1px solid #eee;
  }
  label span {
    color: #ff3300;
    font-weight: 600;
  }
  .inputBox input {
    min-width: 300px;
  }
`,i=t.p`
  margin-left: 10px;
  color: #55ad9b;
  font-size: 13px;
`,z=t.p`
  margin-left: 10px;
  color: #ff3300;
  font-size: 13px;
`,P=t.div`
  margin: 40px 0px;
  border: none;
  h2 {
    margin-bottom: 10px;
    font-size: 16px;
    font-weight: 400;
  }
  .privercy {
    height: 200px;
    margin-bottom: 10px;
    padding: 20px;
    border: 1px solid #ddd;
    color: #666;
    font-size: 14px;
    overflow-x: hidden;
    overflow-y: auto;
  }
  .checkAgree {
    display: flex;
    align-items: center;
  }
  .checkAgree label {
    margin-right: 5px;
  }
  .checkAgree input {
    width: 20px;
    height: 20px;
    margin-right: 5px;
  }
`,T=t.div`
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
`,G=t.div`
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 40px;
  border-top: 1px solid #eee;
`,H=M({userId:c().required("이메일은 필수입니다.").email("올바른 이메일 형식이 아닙니다.").matches(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i,"올바른 이메일 형식이 아닙니다."),upw:c().required("비밀번호는 필수입니다.").min(8,"비밀번호는 최소 8자 이상입니다.").max(16,"비밀번호는 최대 16자까지 가능합니다.").matches(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/,"비밀번호는 영어/숫자/특수문자 포함 8자리 이상으로 입력해 주세요."),upw_confirm:c().required("비밀번호 확인은 필수입니다.").oneOf([W("upw")],"비밀번호가 일치하지 않습니다."),nickName:c().required("닉네임은 필수입니다.").min(4,"닉네임은 최소 4글자 이상 입력해 주세요.").max(10,"닉네임은 최대 10자까지 가능합니다."),policy:D().oneOf([!0],"필수")});function ee(){var y,k,w,N,v;const[L,p]=a.useState(!1),[d,l]=a.useState(null),[m,u]=a.useState(!1),[x,o]=a.useState(null),[S,h]=a.useState(!1),j=Z(),{handleSubmit:F,register:n,reset:_,watch:b,formState:{errors:s}}=O({defaultValues:{userId:"",upw:"",upw_confirm:"",nickName:"",policy:!1},mode:"all",resolver:J(H)}),$=()=>{j(-1)},f=b("userId"),B=async()=>{if(f.length===0){l(null);return}p(!0);try{(await I.get(`api/user/email?userId=${f}`)).data.resultData===1?l(!0):l(!1)}catch(r){console.error("Error user_id:",r),l(null)}finally{p(!1)}},g=b("nickName"),C=async()=>{if(g.length===0){o(null);return}u(!0);try{(await I.get(`api/user/nickName?nickName=${g}`)).data.resultData===1?o(!0):o(!1)}catch(r){console.error("Error nickName:",r),o(null)}finally{u(!1)}},E=async r=>{if(d===!1){alert(`이미 사용중인 아이디입니다.
아이디 중복체크를 다시 진행해 주세요.`);return}if(x===!1){alert(`이미 사용중인 닉네임입니다.
닉네임 중복체크를 다시 진행해 주세요.`);return}try{h(!0),(await U(r)).data?j("/joinEnd"):alert(`회원가입이 실패되었습니다.
다시 시도해 주세요.`),h(!1)}catch(A){console.log("회원가입 실패:",A)}};return e.jsxs(e.Fragment,{children:[e.jsx(R,{}),e.jsxs(V,{children:[e.jsx("h1",{className:"subTitle",children:"회원가입"}),e.jsx("form",{onSubmit:F(E),children:e.jsxs("div",{className:"joinForm",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"email",children:["이메일 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"text",id:"email",maxLength:30,...n("userId")}),e.jsx("button",{type:"button",className:"btnLine",onClick:r=>B(),disabled:L,children:"중복체크"}),s.userId&&e.jsxs(i,{children:["(",(y=s.userId)==null?void 0:y.message,")"]}),d===!0&&e.jsx(i,{children:"(사용 가능한 이메일입니다.)"}),d===!1&&e.jsx(z,{children:"(이미 사용 중인 이메일입니다.)"})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"password",children:["비밀번호 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"password",id:"password",maxLength:16,...n("upw")}),s.upw&&e.jsxs(i,{children:["(",(k=s.upw)==null?void 0:k.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"password_confirm",children:["비밀번호 확인 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"password",id:"password_confirm",maxLength:16,...n("upw_confirm")}),s.upw_confirm&&e.jsxs(i,{children:["(",(w=s.upw_confirm)==null?void 0:w.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"nickname",children:["닉네임 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"text",id:"nickname",maxLength:10,disabled:m,...n("nickName")}),e.jsx("button",{type:"button",className:"btnLine",onClick:r=>C(),disabled:m,children:"중복체크"}),s.nickName&&e.jsxs(i,{children:["(",(N=s.nickName)==null?void 0:N.message,")"]}),x===!0&&e.jsx(i,{children:"(사용 가능한 닉네임입니다.)"}),x===!1&&e.jsx(z,{children:"(이미 사용 중인 닉네임입니다.)"})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"profile",children:"프로필 등록"}),e.jsx("div",{style:{padding:"10px 0px"},children:e.jsx("input",{type:"file",id:"profile",...n("pic")})})]}),e.jsxs(P,{children:[e.jsx("h2",{children:"[필수] 개인정보처리방침"}),e.jsxs("div",{className:"privercy",children:["개인정보 취급방침",e.jsx("br",{}),e.jsx("br",{}),"1. 개인정보 수집 항목",e.jsx("br",{}),"해당 서비서는 회원가입, 서비스 제공 등을 위해 다음과 같은 개인정보를 수집합니다.",e.jsx("br",{}),e.jsx("br",{}),"필수 항목: 이메일 주소, 닉네임",e.jsx("br",{}),"선택 항목: 없음",e.jsx("br",{}),e.jsx("br",{}),"2. 개인정보 수집 및 이용 목적",e.jsx("br",{}),"당사는 수집한 개인정보를 다음의 목적을 위해 사용합니다.",e.jsx("br",{}),"- 회원 가입 및 관리",e.jsx("br",{}),"- 고객 서비스 제공 및 피드백 처리",e.jsx("br",{}),e.jsx("br",{}),"3. 개인정보 보유 및 이용 기간",e.jsx("br",{}),"당사는 개인정보를 수집한 목적을 달성할 때까지 보유합니다.",e.jsx("br",{}),"회원 탈퇴 시 또는 서비스 이용을 중지한 경우, 관련 법령에 따라 일정 기간 보유할 수 있습니다.",e.jsx("br",{}),e.jsx("br",{}),"4. 개인정보 제공",e.jsx("br",{}),"당사는 원칙적으로 사용자의 개인정보를 제3자에게 제공하지 않습니다. 다만, 법령에 의하거나, 서비스 제공에 필요한 경우 (예: 배송업체, 결제 서비스 제공업체 등) 필요한 최소한의 정보를 제공할 수 있습니다.",e.jsx("br",{}),e.jsx("br",{}),"5. 개인정보 보호",e.jsx("br",{}),"당사는 개인정보 보호를 위해 안전한 기술적, 관리적 조치를 취하고 있습니다.",e.jsx("br",{}),e.jsx("br",{}),"개인정보 암호화 및 접근 제어",e.jsx("br",{}),"내부 개인정보 관리자의 교육",e.jsx("br",{}),"6. 이용자 및 법정대리인의 권리와 행사 방법",e.jsx("br",{}),e.jsx("br",{}),"사용자는 언제든지 자신의 개인정보를 조회하거나 수정할 수 있으며, 개인정보 삭제를 요청할 수 있습니다.",e.jsx("br",{}),"개인정보 수집 및 이용에 동의한 경우에도 언제든지 철회할 수 있습니다.",e.jsx("br",{}),e.jsx("br",{}),"7. 개인정보 처리방침 변경",e.jsx("br",{}),"이 개인정보 처리방침은 관련 법령 및 회사 정책에 따라 변경될 수 있으며, 변경 시에는 즉시 공지합니다.",e.jsx("br",{}),e.jsx("br",{}),"8. 연락처",e.jsx("br",{}),"회사명: [회사명]",e.jsx("br",{}),"전화번호: [전화번호]",e.jsx("br",{}),"이메일: [이메일 주소]",e.jsx("br",{}),"주소: [회사 주소]"]}),e.jsxs("div",{className:"checkAgree",children:[e.jsx("input",{type:"checkbox",id:"agreement",...n("policy")}),e.jsx("label",{htmlFor:"agreement",children:"개인정보 취급방침에 동의합니다."}),s.policy&&e.jsxs(i,{children:["(",(v=s.policy)==null?void 0:v.message,")"]})]})]}),e.jsxs(G,{children:[e.jsx("button",{type:"button",className:"btnLine",onClick:()=>_(),children:"다시작성"}),e.jsx("button",{type:"button",className:"btnLine",onClick:()=>$(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnColor",children:"회원가입하기"})]})]})}),S&&e.jsx(T,{children:e.jsx(q,{color:"#fff",width:10,height:30,margin:20})})]})]})}export{ee as default};
