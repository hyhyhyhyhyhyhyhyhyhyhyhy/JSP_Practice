<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>공지사항 상세 페이지(getNotice.jsp)</h3>
<style>
</style>

<form action="noticeModify.do" method="post"
	enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid"
				value="${noticeInfo.noticeId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeTitle }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea readonly rows="3" cols="20" name="subject">${noticeInfo.noticeSubject }</textarea></td>
			<!-- textarea는 value값 없음 그냥 타이핑 -->
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter}" readonly></td>
		</tr>
		<tr>
			<th>첨부파일: ${fileType }</th>
			<td><c:if test="${noticeInfo.attachFile != null}">
					<c:choose>
						<c:when test="${fileType == 'image' }">
							<img width="200px" src="images/${noticeInfo.attachFile }">
						</c:when>
						<c:otherwise>
							<a href="images/${noticeInfo.attachFile }">${noticeInfo.attachFile }</a>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">
					<a href="noticeModify.do">수정</a>
				</button>
				<button type="button"
					onclick="location.href='noticeList.do?page=${pageNum}'">목록</button>
			</td>
		</tr>
	</table>
</form>


<!-- 댓글 등록 -->
<div id="content">
	<input type="text" id="reply"> <span>${id }</span>
	<button type="button" id="addBtn">댓글등록</button>
</div>



<!-- 댓글 정보. -->
<table class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th>글 내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody id="tlist">
	</tbody>
</table>


<table style="display: none;">
	<tbody>
		<tr id="template">
			<td>10</td>
			<td><input type="text" class="reply"></td>
			<td>user1</td>
			<td><button>수정</button>
		</tr>
	</tbody>
</table>


<script>
	let showFields = ['replyId', 'reply', 'replyWriter']
	let xhtp = new XMLHttpRequest(); // Ajax 호출
	xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}');
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.response);
		let tlist = document.querySelector('#tlist');
		// 목록 생성.
		let data = JSON.parse(xhtp.response);
		for(let reply of data){
			console.log(reply);
			let tr = makeTrFunc(reply);
			tlist.append(tr);
		}
	}

	
	// tr 생성해주는 함수.
	function makeTrFunc(reply={}){
		let tr = document.createElement('tr');
		///////////////만일 삭제 버튼에서 삭제글번호를 부모요소의 부모요소로 지정해서 삭제하지 않고 tr 자체에서 가지고 있는 값을 매개값으로 가지고 올 때
		tr.id = reply.replyId; // tr 속성 추가 : 댓글 번호
		tr.addEventListener('dblclick', function (e){
			
			if("${id}" != reply.replyWriter){
				alert('작성자만 수정 가능합니다.');
				return;
			}
			// this 1) Object 안에서 사용되면 object 자체를 가리킴.
			// 		   let obj ={name : "hong", age: 20, showInfo: function() { this.age + this.nam} }
			//		2) function 선언안에서 this는 window 전역객체. <-> 지역
			//		   function add(){ console.log(this)}
			//		3) 이벤트 안에서 사용되는 this는 이벤트 받는 대상.
			//		   document.getElementById('tlist').addEventListener('click', function() {console.log()})
			//tr 클릭이벤트
			let template = document.querySelector('#template').cloneNode(true);
			console.log(template);
			template.children[0].innerText = reply.replyId;
			template.children[1].children[0].value = reply.reply;
			template.children[2].innerText = reply.writer;
			template.querySelector('td:nth-of-type(1)').innerText = reply.replyId;
			template.querySelector('td:nth-of-type(2)').vale =  reply.reply;
			template.querySelector('td:nth-of-type(3)').innerText = reply.replyWriter;
			template.querySelector('button').addEventListener ('click' , function(e){
				
			
			// Ajx 호출 > 컨트롤로 호출하는 기능
			let replyId = reply.replyId;
			let replyCon = this.parentElement.parentElement.children[1].children[0].value;
			console.log(replyId,replyCon)
			
			letxhtp = new XMLHttpRequest();
			xhtp.open('post', 'modifyReply.do');
			xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhtp.send('rid='+replyId+'&reply='+replyCon);
			xhtp.onload = function(){
				let result = JSON.parse(xhtp.response);
				if(result.retCode == 'Success'){
					//화면 변경
					alert('성공');
					let newTr = makeTrFunc(result.data);
					let oldTr = document.querySelector('#template');
					document.getElementById('tlist').replaceChild(newTr, oldTr);
				}else if(result.retCode == 'Fail'){
					alert('처리 중 에러');
				}else {
					alert('알수 없는 결과 값입니다.');
				}
			}
			
			})
			
			// 화면 전환
			document.getElementById('tlist').replaceChild(template, tr);
		});
		for(let prop of showFields){
			let td = document.createElement('td');
			td.innerText = reply[prop];
			tr.append(td);
		}
		// 삭제버튼.
		let btn = document.createElement('button');
		btn.addEventListener('click', function(e){
			let writer = btn.parentElement.previousElementSibling.innerText;
			console.log(writer, '${id}');
			if(writer != '${id}'){
				alert('권한이 없습니다.');
				return;
			}
			
			let delno = btn.parentElement.parentElement.id; /////////////// btn.parentElement.parentElement.children[0].innerText 라고 대신 써줘도 됨
			// db에서 삭제 후 ... 화면에서 삭제. 
			let xhtp = new XMLHttpRequest();
			// open setRequestHeader send 세트임
			xhtp.open('post', 'removeReply.do');
			xhtp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			xhtp.send('rid='+ delno); // 요청방식 post 일 경우에 parameter를 send()포함.

			xthp.onload = function(){
				let result = JSON.parse(xhtp.response);
				if(result.retCode == 'Success'){
					// 화면에서 지우기.
					alert('삭제 완료');
					btn.parentElement.parentElement.remove();
				}else if(result.retCode == 'Fail'){
					alert('처리 중 에러');
				}else{
					alert('알수 없는 결과 값입니다.');
				}
			}
		})
		btn.innerText = '삭제';
		let td = document.createElement('td');
		td.append(btn);
		tr.append(td);

		return tr; // 생성한 tr을 반환.
	}



		
		
	// 등록 이벤트
	document.querySelector('#addBtn').addEventListener('click', addReplyFnc);
	
	function addReplyFnc(e){
		// 로그인 여부를 체크해서 로그인 정보가 없으면 로그인 화면으로 이동하기.
		
		let id = document.querySelector('#content span').innerText;
		if(id==null || id==''){
			alert("로그인 후에 처리하세요.");
			location.href = 'loginForm.do';
			return;
		}
		
		//console.log (click 'e')
		console.log('click', e.target);
		console.log('reply', document.querySelector('#reply').value);
		console.log('id', "${id}");
		let reply=document.querySelector('#reply').value;
		
		// Ajax 호출.
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('id=${id }&reply='+reply+"&notice_id=${noticeInfo.noticeId}"); // 이게 대체 무슨 뜻인고....ㅎ
		xhtp.onload = function(){
			console.log(xhtp.response);
			let result = JSON.parse(xhtp.response);
			if(result.retCode == 'Success'){
				// 값을 활용해서 tr 생성
				let tr = makeTrFunc(result.data);
				tlist.append(tr);
				
				// 입력값 초기화하기.
				document.getElementById("reply").value = '';
				document.getElementById("reply").focus();
			}else if(result.retCode == 'Fail'){
				// alert('처리중 에러')
			}
		}
		
		
	}
	
	
	
	</script>


