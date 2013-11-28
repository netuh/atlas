<!DOCTYPE html>
<html>
<head>
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
	<h1>Upload Primary Studies</h1>
	<g:uploadForm action="uploadPrimaryStudy">
        <input type="file" name="myFile" />
        <input type="submit" />
    </g:uploadForm>
    <h1>Upload Mechanisms</h1>
	<g:uploadForm action="uploadMechanism">
        <input type="file" name="myFile" />
        <input type="submit" />
    </g:uploadForm>
</body>