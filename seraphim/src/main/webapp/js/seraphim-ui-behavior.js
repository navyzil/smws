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

function runApi(){
	var ipAddress = $("#ipAddress").val();
	var port = $("#port").val();
	var apiAddress = $("#apiAddress").val();
	var urlValue = "http://"+ipAddress+":"+port+"/seraphim/api/"+apiAddress;	
	var httpType = $("#httpType").val();
	
	executeAjax(httpType, urlValue);
}

function executeAjax(httpType, urlValue){
	
	jQuery.ajax({
        type: httpType,
        url: urlValue,
        contentType: "application/json; charset=utf-8",
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

