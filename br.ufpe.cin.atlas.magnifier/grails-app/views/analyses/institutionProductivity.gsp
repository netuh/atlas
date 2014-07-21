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
			<g:each in="${relevant}" var="mech">
				,['${mech.key}',     ${mech.value.size()}]
			</g:each>
	        ]);
	
	        var options = {
	          title: 'Primary Studies by Study Type'
	        };
	
	        var chart = new google.visualization.ColumnChart(document.getElementById('piechart2'));
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
		<g:select name="minCounter" from="${1..10}" value="${minCounter}"
          noSelection="['2':'-Choose min Reference-']"/>
		<g:actionSubmit action="institutionProductivity"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<div id="piechart2" style="width: 900px; height: 500px;"></div>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="Mechanisms" />
	</h1>
	<dl>
		<g:each in="${relevant}" var="study">
			<dt>
				<b>${study.key}</b>
			</dt>
			<g:each in="${study.value}" var="aStudy">
				<dd><g:link action="show" controller="primaryStudy" id="${aStudy.getId()}">${aStudy.getStudyId()}</g:link>
					-: ${aStudy.getTitle()}
				</dd>
			</g:each>
		</g:each>
	</dl>
</body>