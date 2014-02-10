<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "s" uri = "/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finished Vote</title>
</head>
<body>
	<div id="divcenter"  >
		<div style="width: 50%;margin: 0 auto;display: block;">
			<fieldset title="Informations" style="display: block;float: left;" >
			<legend>Informations:</legend>
			<s:form action="/Vote/pageChart">			
				<s:textfield name="name" label="Name" ></s:textfield>
				<s:textfield name="email" label="Email" ></s:textfield>
				<s:submit align="center" label="Send" />
			</s:form>
			</fieldset>
		</div>
	</div>
</body>
</html>