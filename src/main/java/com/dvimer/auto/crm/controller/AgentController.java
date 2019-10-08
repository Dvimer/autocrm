package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.hbm2java.Agent;
import com.dvimer.auto.crm.service.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentsService agentsService;

    @GetMapping("/list")
    public String listAgents(Model theModel) {
        List<Agent> agents = agentsService.findAll();
        theModel.addAttribute("agents", agents);
        return "agents/list-agents";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Agent agent = new Agent();
        theModel.addAttribute("agent", agent);
        return "agents/agent-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("agentId") int id,
                                    Model theModel) {
        Agent agent = agentsService.findById(id);
        theModel.addAttribute("agent", agent);
        return "agents/agent-form";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        agentsService.save(agent);
        return "redirect:/agents/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("agentId") int id) {
        agentsService.deleteById(id);
        return "redirect:/agents/list";
    }
}

