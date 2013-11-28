
<%@ page import="br.ufpe.cin.atlas.magnifier.UsedMechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usedMechanism.label', default: 'UsedMechanism')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-usedMechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-usedMechanism" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="mechanismId" title="${message(code: 'usedMechanism.mechanismId.label', default: 'Mechanism Id')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'usedMechanism.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="year" title="${message(code: 'usedMechanism.year.label', default: 'Year')}" />
					
						<g:sortableColumn property="conferenceSource" title="${message(code: 'usedMechanism.conferenceSource.label', default: 'Conference Source')}" />
					
						<g:sortableColumn property="additionalInformation" title="${message(code: 'usedMechanism.additionalInformation.label', default: 'Additional Information')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usedMechanismInstanceList}" status="i" var="usedMechanismInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usedMechanismInstance.id}">${fieldValue(bean: usedMechanismInstance, field: "mechanismId")}</g:link></td>
					
						<td>${fieldValue(bean: usedMechanismInstance, field: "year")}</td>
					
						<td>${fieldValue(bean: usedMechanismInstance, field: "conferenceSource")}</td>
					
						<td>${fieldValue(bean: usedMechanismInstance, field: "additionalInformation")}</td>
					
						<td>${fieldValue(bean: usedMechanismInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usedMechanismInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
