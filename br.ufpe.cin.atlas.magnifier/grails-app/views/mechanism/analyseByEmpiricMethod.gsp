<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<g:each in="${list}" var="studyType">
	<script type="text/javascript">
	      google.load("visualization", "1", {packages:["corechart"]});
	      google.setOnLoadCallback(drawChart);
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
                ['Study Type', 'Number of Primary Studies']
			<g:each in="${studyType.value}" var="study">
				,['${study.key}',     ${study.value.size()}]
			</g:each> 
	        ]);
	
	        var options = {
	          title: '${studyType.key} by Empirical Method'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('${studyType.key}'));
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
	<h1>Mechanism by Empirical Method</h1>
	<g:each in="${list}" var="study">
		<p><b>${study.key}</b></p>
		<div id="${study.key}" style="width: 900px; height: 500px;"></div>
	</g:each>

</body>
</html>
