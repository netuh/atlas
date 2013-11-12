<%@ page import="br.ufpe.cin.atlas.magnifier.PrimaryStudy"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Quantity of Studies']
          <g:each in="${list}" var="study">
			,['${study.key}',     ${study.value}]
		  </g:each>
        ]);

        var options = {
          title : 'Mechanism by Year',
          hAxis: {title: "Year"},
          seriesType: "bars"
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      google.setOnLoadCallback(drawVisualization);
    </script>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'primaryStudy.label', default: 'PrimaryStudy')}" />
<title>Primary Studies by Study Type</title>
</head>
<body>
	<a href="#create-primaryStudy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		</ul>
	</div>
	<g:form controller="mechanism">
		<select name="conference">
			<option value="EASE">EASE</option>
			<option value="ESEM">ESEM</option>
			<option value="ESEJ">ESEJ</option>
			<option value="All" selected >All</option>
		</select>
		<g:actionSubmit action="analyseByYear"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<div id="chart_div" style="width: 900px; height: 500px;"></div>
	<h1>
		<g:message code="primaryStudy.byType.label"
			default="Primary Studies by Study Type" />
	</h1>
	<dl>
		<g:each in="${fullList}" var="study">
			<dt>
				${study.key} : <b>${study.value.size()}</b>
			</dt>
		</g:each>
	</dl>

</body>
</html>
