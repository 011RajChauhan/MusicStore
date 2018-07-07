<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">explore the details information of the product.</p>
		</div>
		<div class="container" data-ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img
						src="<c:url value = "/resources/images/${product.productId}.png" /> "
						alt="image" style="width: 100%; height: 300px;" />
				</div>

				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>${product.productDescription}</p>
					<p>
						<strong>Manufacturer : ${product.productManufacturer}</strong>
					</p>
					<p>
						<strong>Category : ${product.productCategory}</strong>
					</p>
					<p>
						<strong>Condition : ${product.productCondition}</strong>
					</p>
					<h4>${product.productPrice}INR</h4>
					<br>
					
					<c:set var = "role" scope = "page" value = "${param.role}" />
					<c:out value="${ param.role}"></c:out>
					<c:set var = "url" scope = "page" value = "/products" />
					<c:if test = "${ role='admin' }" >
						<c:set var = "url" scope = "page" value = "/admin/productInventory" />
					</c:if>
					
					<p data-ng-controller = "cartCtrl">
						<a href = "<c:url value = "${ url }" />" class = "btn btn-default">Back</a>
						<a href = "#" class = "btn btn-warning btn-large" data-ng-click = "addToCart('${ product.productId }')"><span class = "glyphicon glyphicon-shopping-cart">
						</span>Add to Cart</a>
						<a href = "<spring:url value = "/customer/cart"/> "  class = "btn btn-default"><span class = "glyphicon glyphicon-hand-right"></span>View Cart</a>
					</p>
				</div>
			</div>
		</div>

		<script src = "<c:url value = "/resources/js/controller.js" /> "></script>
		<%@include file="/WEB-INF/views/templates/footer.jsp"%>