package com.example.web_example.repo;

import com.example.web_example.models.DairyEntry;
import com.example.web_example.models.User;
import com.example.web_example.models.UserEntryId;
import com.example.web_example.models.UsersEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsersEntriesService {

    @Autowired
    private UsersEntriesRepository repository;

    public void save(final UsersEntries usersEntries) {
        repository.save(usersEntries);
    }

    public UsersEntries findById(final UserEntryId id){
        UsersEntries usersEntries = repository.findById(id).orElseThrow();
        return usersEntries;
    }

    public void delete(final UsersEntries usersEntries) {
        repository.delete(usersEntries);
    }

    public long getTotalUsersEntries() {
        return repository.count();
    }

    public Page<DairyEntry> findPaginated(final int pageNumber, final int pageSize,
                                          final String sortField, final String sortDirection,
                                          LocalDate start, LocalDate finish, User user) {
        final Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by("userEntryId.entry_id." + sortField).ascending() : Sort.by("userEntryId.entry_id." + sortField).descending();
        final Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return repository.findByDatesAndUser(start, finish, user, pageable);
    }
}
