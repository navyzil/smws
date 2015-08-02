/**
* Copyright 2014 Denzil Gideon M. Daulo
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License
*/

/**
 * @author Denzil Gideon M. Daulo
 * 
 *  MasterControllerTest acts as the main core for all of the Controller tests <br>
 *  @ParentClass: MasterTestImpl
 * 
 */
package com.zil.seraphim.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.zil.seraphim.test.impl.MasterTestImpl;

@WebAppConfiguration
@Ignore
public class MasterControllerTest extends MasterTestImpl {

	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	@Autowired
	protected MockHttpSession session;
	
	protected MockMvc mockMvc;
	private ObjectMapper mapper;
	private ResultActions resultAction;
	private MockHttpServletResponse mockHttpServletResponse;
	private MediaType mediaType;
	
	@Override
	public void doSetup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	/**
	 * Executes MockMvc request session. 
	 * <br>Default MediaType: MediaType.APPLICATION_JSON
	 * @param url the url that will be encoded
	 * @param httpMethod GET, POST, PUT, DELETE
	 * @param urlVariables can be zero or more variables
	 * @throws Exception 
	 */
	protected void executeMockMvc(String url, HttpMethod httpMethod, Object... urlVariables) throws Exception{
		MockHttpServletRequestBuilder request = executeMockMvcRequestBuilders(url, httpMethod, urlVariables);
		
		request.session(session);
		
		MediaType mediaType = getMediaType();
		request.accept(mediaType);
		
		resultAction = mockMvc.perform(request);
		
		MvcResult returnedValue = resultAction.andReturn();
		mockHttpServletResponse = returnedValue.getResponse();
	}
	
	/**
	 * Executes MockMvc request session. 
	 * <br>Default MediaType: MediaType.APPLICATION_JSON
	 * @param url the url that will be encoded
	 * @param httpMethod GET, POST, PUT, DELETE
	 * @param requestParameters that will be passed to REST not null (e.g. requestParameters.put("characterId", "Char0002"))
	 * @throws Exception 
	 */
	protected void executeMockMvc(String url, HttpMethod httpMethod, Map<String, String> requestParameters) throws Exception{
		MockHttpServletRequestBuilder request = executeMockMvcRequestBuilders(url, httpMethod);
		
		for(Map.Entry<String, String> requestParameter:requestParameters.entrySet()){
			request.param(requestParameter.getKey(), requestParameter.getValue());
		}
		
		request.session(session);
		
		MediaType mediaType = getMediaType();
		request.accept(mediaType);
		
		resultAction = mockMvc.perform(request);
		
		MvcResult returnedValue = resultAction.andReturn();
		mockHttpServletResponse = returnedValue.getResponse();
	}
	
	private MockHttpServletRequestBuilder executeMockMvcRequestBuilders(String url, HttpMethod httpMethod, Object... urlVariables) throws Exception{
		if(httpMethod.equals(HttpMethod.POST)){
			return MockMvcRequestBuilders.post(url, urlVariables);
		}
		else if(httpMethod.equals(HttpMethod.PUT)){
			return MockMvcRequestBuilders.put(url, urlVariables);
		}
		else if(httpMethod.equals(HttpMethod.DELETE)){
			return MockMvcRequestBuilders.delete(url, urlVariables);
		}
		else if(httpMethod.equals(HttpMethod.GET)){
			return MockMvcRequestBuilders.get(url, urlVariables);
		}
		else{
			throw new Exception();
		}
	}

	/**
	 * Retrieve the result action that is given by executeMockMvc 
	 * @return ResultActions never null
	 */
	public ResultActions getResultAction() {
		return resultAction;
	}

	/**
	 * Retrieve the read value of the MockHttpServletResponse
	 * 
	 * @param clazz the Class (e.g. Dog.class) 
	 * @return ReadValue the actual data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public <ReadValue> ReadValue getReadValue(Class<ReadValue> clazz) throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException{
		return mapper.readValue(mockHttpServletResponse.getContentAsString(), clazz);
	}
	
	/**
	 * Retrieve the read value of the MockHttpServletResponse as a Collection
	 * <br>Default return collection: List
	 * 
	 * <br>TODO: Add other collections
	 * 
	 * @param clazz the Class (e.g. Dog.class) 
	 * @return List<ReadValue> return the list of that class (e.g. List<Dog>)
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public <ReadValue> List<ReadValue> getReadCollectionValue(Class<ReadValue> clazz) throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException{
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		return mapper.readValue(mockHttpServletResponse.getContentAsString(), typeFactory.constructCollectionType(ArrayList.class, clazz));
	}

	/**
	 * Set the MediaType for executeMockMvc
	 * @param mediaType (e.g. MediaType.APPLICATION_JSON)
	 */
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	
	private MediaType getMediaType(){
		if(mediaType == null){
			return MediaType.APPLICATION_JSON;
		}
		return mediaType;
	}
}
