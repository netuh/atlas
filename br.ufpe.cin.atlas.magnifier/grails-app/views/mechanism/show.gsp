
<%@ page import="br.ufpe.cin.atlas.magnifier.Mechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mechanism.label', default: 'Mechanism')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mechanism" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mechanism">
			
				<g:if test="${mechanismInstance?.mechanismId}">
				<li class="fieldcontain">
					<span id="mechanismId-label" class="property-label"><g:message code="mechanism.mechanismId.label" default="Mechanism Id" /></span>
					
						<span class="property-value" aria-labelledby="mechanismId-label"><g:fieldValue bean="${mechanismInstance}" field="mechanismId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="mechanism.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${mechanismInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.venue}">
				<li class="fieldcontain">
					<span id="venue-label" class="property-label"><g:message code="mechanism.venue.label" default="Venue" /></span>
					
						<span class="property-value" aria-labelledby="venue-label"><g:fieldValue bean="${mechanismInstance}" field="venue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="mechanism.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${mechanismInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.observation}">
				<li class="fieldcontain">
					<span id="observation-label" class="property-label"><g:message code="mechanism.observation.label" default="Observation" /></span>
					
						<span class="property-value" aria-labelledby="observation-label"><g:fieldValue bean="${mechanismInstance}" field="observation"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:mechanismInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${mechanismInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
