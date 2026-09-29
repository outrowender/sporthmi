/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.util.PhoneServices$1;
import de.audi.app.messaging.core.util.PhoneServices$2;
import de.audi.app.messaging.core.util.PhoneServices$3;
import de.audi.app.messaging.core.util.PhoneServices$4;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import org.dsi.ifc.organizer.AdbEntry;

public final class PhoneServices {
    public static void callUnmatchedNumber(String string, LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1078071040, "[PhoneServices#callMatchedNumber] Attempting to call unmatched number = %1", (Object)string);
        ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(-1601830656, "[PhoneServices#callMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneServices$1(iTelService, string, logChannel));
        }
    }

    public static void prepareUnmatchedNumber(String string, LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1078071040, "[PhoneServices#prepareUnmatchedNumber] Attempting to prepare a unmatched number for dial = %1", (Object)string);
        ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(-1601830656, "[PhoneServices#prepareUnmatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneServices$2(iTelService, string, logChannel));
        }
    }

    public static void callMatchedNumber(String string, AdbEntry adbEntry, int n, LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1078071040, "[PhoneServices#callMatchedNumber] Attempting to call contact %1, number = %2", (Object)adbEntry.getCombinedName(), (Object)string);
        ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(-1601830656, "[PhoneServices#callMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneServices$3(iTelService, adbEntry, string, n, logChannel));
        }
    }

    public static void prepareMatchedNumber(String string, AdbEntry adbEntry, int n, LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1078071040, "[PhoneServices#prepareMatchedNumber] Attempting to call contact %1, number = %2", (Object)adbEntry.getCombinedName(), (Object)string);
        ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(-1601830656, "[PhoneServices#prepareMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneServices$4(iTelService, adbEntry, string, n, logChannel));
        }
    }
}

