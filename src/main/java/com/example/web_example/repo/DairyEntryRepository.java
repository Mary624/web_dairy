package com.example.web_example.repo;

import com.example.web_example.models.DairyEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DairyEntryRepository extends CrudRepository<DairyEntry, Long> {

}