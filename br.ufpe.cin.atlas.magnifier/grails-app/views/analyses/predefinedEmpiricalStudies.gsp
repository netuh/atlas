<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy"%>
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
			<g:each in="${list}" var="study">
				,['${study.key}',     ${study.value.size()}]
			</g:each> 
	        ]);
	
	        var options = {
	          title: 'Primary Studies by Study Type',
	          slices: {
	              0: { color: '#000000' },
	              1: { color: '#404040' },
	              2: { color: '#505050' },
	              3: { color: '#707070' },
	              4: { color: '#808080' },
	              5: { color: '#909090' },
	              6: { color: '#b0b0b0' },
	              7: { color: '#c9c9c9' },
	              8: { color: '#D5D5D5' }
	            }
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
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
		<g:actionSubmit action="predefinedEmpiricalStudies"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<div id="piechart2" style="width: 900px; height: 500px;"></div>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="Primary Studies by Study Type" />
	</h1>
	<dl>
		<g:each in="${list}" var="study">
			<dt>
				<b>
					${study.key}
				</b>
			</dt>
		</g:each>
	</dl>

</body>
</html>
