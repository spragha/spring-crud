<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Customer Information</h2>

    <table class="table table-striped" style="width:600px;">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${customer.firstName} ${customer.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><c:out value="${customer.address}"/></td>
        </tr>
        <tr>
            <th>City</th>
            <td><c:out value="${customer.city}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${customer.telephone}"/></td>
        </tr>
         <tr>
            <td> 
            	<spring:url value="{customerId}/edit.html" var="editUrl">
                    <spring:param name="customerId" value="${customer.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit Customer</a></td>
            <td>
            	<spring:url value="{customerId}/account/new.html" var="addUrl">
                    <spring:param name="customerId" value="${customer.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(addUrl)}"  class="btn btn-success">Add New Account</a></td>
        </tr>
    </table>
<!-- 
    <h2>Accounts and Visits</h2>

    <c:forEach var="account" items="${customer.accounts}">
        <table class="table" style="width:600px;">
            <tr>
                <td valign="top" style="width: 120px;">
                    <dl class="dl-horizontal">
                        <dt>Name</dt>
                        <dd><c:out value="${account.name}"/></dd>
                        <dt>Birth Date</dt>
                        <dd><joda:format value="${account.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt>Type</dt>
                        <dd><c:out value="${account.type.name}"/></dd>
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th>Visit Date</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <c:forEach var="visit" items="${pet.visits}">
                            <tr>
                                <td><joda:format value="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td> 
                            	<spring:url value="/customer/{customerId}/account/{petId}/edit" var="accountUrl">
			                        <spring:param name="customerId" value="${customer.id}"/>
			                        <spring:param name="accountId" value="${account.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(accountUrl)}">Edit Account</a>
			                </td>
                            <td>
			                    <spring:url value="/customer/{customerId}/account/{accountId}/visits/new" var="visitUrl">
			                        <spring:param name="customerId" value="${customer.id}"/>
			                        <spring:param name="accountId" value="${account.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(visitUrl)}">Add Visit</a>
                            </td>
                       	</tr>
                    </table>
                </td>
            </tr>
        </table>
    </c:forEach>
 -->
    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>
