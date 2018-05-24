<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Edit Product</h1>
    			
    			<p class = "lead">Edit the product.</p>
    		</div>
    		
    		<form:form action = "${pageContext.request.contextPath}/admin/product//editProduct" method = "POST" modelAttribute = "product" enctype="multipart/form-data">
    			<form:hidden path="productId" value="${product.productId}" />
    			<div class  = "form-group">
    				<label for = "name">Name</label><br><form:errors path = "productName" cssStyle="color:#ff0000"/>
    				<form:input path = "productName" id = "name" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "category">Category</label>
    				
    				<label class = "checkbox-inline">
    				<form:select path = "productCategory" id = "productCategory" class = "form-control">
    					<form:option value = "select">select</form:option>
    					<form:option value = "electronics">electronics</form:option>
    					<form:option value = "apparels">apparels</form:option>
    					<form:option value = "decorations">decorations</form:option>
    					<form:option value = "mens">mens</form:option>
    					<form:option value = "womens">womens</form:option>
    				</form:select>
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
    				<form:radiobutton path = "productCondition" id = "condition" value = "New"/>New
    				</label>
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCondition" id = "condition" value = "Old"/>Old
    				</label>
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productCondition" id = "condition" value = "Refurbished"/>Refurbished
    				</label>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "status">Status</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productStatus" id = "status" value = "In Stock"/>In Stock
    				</label>
    				
    				<label class = "checkbox-inline">
    				<form:radiobutton path = "productStatus" id = "status" value = "Out Of Stock"/>Out Of Stock
    				</label>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "units">Units</label><br><form:errors path = "productUnitInStock" cssStyle="color:#ff0000"/>
    				<form:input path = "productUnitInStock" id = "units" class = "form-control"></form:input>
    			</div>
    			
    			<div class  = "form-group">
    				<label for = "manufacturer">Manufacturer</label><br><form:errors path = "productManufacturer" cssStyle="color:#ff0000"/>
    				<form:input path = "productManufacturer" id = "manufacturer" class = "form-control"></form:input>
    			</div>
    			
    			<div class = "form-group">
    				<label class = "control-label" for = "productImage">Upload Picture</label><br><form:errors path = "productImage" cssStyle="color:#ff0000"/>
    				<form:input path="productImage" id = "productImage" type = "file" class = "form:input-large"/>
    			</div>
    			<br><br>
<%--     			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> --%>
    			<input type = "submit" value = "submit" class = "btn btn-primary"/>
    			<a href = "<c:url value = "/admin/product/productInventory" />" class = "btn btn-default">Cancel</a>
    		</form:form>
    		
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		