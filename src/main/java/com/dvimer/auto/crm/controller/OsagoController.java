package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.hbm2java.Osago;
import com.dvimer.auto.crm.service.OsagoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/osagos")
public class OsagoController {

    private OsagoService osagoService;

    public OsagoController(OsagoService osagoService) {
        this.osagoService = osagoService;
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
    public String showFormForUpdate(@RequestParam("osagoId") int id,
                                    Model theModel) {
        Osago osago = osagoService.findById(id);
        theModel.addAttribute("osago", osago);
        return "osagos/osago-form";
    }

    @PostMapping("/showFormInfo")
    public String showFormInfo(@RequestParam("osagoId") int id,
                                    Model theModel) {
        Osago osago = osagoService.findById(id);
        theModel.addAttribute("osago", osago);
        return "osagos/osago-info";
    }


    @PostMapping("/save")
    public String saveOsago(@ModelAttribute("osago") Osago osago) {
        osagoService.save(osago);
        return "redirect:/osagos/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("osagoId") int id) {
        osagoService.deleteById(id);
        return "redirect:/osagos/list";

    }
}


















