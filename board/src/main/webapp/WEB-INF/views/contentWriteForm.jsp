<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">

<title>글쓰기</title>

<script>
   
	//작성
	function contentWrite() {
		
		let memberId = $("#memberId").val();
		let title = $("#title").val();
		let text = $("#text").val();
		
		let data = {
			  memberId  : memberId
			, title		: title
			, text		: text
		};
		
		console.log("data", data);
		
		$.ajax({
			type : "POST"
			,url : "/contentWrite"
			,cache : false
			,data : JSON.stringify(data)
			,contentType : 'application/json; charset=utf-8'
			,success : function(result){
				//console.log("result", result);
				alert("작성되었습니다.");
				location.href = "/board/"+result;
			}
			,error : function(e){
				console.log(e);
				alert("작성 실패하였습니다.");
			}
		});//ajax end
		
	}//contentWrite() end
   
</script>

</head>
<body>

	<div class="container">
	<br/>
		<h2>글</h2>
		<br/>
		<table class="table table-bordered">
			<tr>
				<td>이름</td>
				<td>
					<input id="memberId">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input id="title">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" id="text"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success" onclick="location.href='/list'">목록보기</button> &nbsp;&nbsp; 
					<button type="button" class="btn btn-warning" onclick="contentWrite()">작성</button>
				</td>
			</tr>
		</table>
	</div>
   
</body>
</html>