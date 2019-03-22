package com.example.demo.Reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.MongoAccountRepo;
import com.example.demo.entities.SentAccount;

@Component
public class Reciever {


    @Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAccount account) {
        repo.save(account);
    }
}
