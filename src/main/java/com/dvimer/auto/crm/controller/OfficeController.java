package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.dao.entity.OfficeEntity;
import com.dvimer.auto.crm.service.OfficeService;
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
@RequestMapping("/office")
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping("/list")
    public String listAgents(Model theModel) {
        List<OfficeEntity> officeEntities = officeService.findAll();
        theModel.addAttribute("offices", officeEntities);
        return "office/list-offices";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        OfficeEntity officeEntity = new OfficeEntity();
        theModel.addAttribute("office", officeEntity);
        return "office/office-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("officeId") UUID id,
                                    Model theModel) {
        OfficeEntity officeEntity = officeService.findById(id);
        theModel.addAttribute("office", officeEntity);
        return "office/office-form";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("office") OfficeEntity officeEntity) {
        officeService.save(officeEntity);
        return "redirect:/office/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("officeId") UUID id) {
        officeService.deleteById(id);
        return "redirect:/office/list";
    }

    @ExceptionHandler
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                   Object o, Exception e) {
        System.out.println("Spring MVC ExceptionHandler handling");
        return "redirect:/office/list";
    }
}

