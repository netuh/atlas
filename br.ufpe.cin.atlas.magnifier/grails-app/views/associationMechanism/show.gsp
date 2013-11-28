
<%@ page import="br.ufpe.cin.atlas.magnifier.AssociationMechanism" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'associationMechanism.label', default: 'AssociationMechanism')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-associationMechanism" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-associationMechanism" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list associationMechanism">
			
				<g:if test="${associationMechanismInstance?.mechanism}">
				<li class="fieldcontain">
					<span id="mechanism-label" class="property-label"><g:message code="associationMechanism.mechanism.label" default="Mechanism" /></span>
					
						<span class="property-value" aria-labelledby="mechanism-label"><g:link controller="usedMechanism" action="show" id="${associationMechanismInstance?.mechanism?.id}">${associationMechanismInstance?.mechanism?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${associationMechanismInstance?.definedByAuthor}">
				<li class="fieldcontain">
					<span id="definedByAuthor-label" class="property-label"><g:message code="associationMechanism.definedByAuthor.label" default="Defined By Author" /></span>
					
						<span class="property-value" aria-labelledby="definedByAuthor-label"><g:formatBoolean boolean="${associationMechanismInstance?.definedByAuthor}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${associationMechanismInstance?.domain}">
				<li class="fieldcontain">
					<span id="domain-label" class="property-label"><g:message code="associationMechanism.domain.label" default="Domain" /></span>
					
						<span class="property-value" aria-labelledby="domain-label"><g:fieldValue bean="${associationMechanismInstance}" field="domain"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${associationMechanismInstance?.mechanismType}">
				<li class="fieldcontain">
					<span id="mechanismType-label" class="property-label"><g:message code="associationMechanism.mechanismType.label" default="Mechanism Type" /></span>
					
						<span class="property-value" aria-labelledby="mechanismType-label"><g:fieldValue bean="${associationMechanismInstance}" field="mechanismType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${associationMechanismInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="associationMechanism.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="primaryStudy" action="show" id="${associationMechanismInstance?.owner?.id}">${associationMechanismInstance?.owner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:associationMechanismInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${associationMechanismInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
