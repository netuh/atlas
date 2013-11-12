
<%@ page import="br.ufpe.cin.atlas.magnifier.Mechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mechanism.label', default: 'Mechanism')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mechanism" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="content" title="${message(code: 'mechanism.content.label', default: 'Content')}" />
					
						<g:sortableColumn property="definedByAuthor" title="${message(code: 'mechanism.definedByAuthor.label', default: 'Defined By Author')}" />
					
						<g:sortableColumn property="domain" title="${message(code: 'mechanism.domain.label', default: 'Domain')}" />
					
						<g:sortableColumn property="mechanismType" title="${message(code: 'mechanism.mechanismType.label', default: 'Mechanism Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mechanismInstanceList}" status="i" var="mechanismInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mechanismInstance.id}">${fieldValue(bean: mechanismInstance, field: "content")}</g:link></td>
					
						<td><g:formatBoolean boolean="${mechanismInstance.definedByAuthor}" /></td>
					
						<td>${fieldValue(bean: mechanismInstance, field: "domain")}</td>
					
						<td>${fieldValue(bean: mechanismInstance, field: "mechanismType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mechanismInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
