<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
	<title>Spring Web Demo - home</title>
</head>
<body>
	<jsp:include page="/header" />
	<h3>Books List</h3>
	
	<c:choose>
		<c:when test="${books==null || books.isEmpty() }">
			<p><strong>No Records To Show</strong>
		</c:when>
		<c:otherwise>
			<table style="width:70%;margin:auto;border:1px solid #000000;">
				<thead>
					<tr>
						<th>Book#</th>
						<th>Title</th>
						<th>Price</th>
						<th>Published Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${books }">
						<tr>
							<td style="text-align:right">${b.bookCode }</td>
							<td style="text-align:left">${b.title }</td>
							<td style="text-align:right">${b.price }</td>
							<td style="text-align:center">${b.publishDate }</td>
							<td style="text-align:center">
								<a href="/books/delete?bc=${b.bookCode }">delete</a> <span>|</span>
								<a href="/books/edit?bc=${b.bookCode }">delete</a> <span>|</span>
								<a href="/books/select?bc=${b.bookCode }">Add to cart</a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>