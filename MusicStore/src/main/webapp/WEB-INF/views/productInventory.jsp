<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Product Inventory</h1>
    			
    			<p class = "lead">Manage you product inventory.</p>
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
	    			
	    				<!-- have to check this issue that why
	    				on removing forward slash from spring:url tag /admin/product/product/productDetails/4
	    				to the url -->
	    				
	    				<spring:url value = "/product/productDetails/${product.productId}" var="infoUrl" />
	    				<spring:url value = "/admin/product/deleteProduct/${product.productId}" var="deleteUrl" htmlEscape="true"/>
	    				<spring:url value = "/admin/product/editProduct/${product.productId }" var = "editUrl" htmlEscape="true"/>
	    				<td><img src = "<c:url value = "/resources/images/${product.productId}.png" /> " alt = "image" style="width: 50%;height: 150px;" /></td>
	    				<td>${product.productName}</td>
	    				<td>${product.productCategory}</td>
	    				<td>${product.productCondition}</td>
	    				<td>${product.productPrice}</td>
	    				<td>${product.productManufacturer}</td>
	    				<td><a href = "${infoUrl}"><span class = "glyphicon glyphicon-info-sign"></span></a>
	    					<a href = "${deleteUrl}"><span class = "glyphicon glyphicon-remove"></span></a>
	    					<a href = "${editUrl}"><span class = "glyphicon glyphicon-pencil"></span></a>
	    				</td>	  						
	    			</tr>
    			</c:forEach>
    		</table>
    		<a href = "<spring:url value = "/admin/product/addProduct" />" class = "btn btn-primary">Add product</a>
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		