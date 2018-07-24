<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
    <div class="container-wrapper">
    	<div class = "container">
    		<div class = "page-header">
    			<h1>Customers</h1>
    		</div>
    		
    		<table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
    					<th>Name</th>
    					<th>Email</th>
    					<th>Phone</th>
    					<th>Active</th>
    				</tr>
    			</thead>	
    			<c:forEach items = "${customersList}" var = "customer">
	    			<tr>
	    				<td>${customer.customerName}</td>
	    				<td>${customer.customerEmail}</td>
	    				<td>${customer.customerPhone}</td>
	    				<td>${customer.enabled}</td>	  						
	    			</tr>
    			</c:forEach>
    		</table>
   <%@include file = "/WEB-INF/views/templates/footer.jsp" %>
    		