<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <% 
     	String title = request.getParameter("title");
  %>
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(title.equals("sel1"))  {%>
		<div align="center">
			<h2>선택하신 곡 정보</h2>
			<hr>
			<p>
				당신이 선택하신 정국의 대표곡 <strong>RUN</strong> 입니다.
			</p>
			<hr>
			<h3>타이틀 곡 뮤직비디오</h3>
			<iframe width="800" height="600" src="https://www.youtube.com/embed/wKysONrSmew?autoplay=1" title="BTS (방탄소년단) &#39;RUN&#39; Official MV" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		
		</div>
		
	<%} else if(title.equals("sel2")) {%>
		<div align="center">
			<h2>선택하신 곡 정보</h2>
			<hr>
			<p>
				당신이 선택하신 정국의 대표곡 <strong>0×1=Lovesong (Feat. Seori)</strong> 입니다.
				
			</p>
			<hr>
			<h3>타이틀 곡 뮤직비디오</h3>
			<iframe width="641" height="361" src="https://www.youtube.com/embed/d5bbqKYu51w?autoplay=1" title="TXT (투모로우바이투게더) &#39;0X1=LOVESONG (I Know I Love You) feat. Seori&#39; Official MV" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		
		</div>
	<%} %>
	<form action="req_album.jsp method="album">
	
	</form>
</body>
</html>