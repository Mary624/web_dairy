package com.example.web_example.repo;

import com.example.web_example.models.DairyEntry;
import com.example.web_example.models.User;
import com.example.web_example.models.UserEntryId;
import com.example.web_example.models.UsersEntries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface UsersEntriesRepository extends JpaRepository<UsersEntries, UserEntryId> {

    @Query("select de.userEntryId.entry_id from UsersEntries de where de.userEntryId.entry_id.dateEntry >= ?1 and" +
            " de.userEntryId.entry_id.dateEntry <= ?2 and de.userEntryId.user_id = ?3")
    Page<DairyEntry> findByDatesAndUser(LocalDate start, LocalDate finish, User user, Pageable pageable);
}
