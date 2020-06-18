var members=[];

function Member(uid, upw, uname){
    this.id=uid;
    this.pw=upw;
    this.name=uname;
}

//공통함수 : 메서드 정의
Member.prototype.toString = function(){
    var makeHtml='';
    makeHtml += '<td>';
    makeHtml += this.id;
    makeHtml += '</td>';
    makeHtml += '<td>';
    makeHtml += this.pw;
    makeHtml += '</td>';
    makeHtml += '<td>';
    makeHtml += this.name;
    makeHtml += '</td>';

    return makeHtml;
}

//데이터 저장함수
function addMember(member){
    //배열에 요소를 넣고
    members.push(member); 
    //동기화-추가될때 배열을 넣어야하니까
    setStorage();
    console.log(members);
    //추가된 데이터 갱신.
    displayTable();
}

//회원 데이터 저장
function createMember(){
    
    //사용자 입력 데이터 받기, document로 캐스팅 후 value속성 사용
    var id = document.getElementById('uid').value;
    var pw = document.getElementById('upw').value;
    var name = document.getElementById('uname').value;

    //배열에 데이터 추가
    addMember(new Member(id, pw, name));

    //동기화
    setStorage();
    this.reset();

    return false;
}


//회원 리스트 출력 가능
function displayTable(){

    var listHtml ='';
    listHtml += '<table class="listtable">';
    listHtml += '   <tr>';
    listHtml += '       <th>index</th>';
    listHtml += '       <th>ID(이메일)</th>';
    listHtml += '       <th>비밀번호</th>';
    listHtml += '       <th>이름</th>';
    listHtml += '       <th>관리</th>';
    listHtml += '   </tr>';

    //배열의 요소를 반복문으로 태그 생성
    for(let i=0; i<members.length; i++){
        listHtml +='    <tr>';
        listHtml +='        <td>'+i+'</td>';
        listHtml +='        <td>'+members[i].id+'</td>';
        listHtml +='        <td>'+members[i].pw+'</td>';
        listHtml +='        <td>'+members[i].name+'</td>';
        listHtml +='        <td><a href="javascript:editSet('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></td>';
        listHtml +='    </tr>';
    }

    listHtml += '</table>';

    var listTable = document.getElementById('list');
    listTable.innerHTML=listHtml;
    
}

//리스트에서 선택한 회원의 데이터를 수정 폼에 set
function editSet(idx){

    //수정 폼 영역 출력
    document.getElementById('edit').style.display='block';

    //사용자 입력 데이터 받기, document로 케스팅 후 value속석 사용
    document.getElementById('eid').value=members[idx].id;
    document.getElementById('ename').value=members[idx].name;
    document.getElementById('epw').value=members[idx].pw;
    document.getElementById('idx').value=idx;
}

//사용자 입력 데이터를 배열 요소 객체의 속성 값을 변경
function editMember(){
    
    //사용자가 입력해둔 데이터를 캐스팅해서 가져와서 담아줌.
    var id = document.getElementById('eid').value;
    var name = document.getElementById('ename').value;
    var pw = document.getElementById('epw').value;
    var idx = document.getElementById('idx').value;

    //배열의 요소 인 Member객체의 속성값을 변경.
    //담아준 데이터를 가져와 정수타입으로 받아 다시 담아줌.
    members[parseInt(idx)].id=id;
    members[parseInt(idx)].name=name;
    members[parseInt(idx)].pw=pw;

    document.getElementById('editform').reset();

    //리스트 테이블 갱신
    //수정한데이터도 테이블안에 갱신.
    displayTable();
    //동기화
    //출력 후 동기화해주는 작업.
    setStorage();

    alert("수정되었습니다. \n수정폼 화면을 숨깁니다.");

    //다시 수정폼을 숨기기위해 에디트를 불러서 숨기는 역할을 해줌.
    document.getElementById('edit').style.display='none';
    
    return false;
}

//배열에서 데이터를 삭제
function deleteMember(idx){

    if(confirm('삭제하시겠습니까?')){
        members.splice(idx,1);
        //화면갱신
        displayTable();
       
    }
}

//localStorage에 데이터 저장/수정 시에 업데이트
function setStorage(){
    //데이터의 갱신 : 추가, 수정, 삭제
    localStorage.setItem('members',JSON.stringify(members));
}

//localStorage의 데이터아 배열의 동기화
//최초시작할때 세팅해주는거
function initStorage(){
    //localStorage에 저장되어 있는 데이터
    var storageDate = localStorage.getItem('members');

    if(storageDate==null){
        //프로그램 최초 시작 또는 데이터가 없는 상태
        //아무것도 없는상태에서 객체를 만들어줌. 최초에 배열을 만들어줬으니까
        //셋스토리지메서드를 호출해도됨
        localStorage.setItem('members',JSON.stringify(members));
    }else {
        //저장되어 있는 JSON 데이터를 배열 객체로 변환
        //parse>>함수를 사용하여 불러줌
        members = JSON.parse(storageDate);
    }
}

//저장, 수정 submit 이벤트 처리
window.onload = function(){
    //페이지가 로드된것은 프로그램을 시작하는 시점이다.
    //저장된 데이터를 배열 객체로 변환
    initStorage();

    //로드된 데이터를 테이블로 화면에 출력
    //화면이 실행될때 제일먼저 실행.
    displayTable();

    //입력 폼 casting >> onsubmit Event
    document.getElementById('regform').onsubmit = createMember;

    //수정 폼 casting >> onsubmit Event
    document.getElementById('editform').onsubmit = editMember;
}

//입력하는 이벤트. 수정하는 이벤트. 삭제되는 이벤트 할때마다 
//디스플레이테이블도 갱신되어야 함. 수정삭제 모두 갱신되어야 하니까 
//displayTable();불러와줘야함.


//보완해야할점.
//1. 유효성검사
//2. 게터세터로 하는 것이 더 안정성이 있음


//javascript:editSet('+i+')/javascript:deleteMember('+i+')
//자바스크립트에서 함수를 호출하는 방법.

//에디트함수 불러주면 캐스팅해서 스타일객체의 디스플레이속성의 블록으로 보여지게됨.
//없던레이아웃이 동적으로 생길수있도록. 보여지도록해주는거

