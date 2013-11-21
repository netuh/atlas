<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<g:each in="${list}" var="studyType">
	<script type="text/javascript">
		google.load("visualization", "1", {
			packages : [ "corechart" ]
		});
		google.setOnLoadCallback(drawChart);
		function drawChart() {
			var data = google.visualization.arrayToDataTable([
					[ 'Year', 'Quantity of primary Studies' ]
					<g:each in="${studyType.value}" var="studyYear">
					, [ '${studyYear.key}', ${studyYear.value.size()} ]
					</g:each>
					]);

			var options = {
				title : '${studyType.key}',
				hAxis: {title: "Primary Studies"},
				vAxis: {minValue:0},
				pointSize: 3
			};

			var chart = new google.visualization.LineChart(document
					.getElementById('${studyType.key}'));
			chart.draw(data, options);
		}
	</script>
</g:each>
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
	<g:form controller="primaryStudy">
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
		<g:actionSubmit action="analysesByYear"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<h1>Primary Studies by Year</h1>
	<g:each in="${list}" var="study">
		<p>
			<b>
				${study.key}
			</b>
		</p>
		<div id="${study.key}" style="width: 900px; height: 500px;"></div>
	</g:each>

</body>
</html>
