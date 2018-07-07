<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
	<div class = "continer-wrapper">
		<div class = "container">
			<section>
				<div class = "jumbotron">
					<div class = "container">
						<h1>Registration Successfull</h1>
					</div>
				</div>
			</section>
			<section class = "container" data-ng-app = 'cartApp'>
				<div>
                    <p>Hi ${ customerName} you registration is Successfull.</p>
                </div>
				<a href = "<spring:url value = "/products" />" class = "btn btn-default">let's shop</a>
				</div>
			</section>
		</div>
	</div>
<script src = "<c:url value = "/resources/js/controller.js" /> "></script>
<%@include file = "/WEB-INF/views/templates/footer.jsp" %>