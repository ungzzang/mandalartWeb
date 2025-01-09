import{n as T,b as ee,u as te,g as se,r as o,j as e,F as ne,d as re,e as oe,S as ae,L as F}from"./index-DRgm4NuZ.js";import{p as le}from"./purify.es-CocPUCx9.js";import{c as M,a as R,o as P}from"./yup-BGCWYPGN.js";import{u as E}from"./index.esm-BpKNWMCi.js";import{a as ie,b as ce,c as de,e as pe,d as ue,f as me,h as xe,i as he,j as be}from"./share-BEtocycr.js";import{P as m}from"./PopupLayout-DEN_2vDs.js";import{M as je}from"./Mandalart-CvBjzrqc.js";const fe="login_session",ge=T.div`
  .detailWrap {
    max-width: 1200px;
    margin: 0 auto;
  }
  .detailWrap .borderNone {
    border-bottom: none !important;
  }
  .detailWrap .share {
    margin-left: 10px;
    color: #55ad9b;
    font-weight: 500;
  }
  .detailWrap .inputBox {
    display: flex;
    align-items: center;
    padding: 15px 0px;
    border-bottom: 1px solid #eee;
  }
  .detailWrap .inputBox label {
    display: inline-block;
    min-width: 200px;
  }
  .detailWrap .viewType {
    display: flex;
  }
  .detailWrap .writeComment {
    gap: 0px;
    padding-top: 30px;
    padding-bottom: 0px;
  }
  .detailWrap .writeComment input {
    width: 100%;
  }
  .detailWrap .writeComment button {
    width: 150px;
  }
  .detailWrap .commentList {
    color: #666;
  }
  .detailWrap .commentList li {
    padding: 10px 10px;
    border-bottom: 1px solid #eee;
  }
  .detailWrap .commentList li:last-child {
    border-bottom: none;
  }
  .detailWrap .commentList .date {
    margin-bottom: 5px;
    color: #aaa;
    font-size: 13px;
  }
  .detailWrap .commentList .date button {
    padding: 0px 5px;
    border: none;
    background: none;
    color: #aaa;
    cursor: pointer;
  }
  .detailWrap .content {
    margin: 20px 0px;
  }
  .snsShareWrap {
    position: relative;
    right: 0px;
    button {
      margin-right: 10px;
      border: none;
      background: none;
      font-size: 20px;
      cursor: pointer;
    }
    .shareBox {
      position: absolute;
      top: -17px;
      right: 42px;
      width: 240px;
      padding: 15px;
      border: 1px solid #666;
      border-radius: 10px;
      background: #fff;
    }
    .shareBox h4 {
      margin-bottom: 10px;
      padding: 5px 0px;
      background-color: #f0f0f0;
      border-radius: 8px;
      font-size: 13px;
      font-weight: 400;
      text-align: center;
    }
    .shareBox div {
      display: flex;
      justify-content: space-between;
      gap: 0px;
    }
    .shareBox button {
      width: 80px;
      margin: 0px;
      padding: 10px 5px;
      border-radius: 10px;
      font-size: 15px;
      cursor: pointer;
    }
    .shareBox button:hover {
      background: #f5f5f5;
    }
    .shareBox button span {
      display: flex;
      font-size: 10px;
      justify-content: center;
      align-items: center;
      color: #666;
    }
  }

  .noMember {
    display: flex;
    align-items: center;
    width: 100%;
    height: 50px;
    padding-left: 10px;
    background: #f0f0f0;
    color: #999;
  }
`,ye=T.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-top: 40px;
  border-top: 1px solid #eee;
`,Ne=M({content:R().required("한줄 댓글 내용은 필수입니다.")}),Ce=M({content:R().required("한줄 댓글 내용은 필수입니다.")});function Ve(){const[U,Ie]=ee(),k=te(),r=U.get("projectId"),s=se(fe),[w,z]=o.useState(!1),[c,_]=o.useState([]),[$,l]=o.useState(!1),[i,q]=o.useState([]),[v,x]=o.useState(!1),[S,B]=o.useState(!1),[h,b]=o.useState(""),[W,j]=o.useState(!1),p=()=>{x(!1)},A=async()=>{try{const t=await ie(r,s==null?void 0:s.userId);q(t.resultData),t.resultData.likeFg===1&&l(!0)}catch(t){console.log("검색 실패:",t)}},{register:f,handleSubmit:O,setValue:g,formState:{errors:L}}=E({defaultValues:{userId:"",content:""},mode:"all",resolver:P(Ne)}),{register:y,handleSubmit:X,setValue:N,formState:{errors:V}}=E({defaultValues:{commentId:"",userId:"",content:""},mode:"all",resolver:P(Ce)}),u=async()=>{try{const t=await ce({projectId:r});_(t.resultData.contentList)}catch(t){console.log(t)}},G=async t=>{try{(await de(t)).resultData===1?(alert("한줄 댓글 등록이 완료되었습니다."),u(),g("content","")):alert(`한줄 댓글 작성이 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("한줄 댓글 작성 실패:",n)}},H=async t=>{try{(await pe(t)).resultData===1?(alert("한줄 댓글 수정이 완료되었습니다."),u(),j(!1)):alert(`한줄 댓글 수정이 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("한줄 댓글 수정 실패:",n)}},C=t=>{let n=i.title,I=`http://localhost:5173/share/view?projectId=${r}`,a,d;switch(t){case"FB":d="http://www.facebook.com/sharer/sharer.php?u="+encodeURIComponent(I)+"&t="+encodeURIComponent(n),a=window.open(d,"Facebook",""),a&&a.focus();break;case"TW":d="http://twitter.com/share?text="+encodeURIComponent(n)+" "+encodeURIComponent(I),a=window.open(d,"Twitter",""),a&&a.focus();break;case"NB":d="https://share.naver.com/web/shareView.nhn?url="+encodeURIComponent(I)+"&title="+encodeURIComponent(n),a=window.open(d,"NaverBlog",""),a&&a.focus();break}},K=async t=>{t.preventDefault();try{(await ue({copyProjectId:r,userId:s==null?void 0:s.userId})).data?(alert("만다라트 복제가 완료되었습니다."),k("/myplan")):alert(`만다라트 복제가 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("만다라트 복제 실패:",n)}},Y=async t=>{t.preventDefault();try{(await me({projectId:r,userId:s==null?void 0:s.userId})).resultData===1?(alert("공유 만다라트를 삭제하였습니다."),k("/share")):alert(`공유 만다라트 삭제가 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("공유 만다라트 삭제 실패:",n)}},J=(t,n)=>{j(!0),N("commentId",t),N("userId",s.userId),N("content",n)},Q=async t=>{t.preventDefault();try{(await xe({commentId:h,userId:s.userId})).resultData===1?(alert("공유 만다라트 댓글을 삭제하였습니다."),u(),b()):alert(`공유 만다라트 댓글 삭제가 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("공유 만다라트 댓글 삭제 실패:",n)}},Z=async()=>{try{(await he({projectId:r,userId:s==null?void 0:s.userId})).resultData===1?(alert("좋아요에 등록되었습니다."),l(!0)):(alert(`좋아요에 등록 실패하였습니다.
다시 시도해 주세요.`),l(!1))}catch(t){console.log("좋아요에 등록 실패:",t),l(!1)}},D=async()=>{try{(await be({projectId:r,userId:s==null?void 0:s.userId})).resultData===1?(alert("좋아요 삭제하였습니다."),l(!1)):(alert(`좋아요 삭제가 실패되었습니다.
다시 시도해 주세요.`),l(!0))}catch(t){console.log("좋아요 삭제 실패:",t),l(!0)}};return o.useEffect(()=>{A(),u()},[]),o.useEffect(()=>(g("userId",s==null?void 0:s.userId),g("projectId",r),()=>{})),e.jsxs(ge,{children:[e.jsx("h1",{className:"subTitle",children:"만다라트 공유 상세보기"}),e.jsxs("div",{className:"detailWrap",children:[e.jsxs("div",{className:"inputBox",style:{justifyContent:"space-between"},children:[e.jsxs("div",{children:[e.jsx("label",{children:"제목"}),e.jsx("span",{children:i.title})]}),e.jsxs("div",{className:"snsShareWrap",children:[e.jsx("button",{onClick:()=>z(w!==!0),children:e.jsx(ne,{})}),w===!0?e.jsxs("div",{className:"shareBox",children:[e.jsx("h4",{children:"공유하기"}),e.jsxs("div",{children:[e.jsxs("button",{onClick:()=>C("FB"),children:[e.jsx(re,{})," ",e.jsx("span",{children:"페이스북"})]}),e.jsxs("button",{onClick:()=>C("TW"),children:[e.jsx(oe,{})," ",e.jsx("span",{children:"X (트위터)"})]}),e.jsxs("button",{onClick:()=>C("NB"),children:[e.jsx(ae,{}),e.jsx("span",{children:"네이버 블로그"})]})]})]}):""]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{children:"작성자/작성일"}),e.jsxs("span",{children:[i.nickName," / ",i.createdAt]})]}),e.jsxs("div",{className:"inputBox borderNone",style:{alignItems:"flex-start"},children:[e.jsx("label",{style:{marginTop:"15px"},children:"계획표 보기"}),e.jsxs("div",{children:[e.jsx("div",{children:e.jsx(je,{projectId:r})}),e.jsx("div",{className:"content",dangerouslySetInnerHTML:{__html:le.sanitize(i.content)}})]})]}),s!=null&&s.userId?e.jsxs("div",{className:"inputBox",style:{paddingBottom:"50px",justifyContent:"center"},children:[e.jsx("label",{}),$===!1?e.jsx("button",{className:"btnLine",onClick:()=>Z(),children:"좋아요 👍"}):e.jsx("button",{className:"btnColor",onClick:()=>D(),children:"좋아요 👍"})]}):e.jsx("div",{className:"inputBox"}),e.jsxs("form",{onSubmit:O(G),children:[e.jsx("input",{type:"hidden",...f("userId")}),e.jsx("input",{type:"hidden",...f("projectId")}),e.jsxs("div",{className:"inputBox writeComment borderNone",children:[e.jsx("label",{children:"한줄 댓글 작성하기"}),s!=null&&s.userId?e.jsxs(e.Fragment,{children:[e.jsx("input",{type:"text",placeholder:L.content?L.content.message:"한줄 댓글 내용을 입력하세요.",...f("content")}),e.jsx("button",{type:"submit",className:"btnLine",children:"등록하기"})]}):e.jsxs(e.Fragment,{children:[e.jsx("div",{className:"noMember",children:"한줄 댓글은 회원만 작성하실 수 있습니다."}),e.jsx("button",{type:"button",className:"btnLine",children:"등록하기"})]})]})]}),e.jsxs("div",{className:"inputBox borderNone",children:[e.jsx("label",{}),e.jsxs("ul",{className:"commentList",style:{width:"100%"},children:[(c==null?void 0:c.length)===0&&e.jsx("li",{children:"등록된 댓글이 없습니다."}),c==null?void 0:c.map(t=>e.jsxs("li",{children:[e.jsxs("div",{style:{display:"flex",justifyContent:"space-between"},children:[e.jsxs("div",{className:"date",children:[t.nickName===(s==null?void 0:s.nickName)?e.jsx("span",{style:{color:"#55ad9b",fontWeight:"600"},children:t.nickName}):t.nickName," ","/ ",t.createdAt]}),t.nickName===(s==null?void 0:s.nickName)&&e.jsxs("div",{className:"date",children:[e.jsx("button",{type:"button",onClick:()=>J(t.commentId,t.content),children:"수정"})," ","/"," ",e.jsx("button",{type:"button",onClick:()=>b(t.commentId),children:"삭제"})]})]}),e.jsx("p",{children:t.content})]},t.commentId))]})]}),e.jsxs(ye,{children:[(s==null?void 0:s.userId)&&e.jsxs(e.Fragment,{children:[i.nickName!==(s==null?void 0:s.nickName)&&e.jsx("button",{className:"btnLine",onClick:()=>x(!0),children:"복사하기"}),i.nickName===(s==null?void 0:s.nickName)&&e.jsxs(e.Fragment,{children:[e.jsx("button",{className:"btnLine",onClick:()=>B(!0),children:"삭제하기"}),e.jsx(F,{to:`/share/edit?projectId=${r}`,className:"btnLine",children:"수정하기"})]})]}),e.jsx(F,{to:"/share",className:"btnColor",children:"목록으로"})]})]}),v&&e.jsx(m,{isVisible:v,onClose:p,title:"만다라트 복사하기",children:e.jsxs("form",{onSubmit:t=>K(t),children:[e.jsx("div",{className:"guideText inputBox",children:"해당 만다라트 계획표를 나의 만다라트로 복사하시겠습니까?"}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>x(!1),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"복사하기"})]})]})}),S&&e.jsx(m,{isVisible:S,onClose:p,title:"만다라트 삭제하기",children:e.jsxs("form",{onSubmit:t=>Y(t),children:[e.jsx("div",{className:"guideText inputBox",children:"만다라트 공유글을 삭제하시겠습니까?"}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>B(!1),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"삭제하기"})]})]})}),h!==""&&e.jsx(m,{isVisible:h,onClose:p,title:"한줄 댓글 삭제하기",children:e.jsxs("form",{onSubmit:t=>Q(t),children:[e.jsxs("div",{className:"guideText inputBox",children:["삭제하신 댓글은 복구가 불가능합니다.",e.jsx("br",{}),"작성하신 한줄 댓글을 삭제하시겠습니까?"]}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>b(),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"삭제하기"})]})]})}),W&&e.jsx(m,{isVisible:W,onClose:p,title:"한줄 댓글 수정하기",children:e.jsxs("form",{onSubmit:X(H),children:[e.jsx("input",{type:"hidden",...y("commentId")}),e.jsx("input",{type:"hidden",...y("userId")}),e.jsx("div",{className:"guideText inputBox",children:e.jsx("textarea",{placeholder:V.content?V.content.message:"한줄 댓글을 작성",...y("content")})}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>j(!1),children:"취소하기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"수정하기"})]})]})})]})}export{Ve as default};
