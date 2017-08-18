<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Administrator page 	|	<a href = "<c:url value = "/logout"/> ">Logout</a></h1>
    			
    			<p class = "lead">Welcome ${username}.</p>
    		</div>
    		<h3>
    			<a href = "<c:url value =  "/admin/productInventory" />">Manage Product Inventory</a>
    		</h3>
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		