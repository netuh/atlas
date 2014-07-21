<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' ,'Experiment']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${experiment.get(year) == null ? 0 : experiment.get(year).size()}
          ]
          </g:each>
          ]);

       var options = {
    	   pointSize: 3,
           title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('experiment_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' , 'Case Study']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${caseStudies.get(year) == null ? 0 : caseStudies.get(year).size()}
          			 
          ]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('case_study_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' ,'EBSE']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${ssStudies.get(year) == null ? 0 : ssStudies.get(year).size()}
          ]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('esbe_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' ,'Survey']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${surveys.get(year) == null ? 0 : surveys.get(year).size()}]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('survey_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year','Ethnograph']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${ethnographes.get(year) == null ? 0 : ethnographes.get(year).size()}]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('eth_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' , 'Mixed Method']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${mixedMethods.get(year) == null ? 0 : mixedMethods.get(year).size()}]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('mix_chart'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' ,'Not identified']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${notIdentified.get(year) == null ? 0 : notIdentified.get(year).size()}]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('other_chart2'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year', 'Others']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${others.get(year) == null ? 0 : others.get(year).size()}]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('other_chart3'));
       chart.draw(data, options);
     }
</script>
<script type="text/javascript">
     google.load("visualization", "1", {packages:["corechart"]});
     google.setOnLoadCallback(drawChart);
     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Year' ,'Experiment', 'Case Study', 'Survey', 'Ethnograph', 'EBSE', 'Mixed Method', 'Not identified', 'Others']

         <g:each in="${years}" var="year" status="i">
          ,['${year}',${experiment.get(year) == null ? 0 : experiment.get(year).size()}
          			 ,${caseStudies.get(year) == null ? 0 : caseStudies.get(year).size()}
          			 ,${surveys.get(year) == null ? 0 : surveys.get(year).size()}
          		 	 ,${ethnographes.get(year) == null ? 0 : ethnographes.get(year).size()}
          		  	 ,${ssStudies.get(year) == null ? 0 : ssStudies.get(year).size()}
          		  	 ,${mixedMethods.get(year) == null ? 0 : mixedMethods.get(year).size()}
          		     ,${notIdentified.get(year) == null ? 0 : notIdentified.get(year).size()}
          		     ,${others.get(year) == null ? 0 : others.get(year).size()}
          ]
          </g:each>
          ]);

       var options = {
    	 pointSize: 3,
         title: 'Company Performance'
       };

       var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
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
		<g:actionSubmit action="predefinedAnalysesByYear"
			value="${message(code: 'default.button.update.label', default: 'Update')}" />
	</g:form>
	<h1>Primary Studies by Year</h1>
	<div id="experiment_chart" style="width: 900px; height: 500px;"></div>
	<div id="case_study_chart" style="width: 900px; height: 500px;"></div>
	<div id="esbe_chart" style="width: 900px; height: 500px;"></div>
	<div id="survey_chart" style="width: 900px; height: 500px;"></div>
	<div id="eth_chart" style="width: 900px; height: 500px;"></div>
	<div id="mix_chart" style="width: 900px; height: 500px;"></div>
	<div id="other_chart2" style="width: 900px; height: 500px;"></div>
	<div id="other_chart3" style="width: 900px; height: 500px;"></div>
	<div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>
