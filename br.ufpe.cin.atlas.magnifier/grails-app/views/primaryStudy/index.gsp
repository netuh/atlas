
<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'primaryStudy.label', default: 'PrimaryStudy')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-primaryStudy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-primaryStudy" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="studyId" title="${message(code: 'primaryStudy.studyId.label', default: 'Study Id')}" />
					
						<g:sortableColumn property="conferenceSource" title="${message(code: 'primaryStudy.conferenceSource.label', default: 'Conference Source')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'primaryStudy.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="year" title="${message(code: 'primaryStudy.year.label', default: 'Year')}" />
						
						<g:sortableColumn property="observation" title="${message(code: 'primaryStudy.observation.label', default: 'Observation')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${primaryStudyInstanceList}" status="i" var="primaryStudyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${primaryStudyInstance.id}">${fieldValue(bean: primaryStudyInstance, field: "studyId")}</g:link></td>
					
						<td>${fieldValue(bean: primaryStudyInstance, field: "conferenceSource")}</td>
					
						<td>${fieldValue(bean: primaryStudyInstance, field: "year")}</td>
					
						<td>${fieldValue(bean: primaryStudyInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: primaryStudyInstance, field: "observation")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${primaryStudyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
