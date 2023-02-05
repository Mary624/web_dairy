package com.example.web_example.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class UserEntryId implements Serializable {
    private static final long serialVersionUID = -2202289067551407434L;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_id", referencedColumnName = "id")
    private DairyEntry entry_id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    public UserEntryId(DairyEntry entry_id, User user_id){
        this.entry_id = entry_id;
        this.user_id = user_id;
    }

    public UserEntryId(){
    }
}