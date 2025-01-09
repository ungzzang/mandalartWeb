import{n as d,b as w,u as M,g as D,r as l,j as e,L as r}from"./index-DRgm4NuZ.js";import"./nivo-pie.es-BQqOF-X_.js";import{P as I}from"./PopupLayout-DEN_2vDs.js";import{a as C,d as S}from"./myplan-DgqTTbtC.js";import{F as P,i as V}from"./index-D0Qt9kL9.js";import"./index-D2dJIdCi.js";import"./isEqual-DYK2BPV3.js";const W="login_session",B=d.div`
  .detailWrap {
    max-width: 1200px;
    margin: 0 auto;
    border-top: 1px solid #242424;
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
    padding: 20px 0px;
    border-bottom: 1px solid #eee;
  }
  .detailWrap .inputBox label {
    display: inline-block;
    min-width: 200px;
  }
  .detailWrap .viewType {
    display: flex;
  }
  .detailWrap .content {
    margin: 20px 0px;
  }
  .viewCalendar {
    margin-bottom: 30px;
  }
  .fc-h-event {
    border: none;
  }
  .fc-h-event .fc-event-main {
    padding-left: 10px;
    color: #444;
    font-weight: 500;
  }
`,L=d.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-top: 40px;
  border-top: 1px solid #eee;
`;function O(){const[c,k]=w(),p=M(),a=c.get("projectId"),m=D(W),[s,x]=l.useState([]),[h,u]=l.useState([]),[o,i]=l.useState(!1),b=()=>{i(!1)},j=async()=>{try{const t=await C(a);x(t.resultData),u(t.resultData.mandalart)}catch(t){console.log("검색 실패:",t)}},f=()=>{const t=Math.floor(Math.random()*128+127),n=Math.floor(Math.random()*128+127),N=Math.floor(Math.random()*128+127);return`rgb(${t},${n},${N})`},g=t=>({id:t.mandalartId,title:t.title,start:t.startDate||null,end:t.finishDate||null,description:t.contents||null,backgroundColor:f()}),y=h.filter(t=>t.depth===1).map(g),v=async t=>{t.preventDefault();try{(await S({projectId:a,userId:m.userId})).resultData===1?(alert("나의 만다라트 계획표를 삭제하였습니다."),p("/myplan")):alert(`나의 만다라트 계획표 삭제가 실패되었습니다.
다시 시도해 주세요.`)}catch(n){console.log("나의 만다라트 계획표 삭제 실패:",n)}};return l.useEffect(()=>{j()},[]),e.jsxs(B,{children:[e.jsx("h1",{className:"subTitle",children:"나의 만다라트 상세보기"}),e.jsxs("div",{className:"detailWrap",children:[e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{children:"제목"}),e.jsxs("span",{children:[s.title,s.sharedFg===1&&e.jsx("span",{className:"share",children:"[공유중]"})]})]}),e.jsxs("div",{className:"inputBox",children:[e.jsx("label",{children:"작성자/작성일"}),e.jsxs("span",{children:[s.nickName," / ",s.createdAt]})]}),e.jsxs("div",{className:"inputBox borderNone",style:{alignItems:"flex-start"},children:[e.jsx("label",{children:"계획표 보기"}),e.jsxs("div",{className:"viewType",children:[e.jsx(r,{to:`/myplan/view?projectId=${a}`,className:"btnLine",children:"만다라트로 보기"}),e.jsx(r,{to:`/myplan/calendar?projectId=${a}`,className:"btnColor",children:"캘린더로 보기"})]})]}),e.jsxs("div",{className:"inputBox borderNone",children:[e.jsx("label",{}),e.jsxs("div",{style:{gap:"20px"},children:[e.jsx("div",{className:"viewCalendar",children:e.jsx(P,{plugins:[V],initialView:"dayGridMonth",headerToolbar:{left:"prev,next",center:"title",right:"today"},nowIndicator:!0,events:y,locale:"ko",height:"auto",eventDidMount:t=>{t.event.end&&(t.el.style.borderRadius="5px")}})}),e.jsx("div",{className:"content",children:s.content})]})]}),e.jsxs(L,{children:[e.jsx("button",{className:"btnLine",onClick:()=>i(!0),children:"삭제하기"}),e.jsx(r,{to:`/myplan/edit?projectId=${a}`,className:"btnLine",children:"수정하기"}),e.jsx(r,{to:"/myplan",className:"btnColor",children:"목록으로"})]})]}),o&&e.jsx(I,{isVisible:o,onClose:b,title:"만다라트 삭제하기",children:e.jsxs("form",{onSubmit:v,children:[e.jsx("div",{className:"guideText inputBox",children:"나의 만다라트 계획표를 삭제하시겠습니까?"}),e.jsxs("div",{className:"buttonWrap",children:[e.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>i(!1),children:"창닫기"}),e.jsx("button",{type:"submit",className:"btnPupColor",children:"삭제하기"})]})]})})]})}export{O as default};
