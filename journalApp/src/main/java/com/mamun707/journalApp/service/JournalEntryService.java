package com.mamun707.journalApp.service;

import com.mamun707.journalApp.entity.JournalEntry;
import com.mamun707.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;


    public void saveEntry(JournalEntry journalEntry){
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries(){
        return journalEntryRepo.findAll();
    }

    @Cacheable(value = "journal", key = "ObjectId")

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
    }


}


// controller ----> service  ---> repository