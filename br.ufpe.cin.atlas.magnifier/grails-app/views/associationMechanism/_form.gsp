<%@ page import="br.ufpe.cin.atlas.magnifier.AssociationMechanism" %>



<div class="fieldcontain ${hasErrors(bean: associationMechanismInstance, field: 'definedByAuthor', 'error')} ">
	<label for="definedByAuthor">
		<g:message code="associationMechanism.definedByAuthor.label" default="Defined By Author" />
		
	</label>
	<g:checkBox name="definedByAuthor" value="${associationMechanismInstance?.definedByAuthor}" />
</div>

<div class="fieldcontain ${hasErrors(bean: associationMechanismInstance, field: 'domain', 'error')} ">
	<label for="domain">
		<g:message code="associationMechanism.domain.label" default="Domain" />
		
	</label>
	<g:textField name="domain" value="${associationMechanismInstance?.domain}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: associationMechanismInstance, field: 'mechanism', 'error')} required">
	<label for="mechanism">
		<g:message code="associationMechanism.mechanism.label" default="Mechanism" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mechanism" name="mechanism.id" from="${br.ufpe.cin.atlas.magnifier.Mechanism.list()}" optionKey="id" required="" value="${associationMechanismInstance?.mechanism?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: associationMechanismInstance, field: 'mechanismType', 'error')} ">
	<label for="mechanismType">
		<g:message code="associationMechanism.mechanismType.label" default="Mechanism Type" />
		
	</label>
	<g:textField name="mechanismType" value="${associationMechanismInstance?.mechanismType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: associationMechanismInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="associationMechanism.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${br.ufpe.cin.atlas.magnifier.PrimaryStudy.list()}" optionKey="id" required="" value="${associationMechanismInstance?.owner?.id}" class="many-to-one"/>
</div>

