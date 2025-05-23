package com.studies.training.service;

import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;

@Service
public class TwilioService {

    public void sendMessage(String messageToBeSent) {
        Message message = Message.creator(new com.twilio.type.PhoneNumber("+5515997489446"),
                new com.twilio.type.PhoneNumber("+13365717967"),
                messageToBeSent)
                .create();
        System.out.println(message.getBody());
    }
}
