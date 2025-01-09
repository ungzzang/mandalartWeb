import{n as ie,b as ue,u as he,g as be,r as s,j as t,L as r}from"./index-DRgm4NuZ.js";import{_ as je}from"./nivo-pie.es-BQqOF-X_.js";import{P as fe}from"./PopupLayout-DEN_2vDs.js";import{a as ge,d as ye}from"./myplan-DgqTTbtC.js";import{M as ve}from"./Mandalart-CvBjzrqc.js";import{p as Ne}from"./purify.es-CocPUCx9.js";import"./index-D2dJIdCi.js";import"./isEqual-DYK2BPV3.js";const Pe="login_session",Se=ie.div`
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
`,Le=ie.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-top: 40px;
  border-top: 1px solid #eee;
`;function _e(){var d,c,p,m,x,u,h,b,j,f,g,y,v,N,P,S,L,w,k,C,I,W,D,M,T,V,B,_,A,E,O,R,$,z,H,Y,F,G,K,X,q,J,Q,U,Z,ee,te,ae;const[se,we]=ue(),re=he(),a=se.get("projectId"),oe=be(Pe),[i,ne]=s.useState([]),[e,de]=s.useState([]),[n,o]=s.useState(!1),ce=()=>{o(!1)},pe=async()=>{try{const l=await ge(a);ne(l.resultData),de(l.resultData.mandalart)}catch(l){console.log("검색 실패:",l)}},me=[{id:(d=e[1])!=null&&d.title?(c=e[1])==null?void 0:c.title:"data-1",label:(p=e[1])!=null&&p.title?(m=e[1])==null?void 0:m.title:"data-1",value:((x=e[1])==null?void 0:x.completedPer)===0?1:(u=e[1])==null?void 0:u.completedPer,color:""},{id:(h=e[2])!=null&&h.title?(b=e[2])==null?void 0:b.title:"data-2",label:(j=e[2])!=null&&j.title?(f=e[2])==null?void 0:f.title:"data-2",value:((g=e[2])==null?void 0:g.completedPer)===0?1:(y=e[2])==null?void 0:y.completedPer,color:""},{id:(v=e[3])!=null&&v.title?(N=e[3])==null?void 0:N.title:"data-3",label:(P=e[3])!=null&&P.title?(S=e[3])==null?void 0:S.title:"data-3",value:((L=e[3])==null?void 0:L.completedPer)===0?1:(w=e[3])==null?void 0:w.completedPer,color:""},{id:(k=e[4])!=null&&k.title?(C=e[4])==null?void 0:C.title:"data-4",label:(I=e[4])!=null&&I.title?(W=e[4])==null?void 0:W.title:"data-4",value:((D=e[4])==null?void 0:D.completedPer)===0?1:(M=e[4])==null?void 0:M.completedPer,color:""},{id:(T=e[5])!=null&&T.title?(V=e[5])==null?void 0:V.title:"data-5",label:(B=e[5])!=null&&B.title?(_=e[5])==null?void 0:_.title:"data-5",value:((A=e[5])==null?void 0:A.completedPer)===0?1:(E=e[5])==null?void 0:E.completedPer,color:""},{id:(O=e[6])!=null&&O.title?(R=e[6])==null?void 0:R.title:"data-6",label:($=e[6])!=null&&$.title?(z=e[6])==null?void 0:z.title:"data-6",value:((H=e[6])==null?void 0:H.completedPer)===0?1:(Y=e[6])==null?void 0:Y.completedPer,color:""},{id:(F=e[7])!=null&&F.title?(G=e[7])==null?void 0:G.title:"data-7",label:(K=e[7])!=null&&K.title?(X=e[7])==null?void 0:X.title:"data-7",value:((q=e[7])==null?void 0:q.completedPer)===0?1:(J=e[7])==null?void 0:J.completedPer,color:""},{id:(Q=e[8])!=null&&Q.title?(U=e[8])==null?void 0:U.title:"data-8",label:(Z=e[8])!=null&&Z.title?(ee=e[8])==null?void 0:ee.title:"data-8",value:((te=e[8])==null?void 0:te.completedPer)===0?1:(ae=e[8])==null?void 0:ae.completedPer,color:""}],xe=async l=>{l.preventDefault();try{(await ye({projectId:a,userId:oe.userId})).statusCode.toString().charAt(0)==="2"?(alert("나의 만다라트 계획표를 삭제하였습니다."),re("/myplan")):alert(`나의 만다라트 계획표 삭제가 실패되었습니다.
다시 시도해 주세요.`)}catch(le){console.log("나의 만다라트 계획표 삭제 실패:",le)}};return s.useEffect(()=>{pe()},[]),t.jsxs(Se,{children:[t.jsx("h1",{className:"subTitle",children:"나의 만다라트 상세보기"}),t.jsxs("div",{className:"detailWrap",children:[t.jsxs("div",{className:"inputBox",children:[t.jsx("label",{children:"제목"}),t.jsxs("span",{children:[i.title,i.sharedFg===1&&t.jsx("span",{className:"share",children:"[공유중]"})]})]}),t.jsxs("div",{className:"inputBox",children:[t.jsx("label",{children:"작성자/작성일"}),t.jsxs("span",{children:[i.nickName," / ",i.createdAt]})]}),t.jsxs("div",{className:"inputBox borderNone",style:{alignItems:"flex-start"},children:[t.jsx("label",{children:"계획표 보기"}),t.jsxs("div",{className:"viewType",children:[t.jsx(r,{to:`/myplan/view?projectId=${a}`,className:"btnColor",children:"만다라트로 보기"}),t.jsx(r,{to:`/myplan/calendar?projectId=${a}`,className:"btnLine",children:"캘린더로 보기"})]})]}),t.jsxs("div",{className:"inputBox",children:[t.jsx("label",{}),t.jsxs("div",{style:{gap:"20px"},children:[t.jsx("div",{children:t.jsx(ve,{projectId:a})}),t.jsx("div",{className:"content",dangerouslySetInnerHTML:{__html:Ne.sanitize(i.content)}})]})]}),t.jsxs("div",{className:"inputBox borderNone",children:[t.jsx("label",{children:"통계보기"}),t.jsx("div",{style:{minWidth:"800px",height:"500px",margin:"0 auto"},children:t.jsx(je,{data:me,margin:{top:20,right:0,bottom:100,left:0},innerRadius:.5,padAngle:.7,cornerRadius:3,activeOuterRadiusOffset:8,borderWidth:1,borderColor:{from:"color",modifiers:[["darker",.2]]},arcLinkLabelsSkipAngle:10,arcLinkLabelsTextColor:"#333333",arcLinkLabelsThickness:2,arcLinkLabelsColor:{from:"color"},arcLabelsSkipAngle:10,arcLabelsTextColor:{from:"color",modifiers:[["darker",2]]},legends:[{anchor:"bottom",direction:"row",justify:!1,translateX:0,translateY:60,itemsSpacing:0,itemWidth:100,itemHeight:18,itemTextColor:"#999",itemDirection:"left-to-right",itemOpacity:1,symbolSize:18,symbolShape:"circle",effects:[{on:"hover",style:{itemTextColor:"#000"}}]}]})})]}),t.jsxs(Le,{children:[t.jsx("button",{className:"btnLine",onClick:()=>o(!0),children:"삭제하기"}),t.jsx(r,{to:`/myplan/edit?projectId=${a}`,className:"btnLine",children:"수정하기"}),t.jsx(r,{to:"/myplan",className:"btnColor",children:"목록으로"})]})]}),n&&t.jsx(fe,{isVisible:n,onClose:ce,title:"만다라트 삭제하기",children:t.jsxs("form",{onSubmit:xe,children:[t.jsx("div",{className:"guideText inputBox",children:"나의 만다라트 계획표를 삭제하시겠습니까?"}),t.jsxs("div",{className:"buttonWrap",children:[t.jsx("button",{type:"button",className:"btnPopLine",onClick:()=>o(!1),children:"창닫기"}),t.jsx("button",{type:"submit",className:"btnPupColor",children:"삭제하기"})]})]})})]})}export{_e as default};
