package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.dao.entity.AgentEnity;
import com.dvimer.auto.crm.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agents")
public class AgentController {

    private final AgentService agentService;

    @GetMapping("/list")
    public String listAgents(Model theModel) {
        List<AgentEnity> agentEnities = agentService.findAll();
        theModel.addAttribute("agents", agentEnities);
        return "agents/list-agents";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        AgentEnity agentEnity = new AgentEnity();
        theModel.addAttribute("agent", agentEnity);
        return "agents/agent-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("agentId") int id,
                                    Model theModel) {
        AgentEnity agentEnity = agentService.findById(id);
        theModel.addAttribute("agent", agentEnity);
        return "agents/agent-form";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("agent") AgentEnity agentEnity) {
        agentService.save(agentEnity);
        return "redirect:/agents/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("agentId") int id) {
        agentService.deleteById(id);
        return "redirect:/agents/list";
    }

    @ExceptionHandler
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                   Object o, Exception e) {
        System.out.println("Spring MVC ExceptionHandler handling");
        return "redirect:/agents/list";
    }
}

