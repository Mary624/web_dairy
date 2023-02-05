package com.example.web_example.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
//@IdClass(UserEntryId.class)
@Table(name="users_entries")
public class UsersEntries {

    @EmbeddedId
    private UserEntryId userEntryId;

}
