<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
	<div class = "continer-wrapper">
		<div class = "container">
			<section>
				<div class = "jumbotron">
					<div class = "container">
						<h1 class="alert alert-danger">Checkout cancelled</h1>
						<p>your checkout process is cancelled, you can continue browsing.</p>
					</div>
				</div>
			</section>
			<section class = "container">
				<p>
				<a href = "<spring:url value = "/products" />" class = "btn btn-default">home</a>
				</p>
			</section>
		</div>
	</div>
<%@include file = "/WEB-INF/views/templates/footer.jsp" %>