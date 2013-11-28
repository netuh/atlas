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
				,['${studyType} Studies without Mech',     ${allStudies.size()-withMechism.size()}]
                ,['${studyType} Studies with Mech and Guide',     ${withGuideline.size()}]
                ,['${studyType} Studies with only other Mechs',     ${withMechism.size()-withGuideline.size()}]
	        ]);
	
	        var options = {
	          title: 'Mechanisms and guidelines of ${studyType}'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechartFull'));
	        chart.draw(data, options);
	      }
</script>

<script type="text/javascript">
	      google.load("visualization", "1", {packages:["corechart"]});
	      google.setOnLoadCallback(drawChart);
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
                ['Study Type', 'Number of Primary Studies']
				,['Studies without Mech',     ${allStudies.size()-withMechism.size()}]
                ,['Studies with Mech',     ${withMechism.size()}]
	        ]);
	
	        var options = {
	          title: 'Which ${studyType} use any mechanism'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechartWithMech'));
	        chart.draw(data, options);
	      }
</script>
<script type="text/javascript">
	      google.load("visualization", "1", {packages:["corechart"]});
	      google.setOnLoadCallback(drawChart);
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
                ['Study Type', 'Number of Primary Studies']
				,['Studies without Guideline',     ${allStudies.size()-withGuideline.size()}]
                ,['Studies with Guideline',     ${withGuideline.size()}]
	        ]);
	
	        var options = {
	          title: 'Which ${studyType} use a guideline'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechartWithGuide'));
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
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="Complete Graph about ${studyType}" />
	</h1>
	<div id="piechartFull" style="width: 900px; height: 500px;"></div>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="With Mechanism" />
	</h1>
	<div id="piechartWithMech" style="width: 900px; height: 500px;"></div>
	<dl>
		<g:each in="${withMechism}" var="study">
			<dt><g:link action="show" controller="primaryStudy" id="${study.getId()}">${study.getStudyId()}</g:link>
				-: ${study.getTitle()}
			</dt>
		</g:each>
	</dl>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="With Guideline" />
	</h1>
	<div id="piechartWithGuide" style="width: 900px; height: 500px;"></div>
	<dl>
		<g:each in="${withGuideline}" var="study">
			<dt><g:link action="show" controller="primaryStudy" id="${study.getId()}">${study.getStudyId()}</g:link>
				-: ${study.getTitle()}
			</dt>
		</g:each>
	</dl>
</body>