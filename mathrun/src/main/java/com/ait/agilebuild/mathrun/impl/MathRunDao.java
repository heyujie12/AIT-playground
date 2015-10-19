package com.ait.agilebuild.mathrun.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.model.Game;

public class MathRunDao implements IMathRunDao {

	@Inject
	private EntityManager em;

	@Override
	public List<Game> getGames(long studentId) {
		Query query = em.createQuery("SELECT g FROM Game g where g.student = :studentId");
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

}
