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
    			<h3>Basic Info</h3>
    			<div class  = "form-group">
    				<label for = "name">Name</label><br><form:errors path = "cart.customer.customerName" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.customerName" id = "customerName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "email">email</label><br><form:errors path = "cart.customer.customerEmail" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.customerEmail" id = "customerEmail" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "contact number">contact number</label><br><form:errors path = "cart.customer.customerPhone" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.customerPhone" id = "customerPhone"  class= "form-control"></form:input>
    			</div>
    			
    			<br>
    			<h4>Billing Address</h4>
    			<br>
    			<div class  = "form-group">
    				<label for = "street name">street name</label><br><form:errors path = "cart.customer.billingAddress.streetName" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.streetName" id = "billingAddressStreetName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "apartment number">apartment number</label><br><form:errors path = "cart.customer.billingAddress.apartmentNumber" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.apartmentNumber" id = "billingAddressApartmentNumber" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "city">city</label><br><form:errors path = "cart.customer.billingAddress.city" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.city" id = "billingAddressCity" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "state">state</label><br><form:errors path = "cart.customer.billingAddress.state" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.state" id = "billingAddressState" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "country">country</label><br><form:errors path = "cart.customer.billingAddress.country" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.country" id = "billingAddressCountry" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "zipCode">zip code</label><br><form:errors path = "cart.customer.billingAddress.zipCode" cssStyle="color:#ff0000"/>
    				<form:input path = "cart.customer.billingAddress.zipCode" id = "billingAddressZipCode" class = "form-control"></form:input>
    			</div>
    			
    			<input type = "hidden" name="_flowExecutionKey"/>
    			<br><br>
<%--     			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> --%>
    			<input type = "submit" value = "next" class = "btn btn-primary" name = "_eventId_customerInfoCollected"/>
    			<button class = "btn btn-default" name = "_eventId_cancel">Cancel</button> 
    		</form:form>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		