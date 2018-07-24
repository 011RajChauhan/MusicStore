<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Customer</h1>
    			
    			<p class = "lead">Customer Details.</p>
    		</div>
    		<form:form modelAttribute = "order" class = "form-horizontal">
    			<h3>Shipping Address</h3>
    			<br>
    			<div class  = "form-group">
    				<label for = "street name">street name</label><br><form:errors path = "cart.customer.shippingAddress.streetName" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.streetName" id = "shippingAddressStreetName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "apartment number">apartment number</label><br><form:errors path = "cart.customer.shippingAddress.apartmentNumber" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.apartmentNumber" id = "shippingAddressApartmentNumber" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "city">city</label><br><form:errors path = "cart.customer.shippingAddress.city" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.city" id = "shippingAddressCity" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "state">state</label><br><form:errors path = "cart.customer.shippingAddress.state" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.state" id = "shippingAddressState" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "country">country</label><br><form:errors path = "cart.customer.shippingAddress.country" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.country" id = "shippingAddressCountry" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "zipCode">zip code</label><br><form:errors path = "cart.customer.shippingAddress.zipCode" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.shippingAddress.zipCode" id = "shippingAddressZipCode" class = "form-control"></form:input>
    			</div>
    			
    			<input type = "hidden" name="_flowExecutionKey"/>
    			<br><br>
<%--     			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> --%>
				<button class = "btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
    			<input type = "submit" value = "next" class = "btn btn-primary" name = "_eventId_shippingDetailsCollected"/>
    			<button class = "btn btn-default" name = "_eventId_cancel">Cancel</button> 
    		</form:form>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		