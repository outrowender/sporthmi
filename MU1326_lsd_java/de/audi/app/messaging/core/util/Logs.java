/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.atip.log.LogChannel;
import java.text.MessageFormat;

public final class Logs {
    public static void logException(LogChannel logChannel, Throwable throwable, String string) {
        logChannel.log(10000, "%1 An exception occurred: ", (Object)string, throwable);
    }

    public static void logException(LogChannel logChannel, Throwable throwable, String string, Object[] objectArray) {
        String string2;
        try {
            string2 = MessageFormat.format(string, objectArray);
        }
        catch (Exception exception) {
            string2 = "";
        }
        Logs.logException(logChannel, throwable, string2);
    }

    public static void logNullParameter(LogChannel logChannel, String string) {
        logChannel.log(10000, "%1 An illegal null parameter has been passed.", (Object)string);
    }

    public static void logNullParameter(LogChannel logChannel, String string, Object[] objectArray) {
        String string2;
        try {
            string2 = MessageFormat.format(string, objectArray);
        }
        catch (Exception exception) {
            string2 = "";
        }
        Logs.logNullParameter(logChannel, string2);
    }
}

