package br.com.amxsistemas.phoenix.utils;

import java.util.UUID;

public class UserLogger {

    private UUID userLog;

    public void setUserLog() {
        userLog = UUID.fromString("0");
    }

    public UUID getUserLog() {
        return userLog;
    }

}
