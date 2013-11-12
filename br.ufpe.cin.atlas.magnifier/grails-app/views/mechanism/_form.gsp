<%@ page import="br.ufpe.cin.atlas.magnifier.Mechanism" %>



<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="mechanism.content.label" default="Content" />
		
	</label>
	<g:textField name="content" value="${mechanismInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'definedByAuthor', 'error')} ">
	<label for="definedByAuthor">
		<g:message code="mechanism.definedByAuthor.label" default="Defined By Author" />
		
	</label>
	<g:checkBox name="definedByAuthor" value="${mechanismInstance?.definedByAuthor}" />
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'domain', 'error')} ">
	<label for="domain">
		<g:message code="mechanism.domain.label" default="Domain" />
		
	</label>
	<g:textField name="domain" value="${mechanismInstance?.domain}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'mechanismType', 'error')} ">
	<label for="mechanismType">
		<g:message code="mechanism.mechanismType.label" default="Mechanism Type" />
		
	</label>
	<g:textField name="mechanismType" value="${mechanismInstance?.mechanismType}"/>
</div>

