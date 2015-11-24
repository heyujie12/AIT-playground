package com.ait.agilebuild.mathrun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ait.agilebuild.mathrun.api.IMachineLearning;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/questions"})
public class QuestionServlet extends HttpServlet{
	
	@Inject
	private IMachineLearning ml;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String level = req.getParameter("level");
		Progression<QuestionDefinition> progression = null;
		String progStr = req.getParameter("progression");
		if(progStr == null){
			progression = initProgression(level);
		}else{
			progression = parseProgression(mapper, progStr);
			QuestionDefinition question = ml.produceNextQuestion(progression);
			progression.add(question);
		}
//		req.setAttribute("progression", progression);
		
		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(progression);
		
		
		resp.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = resp.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(jsonInString);
		out.flush();
	}


	private Progression<QuestionDefinition> parseProgression(ObjectMapper mapper, String progStr) throws JsonParseException, JsonMappingException, IOException {
		Progression<Map<String, Object>> p = mapper.readValue(progStr, Progression.class);
		List<QuestionDefinition> questions = new ArrayList<>();
		for(Map<String, Object> map : p.getProgression()){
			QuestionDefinition q = new QuestionDefinition(map);
			questions.add(q);
		}
		System.out.println(p.size());
		return new Progression<>(questions);
	}


	private Progression<QuestionDefinition> initProgression(String level) {
		int levelInt = 1;
		if(level != null){
			levelInt = Integer.parseInt(level);
		}
		
		return ml.initProgression(levelInt);
	}

}
