<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Add product</h1>
    			
    			<p class = "lead">Fill the form below to add a new product.</p>
    		</div>
    		<form:form action = "${pageContext.request.contextPath}/register" method = "POST" modelAttribute = "customer">
    			
    			<div class  = "form-group">
    				<label for = "name">Name</label><br><form:errors path = "customerName" cssStyle="color:#ff0000"/>
    				<form:input path = "customerName" id = "customerName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "email">email</label><br><form:errors path = "customerEmail" cssStyle="color:#ff0000"/>
    				<form:input path = "customerEmail" id = "customerEmail" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "contact number">contact number</label><br><form:errors path = "customerPhone" cssStyle="color:#ff0000"/>
    				<form:input path = "customerPhone" id = "name" customerPhone = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "username">username</label><br><form:errors path = "username" cssStyle="color:#ff0000"/>
    				<form:input path = "username" id = "username" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "password">password</label><br><form:errors path = "password" cssStyle="color:#ff0000"/>
    				<form:password path = "password" id = "password" class = "form-control"></form:password>
    			</div>
    			<br>
    			<h4>Billing Address</h4>
    			<br>
    			<div class  = "form-group">
    				<label for = "street name">street name</label><br><form:errors path = "billingAddress.streetName" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.streetName" id = "billingAddressStreetName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "apartment number">apartment number</label><br><form:errors path = "billingAddress.apartmentNumber" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.apartmentNumber" id = "billingAddressApartmentNumber" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "city">city</label><br><form:errors path = "billingAddress.city" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.city" id = "billingAddressCity" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "state">state</label><br><form:errors path = "billingAddress.state" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.state" id = "billingAddressState" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "country">country</label><br><form:errors path = "billingAddress.country" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.country" id = "billingAddressCountry" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "zipCode">zip code</label><br><form:errors path = "billingAddress.zipCode" cssStyle="color:#ff0000"/>
    				<form:input path = "billingAddress.zipCode" id = "billingAddressZipCode" class = "form-control"></form:input>
    			</div>
    			<br>
    			<h4>Shipping Address</h4>
    			<div class  = "form-group">
    				<label for = "street name">street name</label><br><form:errors path = "shippingAddress.streetName" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.streetName" id = "shippingAddressStreetName" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "apartment number">apartment number</label><br><form:errors path = "shippingAddress.apartmentNumber" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.apartmentNumber" id = "shippingAddressApartmentNumber" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "city">city</label><br><form:errors path = "shippingAddress.city" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.city" id = "shippingAddressCity" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "state">state</label><br><form:errors path = "shippingAddress.state" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.state" id = "shippingAddressState" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "country">country</label><br><form:errors path = "shippingAddress.country" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.country" id = "shippingAddressCountry" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "zipCode">zip code</label><br><form:errors path = "shippingAddress.zipCode" cssStyle="color:#ff0000"/>
    				<form:input path = "shippingAddress.zipCode" id = "shippingAddressZipCode" class = "form-control"></form:input>
    			</div>
    			<br><br>
<%--     			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> --%>
    			<input type = "submit" value = "submit" class = "btn btn-primary"/>
    			<a href = "<c:url value = "/" />" class = "btn btn-default">Cancel</a>
    		</form:form>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		