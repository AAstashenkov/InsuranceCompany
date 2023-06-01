package com.asta.Insurance.service;

import com.asta.Insurance.model.Agent;
import com.asta.Insurance.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository;

    public List<Agent> getAll(String query) {
        if (query != null) {
            return agentRepository.findByQuery(query);
        }
        return agentRepository.findAll();
    }

    public Agent getById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }

    public void updateAgent(Long id, Agent updatedAgent) {
        Agent agent = this.getById(id);

        agent.setSurname(updatedAgent.getSurname());

        agent.setName(updatedAgent.getName());

        agent.setFatherName(updatedAgent.getFatherName());

        agent.setCompany(updatedAgent.getCompany());

        agent.setNumber(updatedAgent.getNumber());


        agentRepository.save(agent);
    }

    public void save(Agent agent) {
        agentRepository.save(agent);
    }

}
