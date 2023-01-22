package com.example.web_example.repo;

import com.example.web_example.models.DairyEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DairyEntryService {

    @Autowired
    private DairyEntryRepository repository;

    public void save(final DairyEntry dairyEntry) {
        repository.save(dairyEntry);
    }

    public DairyEntry findById(final Long id){
        DairyEntry dairyEntry = repository.findById(id).orElseThrow();
        return dairyEntry;
    }

    public void delete(final DairyEntry dairyEntry) {
        repository.delete(dairyEntry);
    }

    public long getTotalDairyEntries() {
        return repository.count();
    }

    private List<Long> getFilteredList(List<DairyEntry> list, LocalDate start, LocalDate finish){
        List<Long> result = new ArrayList<>();
        for (var dairyEntry: list) {
            boolean isAfterOrEqual = dairyEntry.getDateEntry().isAfter(start) || dairyEntry.getDateEntry().isEqual(start);
            boolean isBeforeOrEqual = dairyEntry.getDateEntry().isBefore(finish) || dairyEntry.getDateEntry().isEqual(finish);
            if(isAfterOrEqual && isBeforeOrEqual)
                result.add(dairyEntry.getId());
        }
        return result;
    }

    public Page<DairyEntry> findPaginated(final int pageNumber, final int pageSize,
                                          final String sortField, final String sortDirection,
                                          LocalDate start, LocalDate finish) {
        final Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        final Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return repository.findByDates(start, finish, pageable);
    }
}
