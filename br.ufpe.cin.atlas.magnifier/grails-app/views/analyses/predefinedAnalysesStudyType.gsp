<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	      google.load("visualization", "1", {packages:["corechart"]});
	      google.setOnLoadCallback(drawChart);
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
                ['Study Type', 'Number of Primary Studies']
				,['Without Mechanism',     ${allStudies.size()-withMechism.size()}]
                <g:each in="${mechanisms}" var="mechanism" status="i">
                ,['  ${mechanism.key.getMechanismId()}',     ${mechanism.value}]
                </g:each>
                ,['Other Mechanisms',     ${poorMech}]
	        ]);
	
	        var options = {
	          title: 'Mechanisms and guidelines of ${studyType}'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechartFull'));
	        chart.draw(data, options);
	      }
</script>

<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'primaryStudy.label', default: 'PrimaryStudy')}" />
<title>Primary Studies by Study Type</title>
</head>
<body>
	<a href="#create-primaryStudy" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="badMechanism"><g:message code="default.Mechanism.label" default="Mechanism" /></g:link></li>
		</ul>
	</div>
	
	<g:form controller="analyses">
		<select name="conference">
			<option value="EASE"
				<g:if test="${conference == 'EASE'}">selected</g:if>>EASE</option>
			<option value="ESEM"
				<g:if test="${conference == 'ESEM'}">selected</g:if>>ESEM</option>
			<option value="ESEJ"
				<g:if test="${conference == 'ESEJ'}">selected</g:if>>ESEJ</option>
			<option value="All"
				<g:if test="${conference == null || conference == 'All'}">selected</g:if>>All</option>
		</select>
		<select name="studyType">
			<g:each in="${relevantTypes}" var="aStudyType">
				<option value="${aStudyType}">${aStudyType}</option>
			</g:each>
		</select>
		<g:actionSubmit action="predefinedAnalysesStudyType"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="With Mechanism" />
	</h1>
	<div id="piechartFull" style="width: 900px; height: 500px;"></div>
	<dl>
		<g:each in="${withMechism}" var="study">
			<dt><g:link action="show" controller="primaryStudy" id="${study.getId()}">${study.getStudyId()}</g:link>
				-: ${study.getTitle()}
			</dt>
		</g:each>
	</dl>
	
</body>