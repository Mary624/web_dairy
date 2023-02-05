package com.example.web_example.controllers;

import com.example.web_example.models.DairyEntry;
import com.example.web_example.models.UserEntryId;
import com.example.web_example.models.UsersEntries;
import com.example.web_example.repo.DairyEntryService;
import com.example.web_example.repo.UsersEntriesService;
import com.example.web_example.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@PreAuthorize("hasAuthority('users:read')")
public class DairyController {
    @Autowired
    private DairyEntryService service;

    @Autowired
    private UsersEntriesService serviceUsersEntries;
    @Autowired
    private CurrentUser currentUser;

    @GetMapping("/")
    public String home(Model model){
        String date = LocalDate.now().toString();
        return String.format("redirect:page/1?sort-field=id&sort-dir=asc&date-start=2022-09-01&date-finish=%s", date);
    }

    @GetMapping(value = "/page/{page-number}")
    public String dairy(@PathVariable(name = "page-number") final int pageNo,
                        @RequestParam(name = "sort-field") final String sortField,
                        @RequestParam(name = "sort-dir") final String sortDir,
                        @RequestParam(name = "date-start") final @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
                        @RequestParam(name = "date-finish") final @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFinish,
                        final Model model){
        final int pageSize = 5;
        currentUser.takeCurrentUser();
        final Page<DairyEntry> page = serviceUsersEntries.findPaginated(pageNo, pageSize, sortField, sortDir,
                dateStart, dateFinish, currentUser.currentUser);
        final List<DairyEntry> listDairyEntries = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("total_elements", serviceUsersEntries.getTotalUsersEntries());
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateFinish", dateFinish);

        model.addAttribute("dairy_entries", listDairyEntries);
        return "index";
    }



    @PostMapping("/post")
    public String dairyPostAdd(@RequestParam String text_entry, Model model) {
        DairyEntry dairyEntry = new DairyEntry(text_entry);
        UserEntryId userEntryId = new UserEntryId();
        userEntryId.setEntry_id(dairyEntry);
        currentUser.takeCurrentUser();
        userEntryId.setUser_id(currentUser.currentUser);
        UsersEntries usersEntries = new UsersEntries();
        usersEntries.setUserEntryId(userEntryId);
        service.save(dairyEntry);
        serviceUsersEntries.save(usersEntries);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String dairyPostDelete(@PathVariable(value = "id") long id, Model model) {
        DairyEntry dairyEntry = service.findById(id);
        service.delete(dairyEntry);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String dairyPostEdit(@PathVariable(value = "id") long id, @RequestParam String text_entry, Model model) {
        DairyEntry dairyEntry = service.findById(id);
        dairyEntry.setTextEntry(text_entry);
        service.save(dairyEntry);
        return "redirect:/";
    }
}
