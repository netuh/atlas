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
          ['Year', 'Studies with support mechanism', 'Total of studies']
          <g:each in="${newList}" var="study">
                        ,['${study.year}',     ${study.mech},     ${study.total}]
                  </g:each>
        ]);

        var options = {
          title : 'Mechanism by Year',
          hAxis: {title: "Year",
                           minValue:0},
          seriesType: "bars"
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
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
        <g:form controller="analyses">
                <select name="conference">
                        <option value="EASE">EASE</option>
                        <option value="ESEM">ESEM</option>
                        <option value="ESEJ">ESEJ</option>
                        <option value="All" selected >All</option>
                </select>
                <g:actionSubmit action="mechanismByYear"
                        value="${message(code: 'default.button.update.label', default: 'Update')}" />
        </g:form>
        <div id="chart_div" style="width: 900px; height: 500px;"></div>
        <h1>
                <g:message code="primaryStudy.byType.label"
                        default="Primary Studies by Study Type" />
        </h1>
        <dl>
                <g:each in="${list}" var="study">
                        <dt>
                                <b>${study.key}</b>
                        </dt>
                        <g:each in="${study.value}" var="aStudy">
                        <dd><g:link action="show" controller="primaryStudy" id="${aStudy.getId()}">-${aStudy.getTitle()}</g:link></dd>
                        </g:each>
                </g:each>
        </dl>

</body>
</html>