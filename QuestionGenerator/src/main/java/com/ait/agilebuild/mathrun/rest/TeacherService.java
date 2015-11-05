package com.ait.agilebuild.mathrun.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ait.agilebuild.mathrun.api.IMathRunDao;

@Path("/teacher")
public class TeacherService {
	@Inject
	private IMathRunDao dao;
	@GET
	public String hello() {
		return "Hello world [" + dao.getGames(1) + "]";
	}

}
