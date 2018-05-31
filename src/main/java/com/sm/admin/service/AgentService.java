package com.sm.admin.service;

import java.util.List;

import com.sm.admin.dto.AgentsDto;
import com.sm.admin.model.Agents;

public interface AgentService {

	void saveAgentDetails(AgentsDto agentsDto);

	List<Agents> getAgentsList();

	Agents getAgentById(Integer agentId);

}
