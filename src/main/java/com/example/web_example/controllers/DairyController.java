package com.example.web_example.controllers;

import com.example.web_example.models.DairyEntry;
import com.example.web_example.models.DairyEntryComparator;
import com.example.web_example.repo.DairyEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Controller
public class DairyController {

    @Autowired
    private DairyEntryRepository dairyEntryRepository;

    @GetMapping("/")
    public String home(Model model){
        var dairyEntries = getDairyEntries(false);
        model.addAttribute("dairy_entries", dairyEntries);
        model.addAttribute("title", "Дневник грусти");
        //model.addAttribute("order", reversed);
        return "index";
    }

    @GetMapping("/reversed")
    public String home_reversed(Model model){
        var dairyEntries = getDairyEntries(true);
        model.addAttribute("dairy_entries", dairyEntries);
        model.addAttribute("title", "Дневник грусти");
        //model.addAttribute("order", reversed);
        return "index";
    }

    @GetMapping("/dairy_entries")
    public Iterable<DairyEntry> getDairyEntries(boolean order) {
        var dairyEntries = (List<DairyEntry>)dairyEntryRepository.findAll();
        DairyEntryComparator dairyEntryComparator = new DairyEntryComparator();
        //Collections.sort(copy, reversed ? dairyEntryComparator.reversed() : dairyEntryComparator);
        if(order)
            Collections.sort(dairyEntries, dairyEntryComparator);
        else
            Collections.sort(dairyEntries, dairyEntryComparator.reversed());
        return dairyEntries;
    }

    @PostMapping("/post")
    public String dairyPostAdd(@RequestParam String text_entry, Model model) {
        DairyEntry dairyEntry = new DairyEntry(text_entry, dairyEntryRepository);
        dairyEntryRepository.save(dairyEntry);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String dairyPostDelete(@PathVariable(value = "id") long id, Model model) {
        DairyEntry dairyEntry = dairyEntryRepository.findById(id).orElseThrow();
        dairyEntryRepository.delete(dairyEntry);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String dairyPostEdit(@PathVariable(value = "id") long id, @RequestParam String text_entry, Model model) {
        DairyEntry dairyEntry = dairyEntryRepository.findById(id).orElseThrow();
        dairyEntry.setTextEntry(text_entry);
        dairyEntryRepository.save(dairyEntry);
        return "redirect:/";
    }
}
