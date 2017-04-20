<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>All Products</h1>
    			
    			<p class = "lead">Checkout all the awesome products available now.</p>
    		</div>
    		
    		<table class = "table table-striped tabel-hover">
    			<thead>
    				<tr class = "bg-success">
    					<th>photo</th>
    					<th>name</th>
    					<th>category</th>
    					<th>condition</th>
    					<th>price</th>
    					<th>manufacturer</th>
    					<th></th>
    				</tr>
    			</thead>
    			<c:forEach items = "${productList}" var = "product">
	    			<tr>
	    				<spring:url value = "productDetails./${product.productId}" var="url" htmlEscape="true"/>
	    				<td><img src = "#" alt = "image"/></td>
	    				<td>${product.productName}</td>
	    				<td>${product.productCategory}</td>
	    				<td>${product.productCondition}</td>
	    				<td>${product.productPrice}</td>
	    				<td>${product.productManufacturer}</td>
	    				<td><a href = "${url}"><span class = "glyphicon glyphicon-info-sign"></span></a></td>	  						
	    			</tr>
    			</c:forEach>
    		</table>
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		