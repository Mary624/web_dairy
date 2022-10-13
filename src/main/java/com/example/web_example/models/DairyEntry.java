package com.example.web_example.models;


import com.example.web_example.repo.DairyEntryRepository;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;

@Entity
@Table(name="dairy_entries")
public class DairyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pos;

    public Long getPos() {
        return pos;
    }

    public void setPos(Long pos) {
        this.pos = pos;
    }

    public DairyEntry() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextEntry() {
        return textEntry;
    }

    public void setTextEntry(String textEntry) {
        this.textEntry = textEntry;
    }

    public LocalDate getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(LocalDate dateEntry) {
        this.dateEntry = dateEntry;
    }

    @Column(name="text_entry")
    private String textEntry;

    @Column(name="date_entry")
    private LocalDate dateEntry;

    public DairyEntry(String text_entry, DairyEntryRepository dairyEntryRepository){
        textEntry = text_entry;
        dateEntry = LocalDate.now();
        pos = dairyEntryRepository.count() + 1;
    }
}
