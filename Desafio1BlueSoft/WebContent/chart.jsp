<%@ page language="java"
		 contentType="text/html;charset=UTF-8"
    	 pageEncoding="UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Chart from the votes of Movies</title>
	<link rel="stylesheet" media="screen" type="text/css" href="/Desafio1BlueSoft/css/general.css" /> 
</head>
<body>
	<div id="divcenter">
		<h2 class="divtitle">Thank you very much for participation: ${name}</h2>
		<center>
			<table cellpadding="0" cellspacing="0" class="blocktable">
				<tr><th colspan="2">Your Ranking of Movies</th></tr>
				<tr><th>Name:</th><th>Votes:</th></tr>
				<s:iterator value="listVoteUser">
					<tr>
					<td style="padding: 0 10px"><s:property value="voteUserId.movieId.name" /> </td>
					<td style="text-align: center;"><s:property value="points" /></td></tr>
				</s:iterator>
			</table>
		</center>
		<h3 class="divtitle">Chart from votes</h3>
		<img src="${pageContext.request.contextPath}/MovieChart/createChartMovie" />
		<br/>
		<br/>
	</div>
</body>
</html>