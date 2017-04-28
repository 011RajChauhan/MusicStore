<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Product Detail</h1>
    			
    			<p class = "lead">explore the details information of the product.</p>
    		</div>
    		<div class = "container">
    			<div class = "row">
    				<div class = "col-md-5">
    					<img src = "<c:url value = "E:/eMusicStore/uploads/images/${product.productId}" /> " alt = "image" style="width: 100%;height: 300px;" />
    				 </div>
    				 
    				 <div class = "col-md-5"> 
    				 	<h3>${product.productName}</h3>
    				 	<p>${product.productDescription}</p>
    				 	<p>
    				 		<strong>Manufucturer : ${product.productManufacturer}</strong>
    				 	</p>
    				 	<p>
    				 	<strong>Category : ${product.productCategory}</strong></p>
    				 	<p>
    				 	<strong>Condition : ${product.productCondition}</strong></p>
    				 	<h4>${product.productPrice} INR</p>
    				 </div>
    			</div>
    		
    		</div>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		