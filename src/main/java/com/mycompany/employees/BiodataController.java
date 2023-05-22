package com.mycompany.employees;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class BiodataController {
    @Autowired private BiodataService service;
    @GetMapping("/employees")
    public String showBiodataList(Model model){
        List<Biodata> listBiodatas =service.listAll();
        model.addAttribute("listBiodatas", listBiodatas);

        return "employees";

    }

    @GetMapping("/employees/new")
    public String showNewForm(Model model){
        model.addAttribute("biodata", new Biodata());
        model.addAttribute("pageTitle", "Add New Employee");
        return "biodata_form";
    }

    @PostMapping("/employees/save")
    public String saveBiodata(Biodata biodata, RedirectAttributes ra){
        service.save(biodata);
        ra.addFlashAttribute("message", "The employee biodata has been added successfully!");
        return "redirect:/employees";

    }

    @GetMapping("/employees/edit/{id}")
    public  String showEditBiodataForm(@PathVariable("id") Integer id, Model model,RedirectAttributes ra ){
        try {
           Biodata biodata= service.get(id);
           model.addAttribute("biodata", biodata);
            model.addAttribute("pageTitle", "Edit Employee (ID: "+ id +")");
            return "biodata_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/delete/{id}")
    public  String deleteBiodata(@PathVariable("id") Integer id, RedirectAttributes ra ){
        try {
            service.delete(id);

        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/employees";
    }


}
