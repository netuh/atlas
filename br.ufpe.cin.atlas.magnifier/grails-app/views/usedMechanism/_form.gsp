<%@ page import="br.ufpe.cin.atlas.magnifier.UsedMechanism" %>



<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="usedMechanism.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${usedMechanismInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="usedMechanism.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${usedMechanismInstance.year}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'conferenceSource', 'error')} ">
	<label for="conferenceSource">
		<g:message code="usedMechanism.conferenceSource.label" default="Conference Source" />
		
	</label>
	<g:textField name="conferenceSource" value="${usedMechanismInstance?.conferenceSource}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'additionalInformation', 'error')} ">
	<label for="additionalInformation">
		<g:message code="usedMechanism.additionalInformation.label" default="Additional Information" />
		
	</label>
	<g:textField name="additionalInformation" value="${usedMechanismInstance?.additionalInformation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'authors', 'error')} ">
	<label for="authors">
		<g:message code="usedMechanism.authors.label" default="Authors" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: usedMechanismInstance, field: 'mechanismId', 'error')} ">
	<label for="mechanismId">
		<g:message code="usedMechanism.mechanismId.label" default="Mechanism Id" />
		
	</label>
	<g:textField name="mechanismId" value="${usedMechanismInstance?.mechanismId}"/>
</div>

