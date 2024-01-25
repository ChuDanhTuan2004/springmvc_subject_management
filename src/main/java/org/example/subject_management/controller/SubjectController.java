package org.example.subject_management.controller;

import org.example.subject_management.model.Category;
import org.example.subject_management.model.Subject;
import org.example.subject_management.service.ICategoryService;
import org.example.subject_management.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;
    @Autowired
    ICategoryService categoryService;

//    @ModelAttribute("categories")
//    public Iterable<Category> categories(){
//        return categoryService.findAll();
//    }

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("subjectList", subjectService.findAll());
        return "/subject/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("subject", new Subject());
        model.addAttribute("categories", categoryService.findAll());
        return "/subject/create";
    }

    @PostMapping("/create")
    public String create(@Valid Subject subject, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errorList", bindingResult.getAllErrors());
            model.addAttribute("subject", new Subject());
            model.addAttribute("categories", categoryService.findAll());
            return "/subject/create";
        }
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("subject", subjectService.findById(id).get());
        model.addAttribute("categories", categoryService.findAll());
        return "/subject/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Subject subject, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errorList", bindingResult.getAllErrors());
            model.addAttribute("subject", subjectService.findById(subject.getId()).get());
            model.addAttribute("categories", categoryService.findAll());
            return "/subject/edit";
        }
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        subjectService.deleteById(id);
        return "redirect:/subjects";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("subjectList", subjectService.findByName(name));
        return "/subject/result";
    }
}
