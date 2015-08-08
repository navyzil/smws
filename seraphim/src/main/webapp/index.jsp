<html>
<head>
<script type="text/javascript" src="js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/seraphim-ui-behavior.js"></script>
</head>
<body>
<h2>Welcome to Seraphim Engine (ver1.0-Michael)</h2>
<div id="basicDetails">
	<label>Enter IP Address (default:localhost):</label><input type="text" name="ipAddress" id="ipAddress" value="localhost">
	<br>
	<label>Enter Port (default:8080):</label><input type="text" name="port" id="port" value="8080">
	<br>
	<label>Enter Api:</label><input type="text" name="apiAddress" id="apiAddress">
	<br>
	<label>Select HTTP Methods:</label>
	<select id="httpType" name="httpType">
		<option value="GET">GET</option>
		<option value="POST">POST</option>
		<option value="PUT">PUT</option>
		<option value="DELETE">DELETE</option>
	</select>
</div>
<br/>
<div>
	<label>Parameters (optional):</label>
	<br/>
	<div id="parameterLabel" name="parameterLabel">
		<label>Parameter Name:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>Parameter Value:</label>
	</div>
	<div id="parameterNamesAndValues" name="parameterNamesAndValues">
	</div>
</div>

<div>
	<button id="addParameter" onclick="addParameter();">Add Parameter</button>
	<button id="removeParameter" onclick="removeParameter();">Remove Parameter</button>
</div>
<br/>
<div id="apiExecution">
	<button id="executeApi" name="executeApi" onclick="runApi();">Run Api</button>
</div>
</body>
</html>
