package com.asta.Insurance.controller;

import com.asta.Insurance.model.Agent;
import com.asta.Insurance.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @GetMapping
    public String getAll(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Agent> agents = agentService.getAll(query);
        model.addAttribute("agents", agents);
        return "agents";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Agent agent = agentService.getById(id);
        model.addAttribute("agent", agent);
        return "viewAgent";
    }

    @PostMapping("/delete/{id}")
    public String deleteAgent(@PathVariable Long id){
        agentService.deleteAgent(id);
        return "redirect:/agents";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Agent agent = agentService.getById(id);
        model.addAttribute("agent", agent);
        return "editAgent";
    }


    @PostMapping("/edit/{id}")
    public String updateAgent(@PathVariable Long id, @ModelAttribute Agent updatedAgent) {
        agentService.updateAgent(id, updatedAgent);
        return "redirect:/agents/" + id;
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        agentService.save(agent);
        return "redirect:/agents";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("agent", new Agent());
        return "addAgent";
    }
    @PostMapping("/add")
    public String addAgent(@ModelAttribute(name = "agent") Agent agent) {
        agentService.save(agent);
        return "redirect:/agents";
    }

}
