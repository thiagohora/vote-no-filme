<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
	<sx:head parseContent="true"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page of Vote in Movie</title>
	<link href="/Desafio1BlueSoft/css/general.css" rel="stylesheet" media="screen" type= "text/css" />
</head>
<body>
	<div id="divcenter">
		<h2 class="divtitle">Vote on Movie</h2>
		<div style="width:100%;display: block;float: left;">
			<s:div id="movie1" cssClass="movieopt">
				<h3 class="divtitle">${MovieOpt1.name}</h3>
				<img alt="${MovieOpt1.name}" src="/Desafio1BlueSoft/images/${MovieOpt1.id}.jpg">
				<s:form action="/Vote/createVote">
					<s:hidden name="current" value="%{MovieOpt1.id}"  ></s:hidden>
					<sx:submit targets="divcenter" align="center" value="Vote" />	
				</s:form>	
			</s:div>
		
			<s:div id="movie2" cssClass="movieopt">
				<h3 class="divtitle">${MovieOpt2.name}</h3>
				<img alt="${MovieOpt2.name}" src="/Desafio1BlueSoft/images/${MovieOpt2.id}.jpg">
				<s:form action="/Vote/createVote">
					<s:hidden name="current" value="%{MovieOpt2.id}"></s:hidden>
					<sx:submit targets="divcenter" align="center" value="Vote" />
				</s:form>
			</s:div>
		</div>
		<div style="width:100%;display: block; text-align: center;">
			<h3><a href="${pageContext.request.contextPath}/Vote/finished" title="Finish votes" target="_self">Finish votes</a></h3>
		</div>
	</div>
</body>
</html>