<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table tr {
		width: 500px;
		text-align: "center";
	}
	
	img {
		width:200px;
		
	}


</style>

</head>
<body>

	<div align="center">
		<form action="req_album_iframe.jsp">
	
		<table border=1>
			<tr>
				<th></th>
				<th>인물사진</th>
				<th>소속팀</th>
				<th>내가좋아하는곡</th>
				<th>활동명</th>
			<tr>
			
				<tr>
					<td><input type="radio" name="title" value="sel1"></td>
					<td class="hd1">
						<img src="./정국1.jpg" alt="jk" width="200px" height="200px">
					</td>
					<td>방탄소년단</td>
					<td>RUN</td>
					<td>정국</td>
				</tr>
				
				
				<tr>
					<td><input type="radio" name="title" value="sel2"></td>
					<td class="hd2">
						<img src="./수빈1.jpg" alt="sb" width="200px" height="200px">
					</td>
					<td>투모로우바이투게더</td>
					<td>0×1=Lovesong (Feat. Seori)</td>
					<td>수빈</td>
				</tr>
				
				<tr>
					<td colspan="5" align="center">
						<input type="submit" value="확인">
			</tr>
			
			
		</table>
	</form>
</div>

</body>
</html>