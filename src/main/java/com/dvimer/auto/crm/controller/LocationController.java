package com.dvimer.auto.crm.controller;

import com.dvimer.auto.crm.dao.entity.LocationEntity;
import com.dvimer.auto.crm.service.LocationService;
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
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/list")
    public String listAgents(Model theModel) {
        List<LocationEntity> locationEntities = locationService.findAll();
        theModel.addAttribute("locations", locationEntities);
        return "location/list-locations";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        LocationEntity locationEntity = new LocationEntity();
        theModel.addAttribute("location", locationEntity);
        return "location/location-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("locationId") UUID id,
                                    Model theModel) {
        LocationEntity locationEntity = locationService.findById(id);
        theModel.addAttribute("location", locationEntity);
        return "location/location-form";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("location") LocationEntity locationEntity) {
        locationService.save(locationEntity);
        return "redirect:/location/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("locationId") UUID id) {
        locationService.deleteById(id);
        return "redirect:/location/list";
    }

    @ExceptionHandler
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                   Object o, Exception e) {
        System.out.println("Spring MVC ExceptionHandler handling");
        return "redirect:/location/list";
    }
}

