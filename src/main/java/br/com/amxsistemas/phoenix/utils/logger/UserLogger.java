package br.com.amxsistemas.phoenix.utils.logger;

import java.util.UUID;

public class UserLogger {

    private static UUID userLog;

    public static void setUserLog(UUID id) {

        userLog = id;
    }

    public static UUID getUserLog() {
        return userLog;
    }

}
