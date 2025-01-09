import{n as x,r as o,u as $,g as q,j as e,a as A,t as W,v as z}from"./index-DRgm4NuZ.js";import{c as F,a as m,d as R,o as y}from"./yup-BGCWYPGN.js";import{u as v}from"./index.esm-BpKNWMCi.js";import{P as T}from"./PopupLayout-DEN_2vDs.js";import{S as G}from"./SubpageVisual-RTkdiXCS.js";const J="login_session",K=x.div`
  padding: 0px 50px;

  .joinForm {
    max-width: 1280px;
    min-width: 1100px;
    margin: 0 auto;
    border-top: 1px solid #242424;
  }

  .joinForm label {
    display: inline-block;
    min-width: 160px;
  }
  .joinForm .inputBox {
    display: flex;
    align-items: center;
    padding: 15px 0px;
    border-bottom: 1px solid #eee;
  }
  .joinForm label span {
    color: #ff3300;
    font-weight: 600;
  }
  .joinForm .inputBox input {
    min-width: 300px;
  }
  .joinForm .borderNone {
    border-bottom: none !important;
  }
  .pwdCheck {
    margin-bottom: 20px;
  }
  .pwdCheck input {
    width: 100%;
  }
`,a=x.p`
  margin-left: 10px;
  color: #55ad9b;
  font-size: 13px;
`,Y=x.p`
  margin-left: 10px;
  color: #ff3300;
  font-size: 13px;
`,H=x.div`
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  padding-top: 40px;
  border-top: 1px solid #eee;
  .btnMemberOut {
    position: absolute;
    left: 0px;
    border: none;
    background: none;
    color: #666;
    cursor: pointer;
  }
`,Q=F({upw:m().required("비밀번호는 필수입니다.").min(8,"비밀번호는 8자리 이상입니다."),checkUpw:m().oneOf([R("newUpw")],"비밀번호가 일치하지 않습니다."),nickName:m().required("닉네임은 필수입니다.").min(4,"닉네임은 최소 4글자 이상 입력해주세요.").max(10,"닉네임은 최대 10자까지 가능합니다.")}),X=F({upw:m().required("비밀번호는 필수입니다.").min(8,"비밀번호는 8자리 이상입니다.")});function te(){var g,N,k;const[S,b]=o.useState(!1),[l,c]=o.useState(null),[j,h]=o.useState(!1),d=$(),n=q(J),{userId:p,nickName:I,userPic:C}=n,B=()=>{h(!1)},{register:r,handleSubmit:E,setValue:f,watch:U,formState:{errors:t}}=v({defaultValues:{userId:"",upw:"",newUpw:"",checkUpw:"",nickName:""},mode:"all",resolver:y(Q)}),{register:w,handleSubmit:M,setValue:V}=v({defaultValues:{userId:"",upw:""},resolver:y(X)}),L=()=>{d(-1)},u=U("nickName"),_=async()=>{if(u.length===0){c(null);return}b(!0);try{(await A.get(`api/user/nickName?nickName=${u}`)).data.resultData===1?c(!0):c(!1)}catch(s){console.error("Error nickName:",s),c(null)}finally{b(!1)}},P=async s=>{if(l===null&&u!==(n==null?void 0:n.nickName)){alert("닉네임 중복체크를 진행해 주세요.");return}if(l===!1){alert(`이미 사용중인 닉네임입니다.
닉네임 중복체크를 다시 진행해 주세요.`);return}u===(n==null?void 0:n.nickName)&&(s.nickName="");try{(await W(s)).resultData===1?(alert("회원정보 수정이 완료되었습니다."),d("/")):alert(`회원정보 수정이 실패되었습니다.
다시 시도해 주세요.`)}catch(i){console.log("회원정보 수정 실패:",i)}},O=async s=>{if(!s.upw){alert("비밀번호를 입력해 주세요.");return}try{(await z(s.userId,s.upw)).data?(alert("회원탈퇴가 완료되었습니다."),d("/logout")):alert(`회원탈퇴가 실패되었습니다.
다시 시도해 주세요.`)}catch(i){console.log("회원가입 실패:",i)}};return o.useEffect(()=>(n||(alert("회원 로그인이 필요합니다."),d("/login")),()=>{}),[]),o.useEffect(()=>(f("userId",p),f("nickName",I),V("userId",p),()=>{}),[]),e.jsxs(e.Fragment,{children:[e.jsx(G,{}),e.jsxs(K,{children:[e.jsx("h1",{className:"subTitle",children:"회원정보 수정"}),e.jsx("form",{onSubmit:E(P),children:e.jsxs("div",{className:"joinForm",children:[e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{children:["이메일 ",e.jsx("span",{children:"*"})]}),e.jsx("p",{style:{padding:"10px 0px",color:"#999"},children:p}),e.jsx("input",{type:"hidden",...r("userId")})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"password",children:["현재 비밀번호 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"password",id:"password",maxLength:16,...r("upw")}),t.upw&&e.jsxs(a,{children:["(",(g=t.upw)==null?void 0:g.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"new_password",children:"신규 비밀번호"}),e.jsx("input",{type:"password",id:"new_password",maxLength:16,...r("newUpw")}),t.newUpw&&e.jsxs(a,{children:["(",(N=t.newUpw)==null?void 0:N.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{htmlFor:"new_password_confirm",children:"비밀번호 확인"}),e.jsx("input",{type:"password",id:"new_password_confirm",maxLength:16,...r("checkUpw")}),t.checkUpw&&e.jsxs(a,{children:["(",(k=t.checkUpw)==null?void 0:k.message,")"]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsxs("label",{htmlFor:"nickname",children:["닉네임 ",e.jsx("span",{children:"*"})]}),e.jsx("input",{type:"text",id:"nickname",maxLength:10,...r("nickName")}),e.jsx("button",{type:"button",className:"btnLine",onClick:s=>_(),disabled:S,children:"중복체크"}),t.nickName&&e.jsxs(a,{children:["(",t.nickName.message,")"]}),l===!0&&e.jsx(a,{children:"(사용 가능한 닉네임입니다.)"}),l===!1&&e.jsx(Y,{children:"(이미 사용 중인 닉네임입니다.)"})]}),e.jsxs("div",{className:"inputBox borderNone",children:[e.jsx("label",{htmlFor:"profile",children:"프로필 등록"}),e.jsx("div",{style:{padding:"10px 0px"},children:e.jsx("input",{type:"file",id:"profile",...r("pic")})}),C]}),e.jsxs(H,{children:[e.jsx("button",{type:"button",className:"btnLine",onClick:()=>L(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnColor",children:"정보수정하기"}),e.jsx("button",{type:"button",className:"btnMemberOut",onClick:()=>h(!0),children:"회원탈퇴→"})]})]})}),j&&e.jsx(T,{isVisible:j,onClose:B,title:"회원탈퇴하기",children:e.jsxs("form",{onSubmit:M(O),children:[e.jsx("div",{className:"guideText inputBox",children:"회원을 탈퇴하시면 등록하신 만다라트 계획표 및 공유 게시물이 모두 삭제됩니다. 탈퇴하시겠습니까?"}),e.jsxs("div",{className:"pwdCheck",children:[e.jsx("input",{type:"hidden",...w("userId"),value:p}),e.jsx("input",{type:"password",placeholder:"비밀번호 입력",...w("upw")})]}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>h(!1),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"탈퇴하기"})]})]})})]})]})}export{te as default};
