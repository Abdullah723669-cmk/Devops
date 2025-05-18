package com.mamun707.journalApp.repository;

import com.mamun707.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository <JournalEntry, ObjectId> {

}
