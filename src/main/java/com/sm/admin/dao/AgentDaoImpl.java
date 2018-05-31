package com.sm.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.model.Agents;

@Repository
public class AgentDaoImpl implements AgentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAgentDetails(Agents agents) {
		sessionFactory.getCurrentSession().save(agents);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agents> getAgentsList() {
		return sessionFactory.getCurrentSession().createQuery("from Agents order by agentId desc").list();
	}

	@Override
	public Agents getAgentById(Integer agentId) {
		return (Agents) sessionFactory.getCurrentSession().createQuery("from Agents where agentId=:agentId").setParameter("agentId", agentId).uniqueResult();
	}

}
