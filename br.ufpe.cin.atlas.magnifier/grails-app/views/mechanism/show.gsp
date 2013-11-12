
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
			
				<g:if test="${mechanismInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="mechanism.content.label" default="Content" /></span>
					
						<span class="property-value" aria-labelledby="content-label"><g:fieldValue bean="${mechanismInstance}" field="content"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.definedByAuthor}">
				<li class="fieldcontain">
					<span id="definedByAuthor-label" class="property-label"><g:message code="mechanism.definedByAuthor.label" default="Defined By Author" /></span>
					
						<span class="property-value" aria-labelledby="definedByAuthor-label"><g:formatBoolean boolean="${mechanismInstance?.definedByAuthor}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.domain}">
				<li class="fieldcontain">
					<span id="domain-label" class="property-label"><g:message code="mechanism.domain.label" default="Domain" /></span>
					
						<span class="property-value" aria-labelledby="domain-label"><g:fieldValue bean="${mechanismInstance}" field="domain"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mechanismInstance?.mechanismType}">
				<li class="fieldcontain">
					<span id="mechanismType-label" class="property-label"><g:message code="mechanism.mechanismType.label" default="Mechanism Type" /></span>
					
						<span class="property-value" aria-labelledby="mechanismType-label"><g:fieldValue bean="${mechanismInstance}" field="mechanismType"/></span>
					
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
