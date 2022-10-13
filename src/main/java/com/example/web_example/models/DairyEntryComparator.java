package com.example.web_example.models;

import java.util.Comparator;

public class DairyEntryComparator implements Comparator<DairyEntry> {

    public int compare(DairyEntry e1, DairyEntry e2) {
        if (e1.getPos() == e2.getPos()) {
            return 0;
        }
        if (e1.getPos() > e2.getPos()) {
            return 1;
        } else {
            return -1;
        }
    }
}
