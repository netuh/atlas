
<%@ page import="br.ufpe.cin.atlas.magnifier.UsedMechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usedMechanism.label', default: 'UsedMechanism')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-usedMechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-usedMechanism" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usedMechanism">
			
				<g:if test="${usedMechanismInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="usedMechanism.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${usedMechanismInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usedMechanismInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="usedMechanism.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${usedMechanismInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usedMechanismInstance?.conferenceSource}">
				<li class="fieldcontain">
					<span id="conferenceSource-label" class="property-label"><g:message code="usedMechanism.conferenceSource.label" default="Conference Source" /></span>
					
						<span class="property-value" aria-labelledby="conferenceSource-label"><g:fieldValue bean="${usedMechanismInstance}" field="conferenceSource"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usedMechanismInstance?.additionalInformation}">
				<li class="fieldcontain">
					<span id="additionalInformation-label" class="property-label"><g:message code="usedMechanism.additionalInformation.label" default="Additional Information" /></span>
					
						<span class="property-value" aria-labelledby="additionalInformation-label"><g:fieldValue bean="${usedMechanismInstance}" field="additionalInformation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usedMechanismInstance?.authors}">
				<li class="fieldcontain">
					<span id="authors-label" class="property-label"><g:message code="usedMechanism.authors.label" default="Authors" /></span>
					
						<span class="property-value" aria-labelledby="authors-label"><g:fieldValue bean="${usedMechanismInstance}" field="authors"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usedMechanismInstance?.mechanismId}">
				<li class="fieldcontain">
					<span id="mechanismId-label" class="property-label"><g:message code="usedMechanism.mechanismId.label" default="Mechanism Id" /></span>
					
						<span class="property-value" aria-labelledby="mechanismId-label"><g:fieldValue bean="${usedMechanismInstance}" field="mechanismId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:usedMechanismInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${usedMechanismInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
