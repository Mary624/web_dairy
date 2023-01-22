package com.example.web_example.repo;

import com.example.web_example.models.DairyEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DairyEntryRepository extends PagingAndSortingRepository<DairyEntry, Long> {
    @Query("select de from DairyEntry de where de.dateEntry >= ?1 and de.dateEntry <= ?2")
    Page<DairyEntry> findByDates(LocalDate start, LocalDate finish, Pageable pageable);

}