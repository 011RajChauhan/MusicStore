<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
	<div class = "continer-wrapper">
		<div class = "container">
			<section>
				<div class = "jumbotron">
					<div class = "container">
						<h1>Cart</h1>
						
						<p>All the selected products in your shopping cart</p>
					</div>
				</div>
			</section>
			<section class = "container" data-ng-app = 'cartApp'>
				<div data-ng-controller = 'cartCtrl' data-ng-init = "initCartId('${cartId}')">
				<div>
					<a class = "btn btn-danger pull-left" data-ng-click = "clearCart()"><span class = "glyphicon glyphicon-remove-sign"></span>Clear cart</a>
				</div>
				<table class = "table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr data-ng-repeat = 'item in cart.cartItems'>
						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href = "#" class = "label label-danger" data-ng-click = "removeFromCart(item.product.productId)"><span class = "glyphicon glyphicon-remove"></span>remove</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
						<th></th>
					</tr>
				</table>
				<a href = "<spring:url value = "/products" />" class = "btn btn-default">Continue Shopping</a>
				</div>
			</section>
		</div>
	</div>
<script src = "<c:url value = "/resources/js/controller.js" /> "></script>
<%@include file = "/WEB-INF/views/templates/footer.jsp" %>