package com.example.web_example.models;


import com.example.web_example.repo.DairyEntryRepository;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="dairy_entries")
public class DairyEntry {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public DairyEntry() {

    }
    @NonNull
    @Column(name="text_entry")
    private String textEntry;

    @NonNull
    @Column(name="date_entry")
    private LocalDate dateEntry;

    public DairyEntry(String text_entry){
        textEntry = text_entry;
        dateEntry = LocalDate.now();
    }
}
