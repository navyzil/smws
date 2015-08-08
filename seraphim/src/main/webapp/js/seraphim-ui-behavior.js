/**
 * Copyright 2014 Denzil Gideon M. Daulo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 *@author: Denzil Gideon M. Daulo
 *@since: ver 1.0
 */

var parameterCount = 0;
$(function(){
	
});

function addParameter(){
		var htmlText='<input type="text" name="parameterName'+parameterCount+'" id="parameterName'+parameterCount+'">' +
		'<input type="text" name="parameterValue'+parameterCount+'" id="parameterValue'+parameterCount+'">' +
		'<br id="parameterBreakCount'+parameterCount+'" name="parameterBreakCount'+parameterCount+'"/>';
		$("#parameterNamesAndValues").append(htmlText);
		parameterCount++;
}

function removeParameter(){
	if(parameterCount>=0){
		parameterCount--;		

		var parameterName = "#parameterName"+parameterCount;
		var parameterValue = "#parameterValue"+parameterCount;
		var parameterBreakCount = "#parameterBreakCount"+parameterCount;

		$(parameterName).remove();
		$(parameterValue).remove();
		$(parameterBreakCount).remove();
		
	}

}

function runApi(){
	var ipAddress = $("#ipAddress").val();
	var port = $("#port").val();
	var apiAddress = $("#apiAddress").val();
	var urlValue = "http://"+ipAddress+":"+port+"/seraphim/api/"+apiAddress;	
	var httpType = $("#httpType").val();
	
	var data="";//var data={};
	for(i=0; i < parameterCount; i++){
		if(i === 0){
			data = "?";
		}
		var parameterName = $("#parameterName"+i).val();
		var parameterValue = $("#parameterValue"+i).val();
		
		alert("parameterName:"+parameterName+" parameterValue:"+parameterValue);
		//data[parameterName]=parameterValue;
		data+=parameterName+"="+parameterValue;
		if(i < (parameterCount-1)){
			data+="&";
		}
	}
	executeAjax(httpType, urlValue, data);
}

function executeAjax(httpType, urlValue, data){
	
	jQuery.ajax({
        type: httpType,
        url: urlValue+data,
        contentType: "application/json; charset=utf-8",//"application/x-www-form-urlencoded; charset=utf-8",//"application/json; charset=utf-8",
        //data: JSON.stringify(data),
        dataType: "json",
        success: function (data, status, jqXHR) {
            // do something
       	 alert("success");
        },

        error: function (jqXHR, status) {
            // error handler
       	 alert("error");
        }
	 });
}

