<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>Spring Web Demo - home</title>
	<style>
		form{
			border:1px solid black;
			width:40%;
			margin:auto;
			margin-top:25px;
			padding:10px;
		}
		div{
			margin-bottom:4px;
		}
		label {
			width:30%;
			display: inline-block;
			text-align: right;
			font-weight: bolder;
		}

		input{
			width:65%;
			display: inline-block;
		}
	</style>
</head>
<body>
	<jsp:include page="/header" />

	<form:form method="POST" modelAttribute="book">
		<div>
			<form:label path="bookCode">Book Code</form:label>
			<form:input path="bookCode" readonly="true"/>
		</div>
		<div>
			<form:label path="title">Title</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="price">Price</form:label>
			<form:input path="price" type="number" />
			<form:errors path="price" />
		</div>
		<div>
			<form:label path="publishDate">Publish Date</form:label>
			<form:input path="publishDate" type="date" />
			<form:errors path="publishDate" />
		</div>
		<div style="text-align:right">
			<button>SAVE</button>
		</div>
	</form:form>
	
</body>
</html>