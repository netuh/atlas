
<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'primaryStudy.label', default: 'PrimaryStudy')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-primaryStudy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-primaryStudy" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list primaryStudy">
			
				<g:if test="${primaryStudyInstance?.observation}">
				<li class="fieldcontain">
					<span id="observation-label" class="property-label"><g:message code="primaryStudy.observation.label" default="Observation" /></span>
					
						<span class="property-value" aria-labelledby="observation-label"><g:fieldValue bean="${primaryStudyInstance}" field="observation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.authors}">
				<li class="fieldcontain">
					<span id="authors-label" class="property-label"><g:message code="primaryStudy.authors.label" default="Authors" /></span>
					
						<span class="property-value" aria-labelledby="authors-label"><g:fieldValue bean="${primaryStudyInstance}" field="authors"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.intituitions}">
				<li class="fieldcontain">
					<span id="intituitions-label" class="property-label"><g:message code="primaryStudy.intituitions.label" default="Intituitions" /></span>
					
						<g:each in="${primaryStudyInstance.intituitions}" var="i">
						<span class="property-value" aria-labelledby="intituitions-label"><g:link controller="institution" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.mechanisms}">
				<li class="fieldcontain">
					<span id="mechanisms-label" class="property-label"><g:message code="primaryStudy.mechanisms.label" default="Mechanisms" /></span>
					
						<g:each in="${primaryStudyInstance.mechanisms}" var="m">
						<span class="property-value" aria-labelledby="mechanisms-label"><g:link controller="mechanism" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.studyId}">
				<li class="fieldcontain">
					<span id="studyId-label" class="property-label"><g:message code="primaryStudy.studyId.label" default="Study Id" /></span>
					
						<span class="property-value" aria-labelledby="studyId-label"><g:fieldValue bean="${primaryStudyInstance}" field="studyId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.studyType}">
				<li class="fieldcontain">
					<span id="studyType-label" class="property-label"><g:message code="primaryStudy.studyType.label" default="Study Type" /></span>
					
						<span class="property-value" aria-labelledby="studyType-label"><g:fieldValue bean="${primaryStudyInstance}" field="studyType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="primaryStudy.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${primaryStudyInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${primaryStudyInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="primaryStudy.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${primaryStudyInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:primaryStudyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${primaryStudyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
