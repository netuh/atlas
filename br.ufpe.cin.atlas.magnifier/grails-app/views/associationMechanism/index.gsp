
<%@ page import="br.ufpe.cin.atlas.magnifier.AssociationMechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'associationMechanism.label', default: 'AssociationMechanism')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-associationMechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-associationMechanism" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="definedByAuthor" title="${message(code: 'associationMechanism.definedByAuthor.label', default: 'Defined By Author')}" />
					
						<g:sortableColumn property="domain" title="${message(code: 'associationMechanism.domain.label', default: 'Domain')}" />
					
						<th><g:message code="associationMechanism.mechanism.label" default="Mechanism" /></th>
					
						<g:sortableColumn property="mechanismType" title="${message(code: 'associationMechanism.mechanismType.label', default: 'Mechanism Type')}" />
					
						<th><g:message code="associationMechanism.owner.label" default="Owner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${associationMechanismInstanceList}" status="i" var="associationMechanismInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${associationMechanismInstance.id}">${fieldValue(bean: associationMechanismInstance, field: "definedByAuthor")}</g:link></td>
					
						<td>${fieldValue(bean: associationMechanismInstance, field: "domain")}</td>
					
						<td>${fieldValue(bean: associationMechanismInstance, field: "mechanism")}</td>
					
						<td>${fieldValue(bean: associationMechanismInstance, field: "mechanismType")}</td>
					
						<td>${fieldValue(bean: associationMechanismInstance, field: "owner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${associationMechanismInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
