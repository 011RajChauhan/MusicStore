<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Administrator page</h1>
    			
    			<p class = "lead">This is the administrator page.</p>
    		</div>
    		<h3>
    			<a href = "<c:url value =  "/admin/productInventory" />">Manage Product Inventory</a>
    		</h3>
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		