<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="study.dto.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%


	SawonDao dao = new SawonDao();
	List<SawonDto> list = dao.getAllSawonMan();
	JSONArray arr = new JSONArray();
	
	for(SawonDto dto:list){
		JSONObject ob = new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("name",dto.getName());
		ob.put("score",dto.getScore());
		ob.put("gender",dto.getGender());
		ob.put("buseo",dto.getBuseo());
		
		arr.add(ob);
	}
		
%>
<%=arr.toString() %>
