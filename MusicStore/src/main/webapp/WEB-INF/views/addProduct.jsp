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
    		<form:form action = "${pageContext.request.contextPath}/admin/productInventory/addProduct" method = "POST" modelAttribute = "product" enctype="multipart/form-data">
    			
    			<div class  = "form-group">
    				<label for = "name">Name</label><br><form:errors path = "productName" cssStyle="color:#ff0000"/>
    				<form:input path = "productName" id = "name" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "category">Category</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCategory" id = "category" value = "instrument"/>Instrument
    				</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCategory" id = "category" value = "record"/>Record
    				</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCategory" id = "category" value = "accessory"/>Accessory
    				</label>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "description">Description</label><br><form:errors path = "productDescription" cssStyle="color:#ff0000"/>
    				<form:textarea path = "productDescription" id = "description" class = "form-control"></form:textarea>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "price">Price</label><br><form:errors path = "productPrice" cssStyle="color:#ff0000"/>
    				<form:input path = "productPrice" id = "price" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "condition">Condition</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCondition" id = "condition" value = "new"/>Instrument
    				</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCondition" id = "condition" value = "refurbished"/>Record
    				</label>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "status">Status</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productStatus" id = "status" value = "available"/>available
    				</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productStatus" id = "status" value = "not-available"/>not-available
    				</label>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "units">Units</label><br><form:errors path = "productUnitInStock" cssStyle="color:#ff0000"/>
    				<form:input path = "productUnitInStock" id = "units" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "manufacturer">Manufucturer</label><br><form:errors path = "productManufacturer" cssStyle="color:#ff0000"/>
    				<form:input path = "productManufacturer" id = "manufacturer" class = "form-control"></form:input>
    			</div>
    			
    			<div class = "form-group">
    				<label class = "control-label" for = "productImage">Upload Picture</label><br><form:errors path = "productImage" cssStyle="color:#ff0000"/>
    				<form:input path="productImage" id = "productImage" type = "file" class = "form:input-large"/>
    			</div>
    			<br><br>
<%--     			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> --%>
    			<input type = "submit" value = "submit" class = "btn btn-primary"/>
    			<a href = "<c:url value = "/admin/productInventory" />" class = "btn btn-default">Cancel</a>
    		</form:form>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		