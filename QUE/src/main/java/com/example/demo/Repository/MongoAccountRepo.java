package com.example.demo.Repository;
import com.example.demo.Sender.*;
import com.example.demo.entities.SentAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAccountRepo extends MongoRepository<SentAccount, Long>{
}