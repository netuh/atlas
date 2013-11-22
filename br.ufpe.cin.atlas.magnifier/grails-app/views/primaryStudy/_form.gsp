<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy" %>



<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'observation', 'error')} ">
	<label for="observation">
		<g:message code="primaryStudy.observation.label" default="Observation" />
		
	</label>
	<g:textField name="observation" value="${primaryStudyInstance?.observation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'mechanisms', 'error')} ">
	<label for="mechanisms">
		<g:message code="primaryStudy.mechanisms.label" default="Mechanisms" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${primaryStudyInstance?.mechanisms?}" var="m">
    <li><g:link controller="associationMechanism" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="associationMechanism" action="create" params="['primaryStudy.id': primaryStudyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'associationMechanism.label', default: 'AssociationMechanism')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'authors', 'error')} ">
	<label for="authors">
		<g:message code="primaryStudy.authors.label" default="Authors" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'conferenceSource', 'error')} ">
	<label for="conferenceSource">
		<g:message code="primaryStudy.conferenceSource.label" default="Conference Source" />
		
	</label>
	<g:textField name="conferenceSource" value="${primaryStudyInstance?.conferenceSource}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'intituitions', 'error')} ">
	<label for="intituitions">
		<g:message code="primaryStudy.intituitions.label" default="Intituitions" />
		
	</label>
	<g:select name="intituitions" from="${br.ufpe.cin.atlas.magnifier.Institution.list()}" multiple="multiple" optionKey="id" size="5" value="${primaryStudyInstance?.intituitions*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'studyId', 'error')} ">
	<label for="studyId">
		<g:message code="primaryStudy.studyId.label" default="Study Id" />
		
	</label>
	<g:textField name="studyId" value="${primaryStudyInstance?.studyId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'studyTypes', 'error')} ">
	<label for="studyTypes">
		<g:message code="primaryStudy.studyTypes.label" default="Study Types" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="primaryStudy.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${primaryStudyInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: primaryStudyInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="primaryStudy.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${primaryStudyInstance.year}" required=""/>
</div>

