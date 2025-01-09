import{n as r,j as e,L as l}from"./index-DRgm4NuZ.js";const p=r.div`
  min-width: 1200px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 1px;
  .noData {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    margin-top: 40px;
  }
  .loopContent {
    width: calc(25% - 1px);
    margin-bottom: 30px;
  }
  .profileImage {
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    margin-bottom: 10px;
    max-height: 280px;
    background-color: #eee;
    font-size: 0px;
    overflow: hidden;
  }
  .profileImage img {
    max-width: fit-content;
    object-fit: cover;
    transition: all 0.3s;
    opacity: 0.9;
  }
  .loopContent:hover img {
    opacity: 1;
    transform: scale(1.05);
  }
  .loopContent:hover .title {
    color: #000;
  }
  .voteCount {
    position: absolute;
    bottom: 12px;
    right: 0px;
    padding: 4px 15px;
    background: rgba(0, 0, 0, 0.35);
    border-radius: 50px 0px 0px 50px;
    color: #fff;
    font-size: 13px;
  }
  .title {
    padding: 0px 20px;
    text-align: left;
    transition: all 0.3s;
  }
  .title .shared {
    margin-left: 5px;
    font-weight: 500;
    color: #55ad9b;
  }
  .date {
    padding: 0px 20px;
    text-align: left;
    color: #aaa;
    font-size: 14px;
  }
`,c=({location:i,datas:o,viewCnt:a=30})=>e.jsxs(p,{children:[(o==null?void 0:o.length)===0&&e.jsx("div",{className:"noData",children:"등록된 만다라트가 없습니다."}),o.map((t,n)=>n<a&&e.jsx("div",{className:"loopContent",children:e.jsxs(l,{to:`/${i}/view?projectId=${t.projectId}`,children:[e.jsxs("div",{className:"profileImage",children:[e.jsx("img",{src:t.pic?`http://112.222.157.156:5211/pic/project/${t.projectId}/${t.pic}`:"no_image.png",alt:""}),i==="share"&&e.jsxs("div",{className:"voteCount",children:["좋아요 ",t.likeCnt]})]}),e.jsxs("p",{className:"title",children:[t.title,t.sharedFg===1&&e.jsx("span",{className:"shared",children:"[공유중]"})]}),e.jsx("p",{className:"date",children:t.createDate})]})},n))]});export{c as L};
