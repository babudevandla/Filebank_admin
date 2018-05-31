package com.sm.admin.dao;

import java.util.List;

import com.sm.admin.model.Agents;

public interface AgentDao {

	void saveAgentDetails(Agents agents);

	List<Agents> getAgentsList();

	Agents getAgentById(Integer agentId);

}
