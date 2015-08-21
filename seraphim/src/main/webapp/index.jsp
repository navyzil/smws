<!-- 
Copyright 2014 Denzil Gideon M. Daulo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
@author: Denzil Gideon M. Daulo
@since: ver 1.0
 -->

<html>
<head>
<script type="text/javascript" src="js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/jquery-elastic-1.6.10/jquery.elastic.source.js"></script>
<script type="text/javascript" src="js/jquery.autogrowtextarea.js"></script>
<script type="text/javascript" src="js/seraphim-ui-behavior.js"></script>
<link rel="stylesheet" type="text/css" href="css/seraphim.css"/>
</head>
<body>
<h2>Welcome to Seraphim Engine (ver1.0-Michael)</h2>
<div id="basicDetails">
	<label>Enter IP Address (default:localhost):</label><input type="text" name="ipAddress" id="ipAddress" value="localhost">
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
	<table>
		<tr>
			<td style="width: 750px;">
				<label>Parameters (optional):</label>
				<div id="parameterLabel" name="parameterLabel">
					<label>Parameter Name:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>Parameter Value:</label>
				</div>
				<div id="parameterNamesAndValues" name="parameterNamesAndValues">
				</div>				
				<div>
					<button id="addParameter" onclick="addParameter();"><img id="plusImg" name="plusImg" alt="" src="assets/images/plus.png"></button>
					<button id="removeParameter" onclick="removeParameter();"><img id="minusImg" name="minusImg" alt="" src="assets/images/minus.png"></button>
				</div>
				<br/>
				<div id="apiExecution">
					<button id="executeApi" name="executeApi" onclick="runApi();"><img id="runImg" name="runImg" alt="" src="assets/images/runApi.png"></button>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div id="transactionOutput" name="transactionOutput">	
				</div>
 			</td>
		</tr>
	</table>
</div>
</body>
</html>
