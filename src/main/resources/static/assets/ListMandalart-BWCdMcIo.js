import{n as u,r as n,g as x,j as e,L as m}from"./index-DRgm4NuZ.js";import{I as g}from"./index-D70tr6L7.js";import{L as j}from"./LoopContent-DZz7jmBf.js";import{u as y}from"./index.esm-BpKNWMCi.js";import{g as b,s as S}from"./share-BEtocycr.js";const f="login_session",v=u.div`
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
`;function w(){const[a,c]=n.useState([]),r=x(f),{handleSubmit:d,register:s,setValue:o}=y({defaultValues:{userId:"",orderFilter:"",searchFilter:"",searchText:""},mode:"all"}),h=async()=>{try{const t=await b({userId:r==null?void 0:r.userId,subLocation:"/"});c(t.resultData)}catch(t){console.log(t)}},p=async t=>{try{const l=await S(t);c(l.resultData)}catch(l){console.log("검색 실패:",l)}},i=t=>{o("orderFilter",t),d(p)()};return n.useEffect(()=>{h()},[]),n.useEffect(()=>{o("userId",r&&r.userId),o("orderFilter","0"),o("searchFilter","1")},[]),e.jsxs(e.Fragment,{children:[e.jsx("h1",{className:"subTitle",children:"만다라트 공유"}),e.jsxs("form",{onSubmit:d(p),children:[e.jsx("input",{type:"hidden",...s("userId")}),e.jsxs(v,{children:[e.jsxs("div",{className:"sortType",children:[e.jsxs("span",{children:["[전체 : ",a==null?void 0:a.length,"건]"]}),e.jsx("input",{type:"radio",value:"0",id:"date",onClick:t=>i(t.target.value),...s("orderFilter")}),e.jsx("label",{htmlFor:"date",children:"최신순"}),e.jsx("input",{type:"radio",value:"1",id:"vote",onClick:t=>i(t.target.value),...s("orderFilter")}),e.jsx("label",{htmlFor:"vote",children:"좋아요 순"}),e.jsx("input",{type:"radio",value:"2",id:"comment",onClick:t=>i(t.target.value),...s("orderFilter")}),e.jsx("label",{htmlFor:"comment",children:"댓글순"})]}),e.jsxs("div",{className:"boardSearch",children:[e.jsxs("select",{...s("searchFilter"),children:[e.jsx("option",{value:"1",children:"제목"}),e.jsx("option",{value:"2",children:"내용"}),e.jsx("option",{value:"3",children:"제목+내용"}),e.jsx("option",{value:"4",children:"닉네임"})]}),e.jsx("input",{type:"text",maxLength:"20",placeholder:"검색어를 입력하세요.",...s("searchText")}),e.jsxs("button",{type:"submit",className:"btnLine",children:[e.jsx(g,{})," 검색"]}),r&&e.jsx(m,{to:"/share/add",className:"btnColor",children:"+ 등록하기"})]})]})]}),e.jsx(j,{location:"share",datas:a})]})}export{w as default};
