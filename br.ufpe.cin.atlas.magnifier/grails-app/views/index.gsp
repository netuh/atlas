<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>System Status: <a href="./system">details</a></li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to Atlas Analyzes </h1>
			
			<div id="controller-list" role="navigation">
				<h2>Analyzes:</h2>
				<ul>
					<li class="controller"><g:link controller="analyses" action="generalInfo">General Information</g:link></li>
					<li class="controller"><g:link controller="analyses" action="empiricalStudies">Studies by Empirical Study Type</g:link></li>
					<li class="controller"><g:link controller="analyses" action="analysesByYear">Quantity of Each Empirical Study Type By Year</g:link></li>
					<li class="controller"><g:link controller="analyses" action="badMechanism">The Studies Which Uses Guide and Not</g:link></li>
					<li class="controller"><g:link controller="analyses" action="mechanismUsage">Which Mechanism Are Been Used More Often</g:link></li>
					<li class="controller"><g:link controller="analyses" action="authorProductivity">Which Authors Publish More</g:link></li>
					<li class="controller"><g:link controller="analyses" action="mechanismByYear">How the Studies are Evolving on Mechanism Usage</g:link></li>
					<li class="controller"><g:link controller="analyses" action="predefinedEmpiricalStudies">Studies by Predefined Empirical Study Type</g:link></li>
					<li class="controller"><g:link controller="analyses" action="predefinedAnalysesByYear">Quantity of Each Empirical Predefined Empirical Study Type By Year</g:link></li>
					<li class="controller"><g:link controller="analyses" action="predefinedAnalysesStudyType">predefinedAnalysesStudyType</g:link></li>
					<li class="controller"><g:link controller="analyses" action="countryProductivity">Country Productivity</g:link></li>
					<li class="controller"><g:link controller="analyses" action="institutionProductivity">Institution Productivity</g:link></li>
					<li class="controller"><g:link controller="analyses" action="multMethodDetails">Mult-Method Explained</g:link></li>
				</ul>
				<h2>Upload:</h2>
				<ul>
					<li class="controller"><g:link controller="uploader">Upload Extracted Data</g:link></li>
				</ul>
			</div>
		</div>
	</body>
</html>
