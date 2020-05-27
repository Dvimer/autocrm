package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.dao.entity.*;
import com.dvimer.auto.crm.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/osagos")
public class OsagoController {

    private final OsagoService osagoService;
    private final AgentService agentService;
    private final InsurerService insurerService;
    private final OfficeService officeService;
    private final LocationService locationService;

    @ModelAttribute("agents")
    public List<AgentEnity> findAllAgent() {
        return agentService.findAll();
    }

    @ModelAttribute("locations")
    public List<LocationEntity> findAllLocations() {
        return locationService.findAll();
    }

    @ModelAttribute("offices")
    public List<OfficeEntity> findAllOffices() {
        return officeService.findAll();
    }

    @ModelAttribute("insurers")
    public List<InsurerEntity> findAllInsurers() {
        return insurerService.findAll();
    }

    @GetMapping("/list")
    public String listOsagos(Model theModel) {
        List<Osago> osagos = osagoService.findAll();
        theModel.addAttribute("osago", osagos);
        return "osagos/list-osagos";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Osago osago = new Osago();
        theModel.addAttribute("osago", osago);
        return "osagos/osago-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("osagoId") UUID id, Model theModel) {
        Osago osago = osagoService.findById(id);
        theModel.addAttribute("osago", osago);
        return "osagos/osago-form";
    }

    @PostMapping("/showFormInfo")
    public String showFormInfo(@RequestParam("osagoId") UUID id, Model theModel) {
        Osago osago = osagoService.findById(id);
        theModel.addAttribute("osago", osago);
        return "osagos/osago-info";
    }

    @PostMapping("/save")
    public String saveOsago(@ModelAttribute("osago") Osago osago) {
        if (validate(osago)) {
            osagoService.save(osago);
            return "redirect:/osagos/list";
        }
        return "redirect:/error/403.html";
    }

    private boolean validate(Osago osago) {
        return osago.getAgent() != null;
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("osagoId") UUID id) {
        osagoService.deleteById(id);
        return "redirect:/osagos/list";
    }
}


