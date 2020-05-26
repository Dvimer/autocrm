package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.dao.entity.InsurerEntity;
import com.dvimer.auto.crm.service.InsurerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/insurer")
public class InsurerController {

    private final InsurerService insurerService;

    @GetMapping("/list")
    public String listAgents(Model theModel) {
        List<InsurerEntity> insurerEntities = insurerService.findAll();
        theModel.addAttribute("insurers", insurerEntities);
        return "insurer/list-insurers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        InsurerEntity insurerEntity = new InsurerEntity();
        theModel.addAttribute("insurer", insurerEntity);
        return "insurer/insurer-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("insurerId") UUID id,
                                    Model theModel) {
        InsurerEntity insurerEntity = insurerService.findById(id);
        theModel.addAttribute("insurer", insurerEntity);
        return "insurer/insurer-form";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("insurer") InsurerEntity insurerEntity) {
        insurerService.save(insurerEntity);
        return "redirect:/insurer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("insurerId") UUID id) {
        insurerService.deleteById(id);
        return "redirect:/insurer/list";
    }

    @ExceptionHandler
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                   Object o, Exception e) {
        System.out.println("Spring MVC ExceptionHandler handling");
        return "redirect:/insurer/list";
    }
}

