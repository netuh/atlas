<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'primaryStudy.label', default: 'PrimaryStudy')}" />
<title>Primary Studies by Study Type</title>
</head>
<body>
	<h1>Upload Primary Studies</h1>
	<g:uploadForm action="uploadPrimaryStudy">
        <input type="file" name="myFile" />
        <input type="submit" />
    </g:uploadForm>
    <h1>Upload Mechanisms - NOT IMPLEMENTED</h1>
	<g:uploadForm action="upload">
        <input type="file" name="myFile" />
        <input type="submit" />
    </g:uploadForm>
</body>