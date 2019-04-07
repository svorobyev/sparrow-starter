package com.app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MailNotifier {

    private final MailHolder mailHolder;

    public void sendMailNotification(String msg) {
        System.out.println("Notification: " + msg);
        System.out.println("E-mail sent to " + mailHolder.getDba());
    }
}
