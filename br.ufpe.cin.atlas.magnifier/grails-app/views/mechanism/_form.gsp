<%@ page import="br.ufpe.cin.atlas.magnifier.Mechanism" %>



<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'mechanismId', 'error')} ">
	<label for="mechanismId">
		<g:message code="mechanism.mechanismId.label" default="Mechanism Id" />
		
	</label>
	<g:textArea name="mechanismId" cols="40" rows="5" maxlength="5000" value="${mechanismInstance?.mechanismId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="mechanism.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${mechanismInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'venue', 'error')} ">
	<label for="venue">
		<g:message code="mechanism.venue.label" default="Venue" />
		
	</label>
	<g:textField name="venue" value="${mechanismInstance?.venue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="mechanism.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${mechanismInstance.year}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: mechanismInstance, field: 'observation', 'error')} ">
	<label for="observation">
		<g:message code="mechanism.observation.label" default="Observation" />
		
	</label>
	<g:textField name="observation" value="${mechanismInstance?.observation}"/>
</div>

